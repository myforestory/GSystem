package com.ever.gsystem.api.domain.repositories.commons.mybatis.conditions;

import java.io.Serializable;
import java.util.List;
import com.ever.gsystem.api.domain.entities.MstTableManagement;
import com.ever.gsystem.api.domain.repositories.fieldinfo.FiledControllable;
import lombok.AllArgsConstructor;
import lombok.Value;
import lombok.experimental.FieldNameConstants;

/**
 * テーブル管理画面のGET検索条件.
 * <p>
 * テーブル管理画面のGETリクエスト用検索条件
 * </p>
 *
 * @param   <T> テーブル管理画面のGETリクエストメッセージ仮型
 * @since   0.0.1-SNAPSHOT
 * @since   2020/09/23
 * @version 0.0.1-SNAPSHOT
 * @author  Zeng YanYun
 */
@Value                      // Lombokですべてのフィールドのgetter/equals/hashCode/toStringとすべてのフィールドの値をセットするための引数付きコンストラクタを自動生成する
@AllArgsConstructor         // Lombokですべてのフィールドの値をセットするための引数付きコンストラクタを自動生成する
@FieldNameConstants         // Lombokでフィールドの変数名を定数化する。[クラス].Fields.[変数名]でフィールド名をstaticアクセスできる。例）MstItem.Fields.productNoで"productNo"が取り出せる。
public class TableCondition<T> implements Serializable {
    /** シリアルバージョンUID（このクラスに変化があったら値を変更する）. */
    private static final long serialVersionUID = 5814763235453073484L;

    /** テーブル管理のGETリクエストメッセージ. */
    private T                        req;
    /** テーブル管理マスタリスト. */
    private List<MstTableManagement> tm;
    /** エンティティフィールド情報. */
    private FiledControllable        filedInfo;
}
