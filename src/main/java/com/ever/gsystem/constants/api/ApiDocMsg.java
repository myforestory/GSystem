package com.ever.gsystem.constants.api;

import lombok.experimental.UtilityClass;

/**
 * SwaggerのAPIドキュメントメッセージ定数クラス.
 *
 * @since   0.0.1-SNAPSHOT
 * @since   2019/11/26
 * @version 1.1.0
 * @author  Hiroshi Takano
 * @author  Akinobu Shigeishi
 */
@UtilityClass   // Lombokでインスタンスの生成をできないようにする
public final class ApiDocMsg {
    // 共通メッセージ ===========================================================================
    /** GETタイトルメッセージ. */
    public static final String GET_TITLE_MSG           = "檢索API";
    /** GETノートメッセージ. */
    public static final String GET_NOTES_CMN_MSG       = "を検索する。";
    /** GETノートメッセージ（テーブル管理系）. */
    public static final String GET_NOTES_CMN_TABLE_MSG ="的檢索。<br>"
                                                        + "您可以將兩種類型的數字以及日期和時間指定為數組。日期時間必須從「00:00:00」到「23:59:59」這段時間內。<br>"
                                                        + "数値と日時を3つ以上指定した場合は捨てられる。<br>"
                                                        + "例1：value=50&value=80 及 From=50、To=80<br>"
                                                        + "例2：value=30及From=30、To=30<br>"
                                                        + "例3：value=80&value=50及From=50、To=80<br>"
                                                        + "例4：date=2019-01-01 00:00:00&date=2019-01-01 23:59:59及From=2019/1/1開始、To=2019/1/1結束<br>"
                                                        + "列表類型可以指定超過3個。";
    /** GETタイトルメッセージ. */
    public static final String GET_RES_400_MSG         = "リクエストパラメータ検証エラー";

    /** POSTタイトルメッセージ. */
    public static final String POST_TITLE_MSG           = "登録API";
    /** POSTノートメッセージ. */
    public static final String POST_NOTES_CMN_MSG       = "を登録する。";
    /** POSTノートメッセージ（テーブル管理系）. */
    public static final String POST_NOTES_CMN_TABLE_MSG = "を登録する。<br>"
                                                          + "登録日時、更新日時はサーバ側で自動登録される。";
    /** POST200レスポンスメッセージ. */
    public static final String POST_RES_200_MSG         = "なし";
    /** POST201レスポンスメッセージ. */
    public static final String POST_RES_201_MSG         = "登録完了";
    /** POST201レスポンスメッセージ（実績ダウンロード）. */
    public static final String POST_TASK_DL_RES_201_MSG = "実績DL完了";
    /** POST400レスポンスメッセージ. */
    public static final String POST_RES_400_MSG         = "リクエストパラメータ検証エラー";
    /** POSTCSVファイル検証エラーレスポンスメッセージ. */
    public static final String POST_RES_CSV_VARID_MSG   = "CSVファイル検証エラー";

    /** PUTタイトルメッセージ. */
    public static final String PUT_TITLE_MSG           = "更新API";
    /** PUTノートメッセージ. */
    public static final String PUT_NOTES_CMN_MSG       = "を更新する。";
    /** PUTノートメッセージ（テーブル管理系）. */
    public static final String PUT_NOTES_CMN_TABLE_MSG = "を更新する。<br>"
                                                         + "登録日時は検索した値そのままを設定すること。<br>"
                                                         + "更新日時は何でも良い。サーバ側で現在時刻へ自動更新する。";
    /** PUT200レスポンスメッセージ. */
    public static final String PUT_RES_200_MSG         = "なし";
    /** PUT201レスポンスメッセージ. */
    public static final String PUT_RES_201_MSG         = "更新完了";
    /** PUT400レスポンスメッセージ. */
    public static final String PUT_RES_400_MSG         = "リクエストパラメータ検証エラー";
    /** DELETEタイトルメッセージ. */
    public static final String DEL_TITLE_MSG           = "削除API";
    /** PUTノートメッセージ. */
    public static final String DEL_NOTES_CMN_MSG       = "を削除する。";
    /** DELETE200レスポンスメッセージ. */
    public static final String DEL_RES_200_MSG         = "なし";
    /** DELETE201レスポンスメッセージ. */
    public static final String DEL_RES_204_MSG         = "削除完了";
    /** DELETE400レスポンスメッセージ. */
    public static final String DEL_RES_400_MSG         = "リクエストパラメータ検証エラー";

    /** リクエストメッセージ. */
    public static final String REQ_MSG         = "リクエストメッセージ";
    /** レスポンスメッセージ. */
    public static final String RES_MSG         = "レスポンスメッセージ";
    /** 検索用タグ. */
    public static final String FIND_TAG        = "[検索用]";
    /** 単体タグ. */
    public static final String SINGLE_TAG      = "[単体]";
    /** 複数タグ. */
    public static final String MULTI_TAG       = "[複数]";
    /** 完了通知タグ. */
    public static final String COMP_NOTICE_TAG = "[完了通知]";

