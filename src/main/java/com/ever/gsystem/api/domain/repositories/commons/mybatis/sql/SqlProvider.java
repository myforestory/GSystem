package com.ever.gsystem.api.domain.repositories.commons.mybatis.sql;

import java.util.List;
import java.util.Map;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SQL;
import com.google.common.base.CaseFormat;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import com.ever.gsystem.api.controllers.msg.requests.CmnFindRequest;
import com.ever.gsystem.api.domain.entities.MstTableManagement;
import com.ever.gsystem.api.domain.repositories.commons.mybatis.conditions.TableCondition;
import com.ever.gsystem.api.domain.repositories.fieldinfo.FiledControllable;
import com.ever.gsystem.constants.entityvalue.MstTableManagementDataType;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import lombok.NonNull;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

/**
 * SQL文作成.
 * <p>
 * Mybatisで使える形式にSQL文を生成する。<br>
 * 検索条件に必要な情報が入っていること。<br>
 * {@link TableCondition}には下記情報が入っており、取得できないといけない。<br>
 * </p>
 * <ol type="1">
 * <li>{@link TableCondition#getReq()}：検索フォームの情報が入ったリクエストメッセージを設定しておく</li>
 * <li>{@link TableCondition#getTm()}：{@link com.ever.gsystem.api.domain.services.TableManagementSharedService#findByTableNo(Class...)}に取得したいエンティティクラスを渡して、事前に取得し設定しておく</li>
 * <li>{@link TableCondition#getFiledInfo()}：リポジトリが持っている{@link com.ever.gsystem.api.domain.repositories.fieldinfo.FiledControllable}を設定しておく</li>
 * </ol>
 *
 * @since   0.0.1-SNAPSHOT
 * @since   2019/11/17
 * @version 0.0.1-SNAPSHOT
 * @author  Hiroshi Takano
 */
@ToString   // LombokでtoStringを自動生成する
@Slf4j      // Lombokでロガーを定義するコードを自動生成する。このアノテーションが付いているクラスでは「log」という変数でロガーにアクセスできる
public class SqlProvider {
    /** 検索メソッド名 */
    public static final String SELET_ALL = "selectAll";
    /** 降順を表す文字列 */
    public static final String DESC_STR  = "-";

    /**
     * 検索.
     *
     * @param  <T>       テーブル系のGETリクエストメッセージ仮型
     * @param  condition 検索条件
     * @return           組み立てたSQL文
     */
    @SuppressWarnings("static-method")
    public <T> String selectAll(final TableCondition<T> condition) {
        return SqlProvider.createSql(new SQL(), condition).toString();
    }

    /**
     * テーブル管理画面のGET検索用SQL文作成.
     * <p>
     * テーブル管理画面用にSQLを作成する。<br>
     * </p>
     *
     * @param  <T>       テーブル系のGETリクエストメッセージ仮型
     * @param  sql       SQL生成クラスのインスタンス
     * @param  condition 検索条件
     * @return           組み立て後のSQL文
     */
    public static <T> SQL createSql(final SQL sql,
                                    final TableCondition<T> condition) {
        // エンティティフィールド情報取得（データタイプを取り出すために取得）
        final FiledControllable filedInfo = condition.getFiledInfo();

        // SQL文の組み立て開始 ===============================================================================================
        // ★列名一覧（DB側）取得
        // エンティティの@FiledOrderアノテーションが付与されている変数名をスネークケースのリストにする。
        // これにより、DBのカラムを表現できる。どのエンティティかは呼び出し元メソッドで設定済み。
        // 例）[product_no, product_name, ...]
        final List<String> dbColumns = filedInfo.getFiledOrderVariableSnakeCaseNamesArray();

        // ■SELECT句生成
        sql.SELECT(dbColumns.toArray(new String[dbColumns.size()]));
        log.debug("■SELECT句■ {}", dbColumns);

        final String entityClassName = filedInfo.getClassName();
        log.trace("エンティティのクラス名={}", entityClassName);

        // ★テーブル物理名ローワキャメル（Javaエンティティ側）取得
        // エンティティクラス名の最初の大文字を小文字にしてローワキャメルケースのテーブル物理名を取得する。
        // テーブル管理マスタテーブルのテーブル番号の検索を行うために使う。
        // 例）MstItem（クラス名）→mstItem（テーブル管理マスタのテーブル番号の検索用）
        final String tableNameLowerCamel = CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_CAMEL,
                                                                     entityClassName);
        log.trace("テーブル物理名ローワキャメル（エンティティのクラス名ローワキャメル）={}", tableNameLowerCamel);

