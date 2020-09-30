package com.ever.gsystem.constants.api;

import lombok.experimental.UtilityClass;

/**
 * エンドポイントURI文字列定数クラス.
 * <p>
 * リクエストマッピング用のURL文字列定数クラス<br>
 * {@link com.plus_automation.api.app.controllers}配下で使用。<br>
 * </p>
 *
 * @since   0.0.1-SNAPSHOT
 * @since   2019/11/24
 * @version 1.1.0
 * @author  Hiroshi Takano
 * @author  Akinobu Shigeishi
 */
@UtilityClass   // Lombokでインスタンスの生成をできないようにする
public final class EndpointUri {
    // トップ ================================================================================================================
    /** indexページ ルートURL（※必ず「/」で終わる）. */
    public static final String TOP_ROOT           = "/";
    /** 分析画面API（バッチ別進捗確認＋シュート別進捗確認）ルートURL. */
    public static final String DASHBOARD_API_ROOT = TOP_ROOT + "dashboard";
    /** リスタートURL. */
    public static final String RESTART_API_ROOT   = TOP_ROOT + "restart";
    // =======================================================================================================================


    // マッピング系 ==========================================================================================================
    /** マッピング画面API 親URL. */
    public static final String MAPPING_API_PARENT = TOP_ROOT + "mapping";
    /**
     * マッピング画面API 子URL.
     * <p>
     * 「{}」で囲むことによって、URLの値を引数として取得することができる（取得する際は、{@literal @}{@link org.springframework.web.bind.annotation.PathVariable
     * PathVariable}を付ける）。<br>
     * また、{パラメータ名:正規表現}のように右側に正規表現を書くことにより、URLのバリデーションを行うことができる。<br>
     * </p>
     */
    public static final String MAPPING_API_CHILD  = "{mappingNo:^(?:item|chute|shop|task|result)$}";  // memo:「?:」は「()」によるグループ化はするが、キャプチャはしないことを明示するために付ける（これがないと落ちる）
    /** マッピング画面API ルートURL. */
    public static final String MAPPING_API_ROOT   = MAPPING_API_PARENT
                                                    + "/" + MAPPING_API_CHILD;
    // =======================================================================================================================


    // アップロード系 ========================================================================================================
    /** アップロードAPI ルートURL. */
    public static final String UPLOAD_API_ROOT = TOP_ROOT + "upload";
    // =======================================================================================================================


    // テーブル管理共通 ======================================================================================================
    /** テーブル管理マスタ操作API（各テーブル管理列表示・非表示機能） ルートURL. */
    public static final String TABLE_MNG_API_ROOT = TOP_ROOT + "table";
    // =======================================================================================================================


    // Master管理 ==========================================================================================================
    /** 首頁BannerMaster畫面畫面API RootURL. */
    public static final String TABLE_BANNER_API_ROOT                     = TOP_ROOT
                                                                         + "master/banner";
    /** 訊息類別管理Master畫面API RootURL. */
    public static final String TABLE_INFORM_MANAGEMENT_API_ROOT          = TOP_ROOT
                                                                         + "master/inform-management";
    /** 通知消息Master畫面API RootURL. */
    public static final String TABLE_INFORM_API_ROOT                     = TOP_ROOT
                                                                         + "master/inform";
    /** 系統管理者Master畫面API RootURL. */
    public static final String TABLE_ADMINISTRATOR_API_ROOT              = TOP_ROOT
                                                                         + "master/administrator";
    /** 會員Master畫面API RootURL. */
    public static final String TABLE_MEMBER_API_ROOT                     = TOP_ROOT
                                                                         + "master/member";
    /** 點數管理Master畫面API RootURL. */
    public static final String TABLE_POINT_MANAGEMENT_API_ROOT           = TOP_ROOT
                                                                         + "master/point-management";
    // =======================================================================================================================


    // 作業系 ================================================================================================================
    /** バッチ管理画面API ルートURL. */
    public static final String TABLE_BATCH_API_ROOT   = TOP_ROOT + "work/batch";
    /** タスク明細画面API ルートURL. */
    public static final String TABLE_TASK_API_ROOT    = TOP_ROOT + "work/task";
    /** タスク履歴画面API ルートURL. */
    public static final String TABLE_TASKHST_API_ROOT = TOP_ROOT
                                                        + "work/taskhst";
    // =======================================================================================================================