    // 個別メッセージ ===========================================================================
    /** リスタートAPIルートメッセージ. */
    public static final String API_RESTART_ROOT_MSG                     = "APIサーバ再起動";
    /** リスタートAPIルートメッセージ. */
    public static final String API_RESTART_RESPONSE_MSG                 = "再起動には20～30秒を要するため、再起動リクエスト後は30秒以上待ってから作業を行ってください。";
    /** [GET]リスタートノートメッセージ. */
    public static final String API_GET_RESTART_NOTE_MSG                 = "APIサーバリスタート用のURL。<br>"
                                                                          + API_RESTART_RESPONSE_MSG
                                                                          + "<br>※設定ファイルで、再起動自体の許可とGETによる再起動が許可がされていないと機能しない";
    /** [POST]リスタートノートメッセージ. */
    public static final String API_POST_RESTART_NOTE_MSG                = "APIサーバリスタート用のURL。<br>"
                                                                          + API_RESTART_RESPONSE_MSG
                                                                          + "<br>※設定ファイルで、再起動自体の許可がされていないと機能しない";
    /** BannerMst畫面API_ROOT_MSG . */
    public static final String API_BANNER_ROOT_MSG                        = "BannerMst畫面API";
    /** テーブル管理マスタ操作APIルートメッセージ. */
    public static final String API_TABLE_MANAGEMENT_ROOT_MSG            = "テーブル管理マスタ操作API（各テーブル管理列表示・非表示機能）";



    /** 到着通知APIルートメッセージ. */
    public static final String API_ARRIVAL_NOTIFICATION_ROOT_MSG = "到着通知API";
    /** 完了通知APIルートメッセージ. */
    public static final String API_DIVERT_CONFIRM_ROOT_MSG       = "完了通知API";
    /** 発進通知APIルートメッセージ. */
    public static final String API_START_NOTIFICATION_ROOT_MSG   = "発進通知API";
    /** エラー通知APIルートメッセージ. */
    public static final String API_ERROR_NOTIFICATION_ROOT_MSG   = "エラー通知API";

    /** BannerMst. */
    public static final String BANNER_NAME                 = "BannerMst";
    /** Table管理Mst. */
    public static final String TABLE_MANAGEMENT_NAME       = "Table管理Mst";

    /** 商品マスタマッピング画面API URL. */
    public static final String MAPPING_ITEM_API_ROOT                 = "item";
    /** シュートマスタマッピング画面API URL. */
    public static final String MAPPING_CHUTE_API_ROOT                = "chute";
    /** 店舗マスタマッピング画面API URL. */
    public static final String MAPPING_SHOP_API_ROOT                 = "shop";
    /** 作業指示データマッピング画面API URL. */
    public static final String MAPPING_OPERATION_ORDER_TASK_API_ROOT = "task";
    /** CSV実績ファイルマッピング画面API URL. */
    public static final String MAPPING_CSV_RESULT_FILE_API_ROOT      = "result";
    /** マッピングルートURL説明. */
    public static final String MAPPING_ROOT_INFO                     = "<br>{mappingNo}部分には、以下が入る。<ol><li>"
                                                                       + MAPPING_ITEM_API_ROOT
                                                                       + "（商品マスタマッピング画面API）</li><li>"
                                                                       + MAPPING_CHUTE_API_ROOT
                                                                       + "（シュートマスタマッピング画面API）</li><li>"
                                                                       + MAPPING_SHOP_API_ROOT
                                                                       + "（店舗マスタマッピング画面API）</li><li>"
                                                                       + MAPPING_OPERATION_ORDER_TASK_API_ROOT
                                                                       + "（作業指示データマッピング画面API）</li><li>"
                                                                       + MAPPING_CSV_RESULT_FILE_API_ROOT
                                                                       + "（CSV実績ファイルマッピング画面API）</li>"
                                                                       + "</ol>";

    /** テーブルインポート/エクスポートルートURL説明. */
    public static final String TABLE_IE_ROOT_INFO = "<br>{mappingNo}部分には、以下が入る。<ol><li>ie-item（商品マスタインポート/エクスポート）</li><li>ie-chute（シュートマスタインポート/エクスポート）</li><li>ie-shop（店舗マスタインポート/エクスポート）</li><li>ie-batch（バッチインポート/エクスポート）</li><li>ie-task（タスクインポート/エクスポート）</li><li>ie-taskhst（タスク履歴インポート/エクスポート）</li><li>ie-device（デバイスマスタインポート/エクスポート）</li></ol>";

    /** 汎用日時. */
    public static final String COMMON_TIME_EXAMPLE     = "2022-01-02 03:04:05";
    /** 登録日時. */
    public static final String INSERT_TIME_NAME        = "登録日時";
    /** 登録日時. */
    public static final String INSERT_TIME_EXAMPLE     = "2020-01-02 03:04:05";
    /** 更新日時. */
    public static final String UPDATE_TIME_NAME        = "更新日時";
    /** 更新日時. */
    public static final String UPDATE_TIME_EXAMPLE     = "2021-01-02 03:04:05";
    /** 履歴登録日時. */
    public static final String HST_INSERT_TIME_NAME    = "履歴登録日時";
    /** 履歴登録日時. */
    public static final String HST_INSERT_TIME_EXAMPLE = "2020-01-03 03:04:05";
    /** 取得レコード開始位置. */
    public static final String OFFSET_NAME             = "取得レコード開始位置（ページネーション用）";
    /** 取得レコード数. */
    public static final String LIMIT_NAME              = "取得レコード数（ページネーション用）";
    /** ソート条件. */
    public static final String SORT_NAME               = "ソート条件 指定方法の例）id→id ASC、-id→id DESC";

    /** GETテーブル管理マスタ操作APIノートメッセージ. */
    public static final String PUT_TABLE_MANAGEMENT_NOTES_MSG = "列表示非表示機能で使用する。<br>汎用コードマスタは構造上定義してあるが、リクエストする際には必要がないため、送信するBodyに含めないこと！";
}