        // ★テーブル物理名（DB側）取得
        // エンティティのクラス名をスネークケースにすることで「_」（アンダースコア）で区切ったDBのテーブル物理名を表現できる。
        // 例）MstItem（クラス名）→mst_item（DB側のテーブル物理名）
        final String dbTableName = CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE,
                                                             entityClassName);
        log.trace("テーブル物理名（エンティティのクラス名スネークケース）={}", dbTableName);

        // ■FROM句生成
        sql.FROM(dbTableName);
        log.debug("■FROM句■ {}", dbTableName);

        // リクエストメッセージ＝検索条件取得
        final T req = condition.getReq();
        if (req == null) {
            // 検索条件が全くない場合は、SELECT句＋FROM句のみを返却（全件検索）
            return sql;
        }

        // ★リクエストメッセージマップ
        // リクエストメッセージのキー：変数名（テーブル列名ローワキャメル）、値：変数の値のマップを取得する。
        // WHERE句をループで作るためのマップ。マップをループで回し、キーと値を下記のように使う。
        // キー：テーブル列名のローワキャメルケースとなっているので、Mybatisのプレースホルダーとして使用（#{productNo}←このproductNoの部分）
        // 値：SQL文を生成する際に判定が必要なときに使う（通常はMybatisのプレースホルダー設定をすれば値は自動的に取得されるため値により判定を行う時に使う）
        // 例）キー=productNo、値=item_001
        final Map<String, Object> reqMap = FiledControllable.pojoToMap(req.getClass(),
                                                                       req);
        log.debug("リクエストメッセージマップ={}", reqMap);

        // ★取得レコード開始位置
        final Object offsetValue = reqMap.get(CmnFindRequest.Fields.offset);
        // ■OFFCET句生成
        createOffcetSql(sql, CmnFindRequest.Fields.offset, offsetValue);

        // ★取得レコード数
        final Object limitValue = reqMap.get(CmnFindRequest.Fields.limit);
        // ■LIMIT句生成
        createLimitSql(sql, CmnFindRequest.Fields.limit, limitValue);

        // ★ソート条件
        final Object sortValue = reqMap.get(CmnFindRequest.Fields.sort);
        // ■ORDER BY句生成
        createSortSQL(sql, sortValue);

        // ■WHERE句生成
        createWhere(sql, reqMap, condition.getTm(), tableNameLowerCamel);
        // ===================================================================================================================

        return sql;
    }

    /**
     * オフセットのSQL生成.
     *
     * @param sql         SQL生成クラスのインスタンス
     * @param placeholder SQLのプレースホルダー名
     * @param offsetValue オフセット値（取得レコード開始位置）
     */
    public static void createOffcetSql(final SQL sql, final String placeholder,
                                       final Object offsetValue) {
        // オフセット値がnullの場合は何もしない
        if (offsetValue == null) {
            return;
        }
        // OFFSET句生成
        sql.OFFSET(enclosePlaceholder(placeholder));
        log.debug("■OFFSET句■ 取得レコード開始位置={}", offsetValue);
    }

    /**
     * リミットのSQL生成.
     *
     * @param sql         SQL生成クラスのインスタンス
     * @param placeholder SQLのプレースホルダー名
     * @param limitValue  リミット値（取得レコード数）
     */
    public static void createLimitSql(final SQL sql, final String placeholder,
                                      final Object limitValue) {
        // リミット値がnullの場合は何もしない
        if (limitValue == null) {
            return;
        }
        // LIMIT句生成
        sql.LIMIT(enclosePlaceholder(placeholder));
        log.debug("■LIMIT句■ 取得レコード数={}", limitValue);
    }

    /**
     * ソート（ORDER BY）のSQL生成.
     *
     * @param sql       SQL生成クラスのインスタンス
     * @param sortValue ソートリスト
     */
    @SuppressFBWarnings(value = "PDP_POORLY_DEFINED_PARAMETER", justification = "[Bug kind:PDP]曖昧な型のオブジェクトをキャストしている(Object→Iterable<String>)。設計上どうしても避けられないキャストなので許して貰う。")
    public static void createSortSQL(final SQL sql, final Object sortValue) {
        // ソートリストがnullの場合は何もしない
        if (sortValue == null) {
            return;
        }

        @SuppressWarnings("unchecked")
        final Iterable<String> sorts = (Iterable<String>) sortValue;

        // ソートリスト分ループする
        for (final String sort : sorts) {
            // ソート値がnullの場合は何もしない
            if (sort == null) {
                continue;
            }

            final String OrderBySql;
            // ASC（昇順）かDESC（降順）か判断する
            if (sort.startsWith(DESC_STR)) {
                // ●降順

                // 先頭の降順を表す文字を削除する
                final String descSort = StringUtils.removeStart(sort, DESC_STR);

                // ローワキャメルケースをDBで認識できるかたちに置き換える（ローワキャメルケース→スネークケース）
                OrderBySql = CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE,
                                                       descSort)
                             + " DESC";
            } else {
                // ●昇順

                // ローワキャメルケースをDBで認識できるかたちに置き換える（ローワキャメルケース→スネークケース）
                OrderBySql = CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE,
                                                       sort)
                             + " ASC";
            }

            // ORDER BY句生成
            sql.ORDER_BY(OrderBySql);
            log.debug("■ORDER BY句■ ソート条件（ORDER BY）設定={}", OrderBySql);
        }
    }

    /**
     * WHERE句作成.
     *
     * @param sql                 SQL生成クラスのインスタンス
     * @param reqMap              リクエストマップ。キー：変数名（テーブル列名ローワキャメル）、値：変数の値
     * @param mstTableManagement  テーブル管理マスタリスト
     * @param tableNameLowerCamel テーブル物理名ローワキャメル（例：mstItem）。テーブル管理マスタのテーブル番号の検索値として利用する
     */
    private static void createWhere(final SQL sql,
                                    final Map<String, Object> reqMap,
                                    final List<MstTableManagement> mstTableManagement,
                                    final String tableNameLowerCamel) {
        // ★テーブル管理マスタテーブル
        // データタイプを取り出すために、2つのキーと1つの値を持った「テーブル」という型を利用する。
        // キー1：テーブル管理マスタテーブルのテーブル番号（テーブル物理名ローワキャメル）
        // キー2：テーブル管理マスタテーブルの中間システム項目番号（テーブル列名ローワキャメル）
        // 値：両方のキーに該当するデータタイプ
        // 例）キー1=mstItem、キー2=productNo、値=0（テキストタイプ）
        final Table<String, String, Byte> tmTbl = HashBasedTable.create();
        if (mstTableManagement != null) {
            for (final MstTableManagement tm : mstTableManagement) {
                tmTbl.put(tm.getTableNo(), tm.getIsItemNo(), tm.getDataType());
            }
        }
        log.debug("テーブル管理マスタテーブル={}", tmTbl);

        // WHERE句生成ループ
        for (final Map.Entry<String, Object> entry : reqMap.entrySet()) {
            // ★中間システム項目番号
            // リクエストメッセージマップのキー（リクエストメッセージの変数名＝テーブル列名のローワキャメルケース）を取得。
            final String isItemNo = entry.getKey();

            // ★列名（DB側）
            // 中間システム項目番号をスネークケースにすることで「_」（アンダースコア）で区切ったDBのテーブル列名を表現できる。
            // 例：productNo→product_no（DB側のテーブル列名）
            final String dbColName = CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE,
                                                               isItemNo);

            // ★検索値（DB側だけど判定のみに使用）
            // リクエストメッセージマップの値（＝テーブルの検索データ）を取得
            final Object searchValue = entry.getValue();

            // ★データタイプ（java判定用）
            // WHERE句を作るためのパターン分けに使用
            final Byte dataType = tmTbl.get(tableNameLowerCamel, isItemNo);

            // 検索値がリクエストメッセージに存在するか
            if (searchValue == null) {
                log.trace("検索値が存在しないためスキップ。列名={}、プレースホルダー={}、検索値=null、データタイプ={}",
                          dbColName, isItemNo, dataType);
                continue;
            }
            // ●以降は、リクエストメッセージに検索データが存在した

            // データタイプが存在するか
            if (dataType == null) {
                // ●データタイプ未定義の場合は何もしない（できない）
                // メモ:offset、limit、sortにデータがある場合は、リクエストメッセージに入っているためこの処理へと入る
                log.trace("データタイプが存在しないためスキップ。列名={}、プレースホルダー={}、検索値={}、データタイプ=null",
                          dbColName, isItemNo, searchValue);
                continue;
            }

            log.trace("WHERE句生成。列名={}、プレースホルダー={}、検索値={}、データタイプ={}", dbColName,
                      isItemNo, searchValue, dataType);

            // テーブル管理マスタのデータタイプにより、処理を分ける
            switch (dataType.byteValue()) {
                case MstTableManagementDataType.TEXT_TYPE: // テキスト
                    // ■テキストタイプのSQLを生成（WHERE句設定はこの中で行う）
                    createWhereTextTypeSQL(sql, dbColName, isItemNo);
                    break;
                case MstTableManagementDataType.NUM_TYPE: // 数値
                    // ■数値タイプのSQLを生成（WHERE句設定はこの中で行う）
                    createWhereNumOrDateTypeSQL(sql, dbColName, isItemNo,
                                                searchValue,
                                                dataType.byteValue());
                    break;
                case MstTableManagementDataType.LIST_TYPE: // リスト
                    // ■リストタイプのSQLを生成（WHERE句設定はこの中で行う）
                    createWhereListTypeSQL(sql, dbColName, isItemNo,
                                           searchValue);
                    break;
                case MstTableManagementDataType.DATE_TYPE: // 日時
                    // ■日時タイプのSQLを生成（WHERE句設定はこの中で行う）
                    createWhereNumOrDateTypeSQL(sql, dbColName, isItemNo,
                                                searchValue,
                                                dataType.byteValue());
                    break;
                default:
                    log.warn("■エラー■ データタイプ：不明（{}）", dataType);
                    break;
            }
        }
    }

    /**
     * WHERE句テキストタイプのSQL生成.
     *
     * @param sql         SQL生成クラスのインスタンス
     * @param dbColName   テーブル列名。エンティティクラスのクラス名をスネークケースに変換したもの
     * @param placeholder SQLのプレースホルダー名
     */
    public static void createWhereTextTypeSQL(final SQL sql,
                                              final String dbColName,
                                              final String placeholder) {
        // LIKE部分一致SQL生成
        final String textSql = partialMatchLike(dbColName, placeholder);
        // WHERE句に追加
        sql.WHERE(textSql);
        log.debug("■WHERE句■ データタイプ：テキスト、追加SQL文：\"{}\"", textSql);
    }

    /**
     * WHERE句数値タイプのSQL生成.
     *
     * @param sql         SQL生成クラスのインスタンス
     * @param dbColName   テーブル列名。エンティティクラスのクラス名をスネークケースに変換したもの
     * @param placeholder SQLのプレースホルダー名
     * @param searchValue 検索したい数値リスト
     * @param dataType    データタイプ
     */
    @SuppressFBWarnings(value = "PDP_POORLY_DEFINED_PARAMETER", justification = "[Bug kind:PDP]曖昧な型のオブジェクトをキャストしている(Object→List<Object>)。設計上どうしても避けられないキャストなので許して貰う。")
    public static void createWhereNumOrDateTypeSQL(final SQL sql,
                                                   final String dbColName,
                                                   final String placeholder,
                                                   final Object searchValue,
                                                   final byte dataType) {
        // 中身を取り出す
        @SuppressWarnings("unchecked")
        final List<Object> searchList = (List<Object>) searchValue;

        // 空リストの場合は何もしない
        if (CollectionUtils.isEmpty(searchList)) {
            log.warn("■エラー■ リストを取り出そうとしましたが空リストでした。プレースホルダー={}、値={}",
                     placeholder, searchValue);
            return;
        }

        Object array0 = null;    // リスト配列番号0の値（リスト1番目の中身）
        Object array1 = null;    // リスト配列番号1の値（リスト2番目の中身）
        // リストのサイズから比較対象を何個取得するか決める
        switch (searchList.size()) {
            case 1: // fromかtoどちらか一つが入力されたパターン
                array0 = searchList.get(0);
                break;
            case 2: // fromとtoがあるパターン。
                array0 = searchList.get(0);
                array1 = searchList.get(1);
                break;
            default:    // 3つ以上のパターン（数値リストを三つ以上指定しなければ通常はありえないパターン）
                array0 = searchList.get(0);
                array1 = searchList.get(1);
                log.warn("数値リストを取り出そうとしましたが3つ以上ありました。プレースホルダー={}、値={}",
                         placeholder, searchValue);
                break;
        }

        final Integer from; // 最小値側の配列番号を入れる（0か1）※値を入れるわけではない
        final Integer to;   // 最大値側の配列番号を入れる（0か1）※値を入れるわけではない
        // 比較対象の値同士がnullかどうかを見て、fromとtoの配列番号を設定する
        if (array0 == null) {
            // ●リスト配列番号0の中身がなし

            if (array1 != null) {
                // ●リスト配列番号1しか中身がないため、fromとtoに配列番号1を設定する
                from = Integer.valueOf("1");
                to   = Integer.valueOf("1");
                log.trace("最小値={}、最大値={}、{}[{}] == {}[{}]", array1, array1,
                          placeholder, from, placeholder, to);
            } else {
                // ●リスト配列番号0も1も中身なし。異常なパターン

                from = null;
                to   = null;
                log.warn("最小値=null、最大値=null、{}[{}] == {}[{}]", placeholder,
                         from, placeholder, to);
            }
        } else if (array1 == null) {
            // ●リスト配列番号1の中身がなし＝リスト配列番号0しか中身がないため、fromとtoに配列番号0を設定する

            from = Integer.valueOf("0");
            to   = Integer.valueOf("0");
            log.trace("最小値={}、最大値={}、{}[{}] == {}[{}]", array0, array0,
                      placeholder, from, placeholder, to);
        } else {
            // ●リスト配列番号0と1両方とも中身がある

            // データタイプによって比較方法を変える
            final boolean conditionResult;
            if (dataType == MstTableManagementDataType.NUM_TYPE) {
                // 数値の比較
                final Number numArray0 = (Number) array0;
                final Number numArray1 = (Number) array1;
                conditionResult = numArray0.longValue() <= numArray1.longValue();
            } else {
                // 日付の比較
                final java.util.Date dateArray0 = (java.util.Date) array0;
                final java.util.Date dateArray1 = (java.util.Date) array1;
                conditionResult = dateArray0.compareTo(dateArray1) <= 0;
            }

            // 大小比較結果
            if (conditionResult) {
                // ●リスト配列番号0の数値より1の数値が大きいため、fromに配列番号0、toに配列番号1とする

                from = Integer.valueOf("0");
                to   = Integer.valueOf("1");
                log.trace("最小値={}、最大値={}、{}[{}] <= {}[{}]", array0, array1,
                          placeholder, from, placeholder, to);
            } else {
                // ●リスト配列番号0の数値より1の数値が小さいため、fromに配列番号1、toに配列番号0とする

                from = Integer.valueOf("1");
                to   = Integer.valueOf("0");
                log.trace("最小値={}、最大値={}、{}[{}] < {}[{}]", array1, array0,
                          placeholder, from, placeholder, to);
            }
        }

        // SQL生成前最終確認
        if (array0 == null && array1 == null) {
            // 値がどちらも存在しない場合、WHERE句の作成は行わない
            log.warn("■エラー■ 数値リストの配列自体はありましたが、値がnullでした。プレースホルダー={}、値={}",
                     placeholder, searchValue);
        } else {
            // 必ずfromとtoには何かしらの値が設定されているため、SQL生成を行う

            // BETWEEN検索SQL生成
            final String numSql = between(dbColName, from, to, placeholder);
            // WHERE句に追加
            sql.WHERE(numSql);
            final String dataTypeStr;
            if (dataType == MstTableManagementDataType.NUM_TYPE) {
                dataTypeStr = "数値";
            } else {
                dataTypeStr = "日時";
            }
            log.debug("■WHERE句■ データタイプ：{}、追加SQL文：\"{}\"", dataTypeStr, numSql);
        }
    }

    /**
     * WHERE句リストタイプのSQL生成.
     *
     * @param sql         SQL生成クラスのインスタンス
     * @param dbColName   テーブル列名。エンティティクラスのクラス名をスネークケースに変換したもの
     * @param placeholder SQLのプレースホルダー名
     * @param searchValue 検索したい数値リスト
     */
    @SuppressFBWarnings(value = {"PDP_POORLY_DEFINED_PARAMETER",
                                 "DLS_DEAD_LOCAL_STORE"}, justification = "[Bug kind:PDP]曖昧な型のオブジェクトをキャストしている(Object→Iterable<Object>)。設計上どうしても避けられないキャストなので許して貰う。\r\n"
                                                                          + "[Bug kind:DLS]listへ無効な代入をしている。実際には無効な代入ではないため、バイトコードレベルで無意味な格納をしている箇所があるものと思われる。ソース上では問題ないため、誤検知とする。")
    public static void createWhereListTypeSQL(final SQL sql,
                                              final String dbColName,
                                              final String placeholder,
                                              @NonNull final Object searchValue) {
        @SuppressWarnings("unchecked")
        final Iterable<Object> list = (Iterable<Object>) searchValue;

        // IN句SQL生成
        final String textSql = in(dbColName, placeholder, list);

        // WHERE句に追加
        sql.WHERE(textSql);
        log.debug("■WHERE句■ データタイプ：リスト、追加SQL文：\"{}\"", textSql);
    }

    // === 以下、ユティリティメソッド =============================================================================
    /**
     * プレースホルダーを囲む.
     * <p>
     * プレースホルダーをそのままでは使えないため、Mybatisで認識できるように囲み文字で囲む。
     * </p>
     *
     * @param  placeholder プレースホルダ。例：id（req.idとするとid部分）
     * @return             囲んだ後のプレースホルダー。例：#{req.id}
     */
    public static String enclosePlaceholder(final String placeholder) {
        return enclosePlaceholder(TableCondition.Fields.req, placeholder);
    }

    /**
     * プレースホルダーを囲む.
     * <p>
     * プレースホルダーをそのままでは使えないため、Mybatisで認識できるように囲み文字で囲む。
     * </p>
     *
     * @param  parentPlaceholder 親プレースホルダ。例：req（req.idとするとreq部分）
     * @param  placeholder       プレースホルダ。例：id（req.idとするとid部分）
     * @return                   囲んだ後のプレースホルダー。例：#{req.id}
     */
    public static String enclosePlaceholder(final String parentPlaceholder,
                                            final String placeholder) {
        if (parentPlaceholder == null) {
            return "#{" + placeholder + "}";
        }
        return "#{" + parentPlaceholder + "." + placeholder + "}";
    }

    /**
     * プレースホルダの配列を作成する.
     *
     * @param  placeholder プレースホルダ。例：id（req.idとするとid部分）
     * @param  arrayNum    配列番号
     * @return             囲んだ後のプレースホルダー。例：#{req.id}
     */
    public static String placeholderList(final String placeholder,
                                         final int arrayNum) {
        return enclosePlaceholder(placeholder + "[" + arrayNum + "]");
    }

    /**
     * LIKE演算子部分一致生成.
     * <p>
     * LIKE演算子を使って、部分一致をするための文字列を生成する。
     * </p>
     *
     * @param  dbColName   DB側で認識できる列名（スネークケース）
     * @param  placeholder 囲み文字とフル指定ではない、プレースホルダー。例：id（×req.idはダメ、#{req.id}もダメ。この中でそれらを生成する）
     * @return             生成されたSQL文
     */
    public static String partialMatchLike(final String dbColName,
                                          final String placeholder) {
        // Mybatisでプレースホルダーを認識させるために、素のプレースホルダーに囲み文字を追加する
        final String fullPlaceholder = enclosePlaceholder(placeholder);
        // SQL文生成
        return dbColName + " LIKE CONCAT('%'," + fullPlaceholder + ",'%')";
    }

    /**
     * BETWEEN演算子生成.
     * <p>
     * 数値の範囲検索のためのSQLを生成する。
     * </p>
     *
     * @param  dbColName   DB側で認識できる列名（スネークケース）
     * @param  from        範囲の最小値
     * @param  to          範囲の最大値
     * @param  placeholder 囲み文字とフル指定ではない、プレースホルダー。例：id（×req.idはダメ、#{req.id}もダメ。この中でそれらを生成する）
     * @return             生成されたSQL文
     */
    public static String between(final String dbColName, final Integer from,
                                 final Integer to, final String placeholder) {
        // Mybatisでプレースホルダーを認識させるために、素のプレースホルダーに囲み文字を追加する
        final String fullPlaceholderFrom = placeholderList(placeholder,
                                                           from.intValue());
        final String fullPlaceholderTo   = placeholderList(placeholder,
                                                           to.intValue());
        // SQL文生成
        return dbColName
               + " BETWEEN " + fullPlaceholderFrom + " AND "
               + fullPlaceholderTo;
    }

    /**
     * IN句生成.
     * <p>
     * IN句を生成する。
     * </p>
     *
     * @param  dbColName   DB側で認識できる列名（スネークケース）
     * @param  placeholder 囲み文字とフル指定ではない、プレースホルダー。例：id（×req.idはダメ、#{req.id}もダメ。この中でそれらを生成する）
     * @param  searchList  検索データリスト
     * @return             生成されたSQL文
     */
    public static String in(final String dbColName, final String placeholder,
                            final Iterable<Object> searchList) {
        final StringBuilder inSql = new StringBuilder(dbColName);
        inSql.append(" IN (");

        // 検索データ分ループ
        int i = 0;
        for (@SuppressWarnings("unused")
        final Object searchValue : searchList) {
            if (i != 0) {
                inSql.append(", ");
            }

            // Mybatisでプレースホルダーを認識させるために、素のプレースホルダーに囲み文字を追加する
            final String fullPlaceholder = placeholderList(placeholder, i);
            inSql.append(fullPlaceholder);
            i++;
        }
        inSql.append(')');

        return inSql.toString();
    }
}