    // 機能系 ================================================================================================================
    /** バッチ開始機能API ルートURL. */
    public static final String FUNC_BATCH_START_API_ROOT                 = TOP_ROOT
                                                                           + "func/batch/start";
    /** バッチ一時保留処理機能API ルートURL. */
    public static final String FUNC_BATCH_TEMPORARY_HOLDING_ON_API_ROOT  = TOP_ROOT
                                                                           + "func/batch/temporary-holding-on";
    /** バッチ一時保留解除処理機能API ルートURL. */
    public static final String FUNC_BATCH_TEMPORARY_HOLDING_OFF_API_ROOT = TOP_ROOT
                                                                           + "func/batch/temporary-holding-off";
    /** バッチ取り消し処理機能API ルートURL. */
    public static final String FUNC_BATCH_CANCEL_API_ROOT                = TOP_ROOT
                                                                           + "func/batch/cancel";
    /** バッチ終了機能API ルートURL. */
    public static final String FUNC_BATCH_END_API_ROOT                   = TOP_ROOT
                                                                           + "func/batch/end";
    /** タスクシュート割付機能API ルートURL. */
    public static final String FUNC_TASK_CHUTE_ASSIGN_API_ROOT           = TOP_ROOT
                                                                           + "func/task/assign";
    /** タスク実績DL機能API ルートURL. */
    public static final String FUNC_TASK_RESULT_DL_API_ROOT              = TOP_ROOT
                                                                           + "func/task/dl";
    /** ソートレスポンスAPI ルートURL. */
    public static final String FUNC_SORT_RESPONSE_API_ROOT               = TOP_ROOT
                                                                           + "func/sort-response";
    /** プラン選択機能API ルートURL. */
    public static final String FUNC_PLAN_SELECTION_API_ROOT              = TOP_ROOT
                                                                           + "func/plan-selection";
    /** シュート取得API ルートURL. */
    public static final String FUNC_GET_CHUTE_API_ROOT                   = TOP_ROOT
                                                                           + "func/get-chute";
    /** シュートラベル取得API ルートURL. */
    public static final String FUNC_GET_CHUTE_LABEL_API_ROOT             = TOP_ROOT
                                                                           + "func/get-chute-label";
    /** シュート更新API ルートURL. */
    public static final String FUNC_UPDATE_CHUTE_API_ROOT                = TOP_ROOT
                                                                           + "func/update-chute";
    /** デバイス情報取得API ルートURL. */
    public static final String FUNC_GET_DEVICE_API_ROOT                  = TOP_ROOT
                                                                           + "func/get-device";
    /** ラベル作成API ルートURL. */
    public static final String FUNC_CREATE_LABEL_API_ROOT                = TOP_ROOT
                                                                           + "func/create-label";
    /** デバイス情報作成API ルートURL. */
    public static final String FUNC_CREATE_DEVICE_API_ROOT               = TOP_ROOT
                                                                           + "func/create-device";
    /** インダクション取得API ルートURL. */
    public static final String FUNC_GET_INDUCTION_API_ROOT               = TOP_ROOT
                                                                           + "func/get-induction";
    /** スキャン確定機能API ルートURL. */
    public static final String FUNC_SCAN_CONFIRM_API_ROOT                = TOP_ROOT
                                                                           + "func/send-scan-data/scan-confirm";
    /** スキャンシステムフィールド取得API ルートURL. */
    public static final String FUNC_GET_SCAN_SYSTEM_FIELD_API_ROOT       = TOP_ROOT
                                                                           + "func/get-scan-system-field";
    /** インダクションとデバイスの紐づけAPI ルートURL. */
    public static final String FUNC_LINK_INDUCTION_DEVICE_API_ROOT       = TOP_ROOT
                                                                           + "func/link-induction-device";
    // =======================================================================================================================

    // テーブルインポート/エクスポート =======================================================================================
    /** テーブルインポート/エクスポートAPI 親URL. */
    public static final String TABLE_IE_API_PARENT           = TOP_ROOT
                                                               + "table/ie";
    /**
     * テーブルインポート/エクスポートAPI 子URL.
     * <p>
     * 「{}」で囲むことによって、URLの値を引数として取得することができる（取得する際は、{@literal @}{@link org.springframework.web.bind.annotation.PathVariable
     * PathVariable}を付ける）。<br>
     * また、{パラメータ名:正規表現}のように右側に正規表現を書くことにより、URLのバリデーションを行うことができる。<br>
     * </p>
     */
    public static final String TABLE_IE_API_CHILD            = "{mappingNo:^(?:ie-item|ie-chute|ie-shop|ie-batch|ie-task|ie-taskhst|ie-device)$}";  // memo:「?:」は「()」によるグループ化はするが、キャプチャはしないことを明示するために付ける（これがないと落ちる）
    /** テーブルインポートAPI ルートURL. */
    public static final String TABLE_IMPORT_API_ROOT         = TABLE_IE_API_PARENT
                                                               + "/import/"
                                                               + TABLE_IE_API_CHILD;
    /** テーブル全エクスポートAPI ルートURL. */
    public static final String TABLE_ALL_EXPORT_API_ROOT     = TABLE_IE_API_PARENT
                                                               + "/export/all/"
                                                               + TABLE_IE_API_CHILD;
    /** テーブル部分エクスポートAPI ルートURL. */
    public static final String TABLE_PARTIAL_EXPORT_API_ROOT = TABLE_IE_API_PARENT
                                                               + "/export/partial/"
                                                               + TABLE_IE_API_CHILD;
    // =======================================================================================================================


    // RCS-WES===============================================================================================================
    /** 発進通知API ルートURL. */
    public static final String API_START_NOTIFICATION_API_ROOT = TOP_ROOT
                                                                 + "api/start-notification";
    /** 到着通知API ルートURL. */
    public static final String API_ARRIVAL_NOTIFICATION_ROOT   = TOP_ROOT
                                                                 + "api/arrival-notification";
    /** 完了通知API ルートURL. */
    public static final String API_DIVERT_CONFIRM_ROOT         = TOP_ROOT
                                                                 + "api/divert-confirm";
    /** エラー通知API ルートURL. */
    public static final String API_ERROR_NOTIFICATION_ROOT     = TOP_ROOT
                                                                 + "api/error-notification";
    // =======================================================================================================================


    // その他 ================================================================================================================
    /** 設定画面API ルートURL. */
    public static final String SETTING_API_ROOT = TOP_ROOT + "setting";
    // =======================================================================================================================
}
