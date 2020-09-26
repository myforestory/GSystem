package com.ever.gsystem.constants.api;

import lombok.experimental.UtilityClass;

/**
 * SwaggerのAPIドキュメントMESSAGE定数クラス.
 *
 * @since   0.0.1-SNAPSHOT
 * @since   2019/11/26
 * @version 1.1.0
 * @author  Hiroshi Takano
 * @author  Akinobu Shigeishi
 */
@UtilityClass   // Lombokでインスタンスの生成をできないようにする
public final class ApiDocMsg {
    // 共通MESSAGE ===========================================================================
    /** GET TITLE MESSAGE. */
    public static final String GET_TITLE_MSG           = "檢索API";
    /** GET NOTE MESSAGE. */
    public static final String GET_NOTES_CMN_MSG       = "已檢索。";
    /** GET NOTE MESSAGE（TABLE 管理）. */
    public static final String GET_NOTES_CMN_TABLE_MSG ="的檢索。<br>"
                                                        + "您可以將兩種類型的數字以及日期和時間指定為數組。日期時間必須從「00:00:00」到「23:59:59」這段時間內。<br>"
                                                        + "例1：value=50&value=80 及 From=50、To=80<br>"
                                                        + "例2：value=30及From=30、To=30<br>"
                                                        + "例3：value=80&value=50及From=50、To=80<br>"
                                                        + "例4：date=2019-01-01 00:00:00&date=2019-01-01 23:59:59及From=2019/1/1開始、To=2019/1/1結束<br>"
                                                        + "列表類型可以指定超過3個。";
    /** GET TITLE MESSAGE. */
    public static final String GET_RES_400_MSG         = "REQUEST PARAMETER錯誤訊息";

    /** POST TITLE MESSAGE. */
    public static final String POST_TITLE_MSG           = "登録API";
    /** POST NOTE MESSAGE. */
    public static final String POST_NOTES_CMN_MSG       = "已登錄。";
    /** POST NOTE MESSAGE（TABLE 管理）. */
    public static final String POST_NOTES_CMN_TABLE_MSG = "已登錄。<br>"
                                                          + "登録日時、更新日時は SERVER側で自動登録される。";
    /** POST200 RESPONSE MESSAGE. */
    public static final String POST_RES_200_MSG         = "無";
    /** POST201 RESPONSE MESSAGE. */
    public static final String POST_RES_201_MSG         = "登録完成";
    /** POST201 RESPONSE MESSAGE（実績DOWNLOAD）. */
    public static final String POST_TASK_DL_RES_201_MSG = "実績DL完成";
    /** POST400 RESPONSE MESSAGE. */
    public static final String POST_RES_400_MSG         = "REQUEST PARAMETER錯誤訊息";

    /** PUT TITLE MESSAGE. */
    public static final String PUT_TITLE_MSG           = "更新API";
    /** PUT NOTE MESSAGE. */
    public static final String PUT_NOTES_CMN_MSG       = "已更新";
    /** PUT NOTE MESSAGE（TABLE 管理）. */
    public static final String PUT_NOTES_CMN_TABLE_MSG = "已更新<br>"
                                                         + "登録日時は検索した値そのままを設定すること。<br>"
                                                         + "更新日時は何でも良い。 SERVER側で現在時刻へ自動更新する。";
    /** PUT200 RESPONSE MESSAGE. */
    public static final String PUT_RES_200_MSG         = "無";
    /** PUT201 RESPONSE MESSAGE. */
    public static final String PUT_RES_201_MSG         = "更新完成";
    /** PUT400 RESPONSE MESSAGE. */
    public static final String PUT_RES_400_MSG         = "REQUEST PARAMETER錯誤訊息";
    /** DELETE TITLE MESSAGE. */
    public static final String DEL_TITLE_MSG           = "刪除API";
    /** PUT NOTE MESSAGE. */
    public static final String DEL_NOTES_CMN_MSG       = "已刪除。";
    /** DELETE200 RESPONSE MESSAGE. */
    public static final String DEL_RES_200_MSG         = "無";
    /** DELETE201 RESPONSE MESSAGE. */
    public static final String DEL_RES_204_MSG         = "刪除完成";
    /** DELETE400 RESPONSE MESSAGE. */
    public static final String DEL_RES_400_MSG         = "REQUEST PARAMETER錯誤訊息";

    /** REQUEST MESSAGE. */
    public static final String REQ_MSG         = "REQUEST MESSAGE";
    /** RESPONSE MESSAGE. */
    public static final String RES_MSG         = "RESPONSE MESSAGE";
    /** 檢索用TAG. */
    public static final String FIND_TAG        = "[檢索用]";
    /** 單體TAG. */
    public static final String SINGLE_TAG      = "[單體]";
    /** 複数TAG. */
    public static final String MULTI_TAG       = "[複數]";
    /** 完成通知TAG. */
    public static final String COMP_NOTICE_TAG = "[完成通知]";

    // 個別MESSAGE ===========================================================================
    /** RESTART API ROOT MESSAGE. */
    public static final String API_RESTART_ROOT_MSG                     = "API SERVER再起動";
    /** RESTART API ROOT MESSAGE. */
    public static final String API_RESTART_RESPONSE_MSG                 = "再啟動需花費20-30秒，請稍待片刻。";
    /** [GET]RESTART NOTE MESSAGE. */
    public static final String API_GET_RESTART_NOTE_MSG                 = "API SEVER REQUEST用URL。<br>"
                                                                          + API_RESTART_RESPONSE_MSG
                                                                          + "<br>※設定ファイルで、再起動自体の許可とGETによる再起動が許可がされていないと機能しない";
    /** [POST]RESTART NOTE MESSAGE. */
    public static final String API_POST_RESTART_NOTE_MSG                = "API SEVER REQUEST用URL。<br>"
                                                                          + API_RESTART_RESPONSE_MSG
                                                                          + "<br>※設定ファイルで、再起動自体の許可がされていないと機能しない";
    /**  TABLE管理MASTER操作APIルートMESSAGE. */
    public static final String API_TABLE_MANAGEMENT_ROOT_MSG            = " TABLE管理MASTER操作API（各 TABLE管理列表示・非表示機能）";
    /** BannerMst畫面API_ROOT_MSG . */
    public static final String API_BANNER_ROOT_MSG                      = "BannerMst畫面API";
    /** InformManagementMst畫面API_ROOT_MSG . */
    public static final String API_INFORM_MANAGEMENT_ROOT_MSG           = "InformManagementMst畫面API";
    /** InformMst畫面API_ROOT_MSG . */
    public static final String API_INFORM_ROOT_MSG                      = "InformMst畫面API";

    /** Table管理Mst. */
    public static final String TABLE_MANAGEMENT_NAME       = "Table管理Mst";
    /** BannerMst. */
    public static final String BANNER_NAME                 = "BannerMst";
    /** InformManagementMst. */
    public static final String INFORM_MANAGEMENT_NAME      = "InformManagementMst";
    /** InformMst. */
    public static final String INFORM_NAME      = "InformMst";

    /** 商品MASTERマッピング画面API URL. */
    public static final String MAPPING_ITEM_API_ROOT                 = "item";
    /** シュートMASTERマッピング画面API URL. */
    public static final String MAPPING_CHUTE_API_ROOT                = "chute";
    /** 店舗MASTERマッピング画面API URL. */
    public static final String MAPPING_SHOP_API_ROOT                 = "shop";
    /** 作業指示データマッピング画面API URL. */
    public static final String MAPPING_OPERATION_ORDER_TASK_API_ROOT = "task";
    /** CSV実績ファイルマッピング画面API URL. */
    public static final String MAPPING_CSV_RESULT_FILE_API_ROOT      = "result";
    /** マッピングルートURL説明. */
    public static final String MAPPING_ROOT_INFO                     = "<br>{mappingNo}部分には、以下が入る。<ol><li>"
                                                                       + MAPPING_ITEM_API_ROOT
                                                                       + "（商品MASTERマッピング画面API）</li><li>"
                                                                       + MAPPING_CHUTE_API_ROOT
                                                                       + "（シュートMASTERマッピング画面API）</li><li>"
                                                                       + MAPPING_SHOP_API_ROOT
                                                                       + "（店舗MASTERマッピング画面API）</li><li>"
                                                                       + MAPPING_OPERATION_ORDER_TASK_API_ROOT
                                                                       + "（作業指示データマッピング画面API）</li><li>"
                                                                       + MAPPING_CSV_RESULT_FILE_API_ROOT
                                                                       + "（CSV実績ファイルマッピング画面API）</li>"
                                                                       + "</ol>";

    /**  TABLEインポート/エクスポートルートURL説明. */
    public static final String TABLE_IE_ROOT_INFO = "<br>{mappingNo}部分には、以下が入る。<ol><li>ie-item（商品MASTERインポート/エクスポート）</li><li>ie-chute（シュートMASTERインポート/エクスポート）</li><li>ie-shop（店舗MASTERインポート/エクスポート）</li><li>ie-batch（バッチインポート/エクスポート）</li><li>ie-task（タスクインポート/エクスポート）</li><li>ie-taskhst（タスク履歴インポート/エクスポート）</li><li>ie-device（デバイスMASTERインポート/エクスポート）</li></ol>";

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
    /** 取得資料開始位置. */
    public static final String OFFSET_NAME             = "取得資料開始位置（分頁用）";
    /** 取得資料数. */
    public static final String LIMIT_NAME              = "取得資料数（分頁用）";
    /** SORT條件. */
    public static final String SORT_NAME               = "SORT條件 指定方法範例）id→id ASC、-id→id DESC";

    /** GET TABLE管理MASTER操作API NOTE MESSAGE. */
    public static final String PUT_TABLE_MANAGEMENT_NOTES_MSG = "列表示非表示機能で使用する。<br>汎用コードMASTERは構造上定義してあるが、リクエストする際には必要がないため、送信するBodyに含めないこと！";
}
