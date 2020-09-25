package com.ever.gsystem.constants.properties;

import lombok.experimental.UtilityClass;

/**
 * application.ymlの文字列定数クラス.
 * <p>
 * application.yml及び、application-xxx.yml（xxxはlocalなど）で定義しているプロパティのキーを管理する。<br>
 * {@link org.springframework.beans.factory.annotation.Value}アノテーションで利用する。<br>
 * </p>
 *
 * @since   0.0.1-SNAPSHOT
 * @since   2019/12/07
 * @version 1.1.0
 * @author  Hiroshi Takano
 */
@UtilityClass   // Lombokでインスタンスの生成をできないようにする
public final class ApplicationValue {
    // Spring ================================================================================================================
    /** アクティブプロファイル名（囲み文字なし）. */
    public static final String PROFILES_ACTIVE_SWITCH_STR = "spring.profiles.active";
    /** アクティブプロファイル名. */
    public static final String PROFILES_ACTIVE_SWITCH     = "${"
                                                            + PROFILES_ACTIVE_SWITCH_STR
                                                            + "}";

    /** バッチインサート有効フラグ. */
    public static final String BATCH_INSERT_SWITCH = "${spring.jpa.properties.hibernate.order_inserts}";
    /** バッチアップデート有効フラグ. */
    public static final String BATCH_UPDATE_SWITCH = "${spring.jpa.properties.hibernate.order_updates}";
    /** インサート/デリートバッチの数（囲み文字なし）. */
    public static final String BATCH_SIZE_STR      = "spring.jpa.properties.hibernate.jdbc.batch_size";
    /** インサート/デリートバッチの数. */
    public static final String BATCH_SIZE          = "${"
                                                     + BATCH_SIZE_STR + "}";
    /** 暗黙的ネーミングストラテジ. */
    public static final String IMPLICIT_STRATEGY   = "${spring.jpa.hibernate.naming.implicit-strategy}";
    /** 物理的ネーミングストラテジ. */
    public static final String PHYSICAL_STRATEGY   = "${spring.jpa.hibernate.naming.physical-strategy}";

    /** Mybatis設定 遅延ロードの有効化. */
    public static final String MYBATIS_CONF_LAZY_LOADING_ENABLED                 = "${mybatis.configuration.lazy-loading-enabled}";
    /** Mybatis設定 複数結果セット有効化/無効化. */
    public static final String MYBATIS_CONF_MULTIPLE_RESULT_SETS_ENABLED         = "${mybatis.configuration.multiple-result-sets-enabled}";
    /** Mybatis設定 自動マッピング動作. */
    public static final String MYBATIS_CONF_AUTO_MAPPING_BEHAVIOR                = "${mybatis.configuration.auto-mapping-behavior}";
    /** Mybatis設定 アンダースコアからキャメルケースへのマップ. */
    public static final String MYBATIS_CONF_MAP_UNDERSCORE_TO_CAMEL_CASE         = "${mybatis.configuration.map-underscore-to-camel-case}";
    /** Mybatis設定 不明列の動作自動マッピング. */
    public static final String MYBATIS_CONF_AUTO_MAPPING_UNKNOWN_COLUMN_BEHAVIOR = "${mybatis.configuration.auto-mapping-unknown-column-behavior}";
    /** Mybatis設定 空行インスタンスの返却設定. */
    public static final String MYBATIS_CONF_RETURN_INSTANCE_FOR_EMPTY_ROW        = "${mybatis.configuration.return-instance-for-empty-row}";

    /** DB個別設定（囲み文字なし）. */
    public static final String DATASOURCE_STR   = "spring.datasource.datasource1";
    /** DB個別設定. */
    public static final String DATASOURCE       = "${" + DATASOURCE_STR + "}";
    /** DB接続URL（囲み文字なし）. */
    public static final String DB1_URL_STR      = "spring.datasource.datasource1.url";
    /** DB接続URL. */
    public static final String DB1_URL          = "${" + DB1_URL_STR + "}";
    /** DBユーザ名. */
    public static final String DB1_USERNAME_STR = "spring.datasource.datasource1.username";
    /** DBユーザ名. */
    public static final String DB1_USERNAME     = "${" + DB1_USERNAME_STR + "}";
    /** DBパスワード. */
    public static final String DB1_PASSWORD_STR = "spring.datasource.datasource1.password";
    /** DBパスワード. */
    public static final String DB1_PASSWORD     = "${" + DB1_PASSWORD_STR + "}";

    /** DB個別設定（2番目）（囲み文字なし）. */
    public static final String DATASOURCE2_STR  = "spring.datasource.datasource2";
    /** DB個別設定（2番目）. */
    public static final String DATASOURCE2      = "${" + DATASOURCE2_STR + "}";
    /** DB接続URL（囲み文字なし）. */
    public static final String DB2_URL_STR      = "spring.datasource.datasource2.url";
    /** DB接続URL. */
    public static final String DB2_URL          = "${" + DB2_URL_STR + "}";
    /** DBユーザ名（囲み文字なし）. */
    public static final String DB2_USERNAME_STR = "spring.datasource.datasource2.username";
    /** DBユーザ名. */
    public static final String DB2_USERNAME     = "${" + DB2_USERNAME_STR + "}";
    /** DBパスワード（囲み文字なし）. */
    public static final String DB2_PASSWORD_STR = "spring.datasource.datasource2.password";
    /** DBパスワード. */
    public static final String DB2_PASSWORD     = "${" + DB2_PASSWORD_STR + "}";

    /** FlywayによるDB全削除（DBクリーン）を無効にするフラグ（true=無効、false=有効）（囲み文字なし）. */
    public static final String FLAYWAY_CLEAN_DISABLED_STR = "spring.flyway.cleanDisabled";
    /** FlywayによるDB全削除（DBクリーン）を無効にするフラグ（true=無効、false=有効）. */
    public static final String FLAYWAY_CLEAN_DISABLED     = "${"
                                                            + FLAYWAY_CLEAN_DISABLED_STR
                                                            + "}";

    /** Flywayでマイグレーションを行う対象ディレクトリ. */
    public static final String FLAYWAY_LOCATIONS_STR = "spring.flyway.locations";
    /** Flywayでマイグレーションを行う対象ディレクトリ. */
    public static final String FLAYWAY_LOCATIONS     = "${"
                                                       + FLAYWAY_LOCATIONS_STR
                                                       + "}";

    /** データベース名（プライマリDB）（囲み文字なし）. */
    public static final String PLACEHOLDER_DB_NAME_STR                    = "spring.flyway.placeholders.db-name";
    /** データベース名（プライマリDB）. */
    public static final String PLACEHOLDER_DB_NAME                        = "${"
                                                                            + PLACEHOLDER_DB_NAME_STR
                                                                            + "}";
    /** データベース名（セカンダリDB）（囲み文字なし）. */
    public static final String PLACEHOLDER_DB2_NAME_STR                   = "spring.flyway.placeholders.db2-name";
    /** データベース名（セカンダリDB）. */
    public static final String PLACEHOLDER_DB2_NAME                       = "${"
                                                                            + PLACEHOLDER_DB2_NAME_STR
                                                                            + "}";
    /** 設定マスタの初期値：設定番号. */
    public static final String PLACEHOLDER_SETTING_SETTING_NO             = "${spring.flyway.placeholders.setting.setting-no}";
    /** 設定マスタの初期値：WMS名. */
    public static final String PLACEHOLDER_SETTING_WMS_NAME               = "${spring.flyway.placeholders.setting.wms-name}";
    /** 設定マスタの初期値：中間システム名. */
    public static final String PLACEHOLDER_SETTING_IS_NAME                = "${spring.flyway.placeholders.setting.is-name}";
    /** 設定マスタの初期値：連続投入回数. */
    public static final String PLACEHOLDER_SETTING_CONTINUOUS_ENTRY_TIMES = "${spring.flyway.placeholders.setting.continuous-entry-times}";
    /** 設定マスタの初期値：分析画面更新秒数. */
    public static final String PLACEHOLDER_SETTING_ANA_SCM_UPD_SECONDS    = "${spring.flyway.placeholders.setting.ana-scm-upd-seconds}";
    /** CSV番号：商品マスタCSV. */
    public static final String PLACEHOLDER_CSV_NO_ITEM                    = "${spring.flyway.placeholders.csvno.item}";
    /** CSV番号：シュートマスタCSV. */
    public static final String PLACEHOLDER_CSV_NO_CHUTE                   = "${spring.flyway.placeholders.csvno.chute}";
    /** CSV番号：店舗マスタCSV. */
    public static final String PLACEHOLDER_CSV_NO_SHOP                    = "${spring.flyway.placeholders.csvno.shop}";
    /** CSV番号：デバイスマスタCSV. */
    public static final String PLACEHOLDER_CSV_NO_DEVICE                  = "${spring.flyway.placeholders.csvno.device}";
    /** CSV番号：作業指示データCSV. */
    public static final String PLACEHOLDER_CSV_NO_TASK                    = "${spring.flyway.placeholders.csvno.task}";
    /** CSV番号：CSV実績ファイル. */
    public static final String PLACEHOLDER_CSV_NO_RESULT                  = "${spring.flyway.placeholders.csvno.result}";
    /** IEマッピングNo：商品マスタ. */
    public static final String PLACEHOLDER_IE_MAPPING_NO_ITEM             = "${spring.flyway.placeholders.ie-mapping-no.ie-item}";
    /** IEマッピングNo：シュートマスタ. */
    public static final String PLACEHOLDER_IE_MAPPING_NO_CHUTE            = "${spring.flyway.placeholders.ie-mapping-no.ie-chute}";
    /** IEマッピングNo：店舗マスタ. */
    public static final String PLACEHOLDER_IE_MAPPING_NO_SHOP             = "${spring.flyway.placeholders.ie-mapping-no.ie-shop}";
    /** IEマッピングNo：バッチ. */
    public static final String PLACEHOLDER_IE_MAPPING_NO_BATCH            = "${spring.flyway.placeholders.ie-mapping-no.ie-batch}";
    /** IEマッピングNo：タスク. */
    public static final String PLACEHOLDER_IE_MAPPING_NO_TASK             = "${spring.flyway.placeholders.ie-mapping-no.ie-task}";
    /** IEマッピングNo：タスク履歴. */
    public static final String PLACEHOLDER_IE_MAPPING_NO_TASKHST          = "${spring.flyway.placeholders.ie-mapping-no.ie-taskhst}";
    /** IEマッピングNo：デバイスマスタ. */
    public static final String PLACEHOLDER_IE_MAPPING_NO_DEVICE           = "${spring.flyway.placeholders.ie-mapping-no.ie-device}";
    /** カウンタマスタの設定：タスクNoカウンタ. */
    public static final String PLACEHOLDER_COUNTER_TASK_NO                = "${spring.flyway.placeholders.counter.task-no}";
    /** IEマッピングNo：デバイス明細マスタ. */
    public static final String PLACEHOLDER_IE_MAPPING_NO_DETAIL_DEVICE    = "${spring.flyway.placeholders.ie-mapping-no.ie-detail-device}";
    /** IEマッピングNo：インダクションマスタ. */
    public static final String PLACEHOLDER_IE_MAPPING_NO_INDUCTION        = "${spring.flyway.placeholders.ie-mapping-no.ie-induction}";
    /** IEマッピングNo：仕分けマスタ. */
    public static final String PLACEHOLDER_IE_MAPPING_NO_SORTING          = "${spring.flyway.placeholders.ie-mapping-no.ie-sorting}";
    // =======================================================================================================================


    // Springboot独自設定 ====================================================================================================
    /** Spring Boot独自設定（囲み文字なし）. */
    public static final String SPRINGBOOT_SETTING_STR = "springboot";
    /** Spring Boot独自設定. */
    public static final String SPRINGBOOT_SETTING     = "${"
                                                        + SPRINGBOOT_SETTING_STR
                                                        + "}";

    /** GETリクエストのバリデーション（囲み文字なし）. */
    public static final String VARIDATOR_SWITCH_STR = "springboot.get-validator";
    /** GETリクエストのバリデーション（true:行う、false:行わない）. */
    public static final String VARIDATOR_SWITCH     = "${"
                                                      + VARIDATOR_SWITCH_STR
                                                      + "}";

    /**
     * 予期せぬ例外が発生したときに、発生時刻以外に例外内容を出すかどうか（FULL：例外をすべて出力、PARTIAL：一部だけ内容を出力、NONE：出力しない）（囲み文字なし）.
     */
    public static final String UNEXPECTED_ERR_MSG_SWITCH_STR = "springboot.security.unexpected-err-msg";
    /** 予期せぬ例外が発生したときに、発生時刻以外に例外内容を出すかどうか（FULL：例外をすべて出力、PARTIAL：一部だけ内容を出力、NONE：出力しない）. */
    public static final String UNEXPECTED_ERR_MSG_SWITCH     = "${"
                                                               + UNEXPECTED_ERR_MSG_SWITCH_STR
                                                               + "}";

    /** タスク履歴退避スケジュール（囲み文字なし）. */
    public static final String CRON_TASK_HISTORY_BACKUP_SCHEDULE_STR = "springboot.cron.task-history-backup-schedule";
    /** タスク履歴退避スケジュール. */
    public static final String CRON_TASK_HISTORY_BACKUP_SCHEDULE     = "${"
                                                                       + CRON_TASK_HISTORY_BACKUP_SCHEDULE_STR
                                                                       + "}";

    /** タスク実績ファイル自動出力スケジュール（囲み文字なし）. */
    public static final String CRON_TASK_RESULT_FILE_AUTO_OUTPUT_SCHEDULE_STR = "springboot.cron.task-result-file-auto-output-schedule";
    /** タスク実績ファイル自動出力スケジュール. */
    public static final String CRON_TASK_RESULT_FILE_AUTO_OUTPUT_SCHEDULE     = "${"
                                                                                + CRON_TASK_RESULT_FILE_AUTO_OUTPUT_SCHEDULE_STR
                                                                                + "}";

    /** タスク実績ファイル削除スケジュール（囲み文字なし）. */
    public static final String TASK_RESULT_FILE_REMOVE_SCHEDULE_STR = "springboot.cron.task-result-file-remove-schedule";
    /** タスク実績ファイル削除スケジュール. */
    public static final String TASK_RESULT_FILE_REMOVE_SCHEDULE     = "${"
                                                                      + TASK_RESULT_FILE_REMOVE_SCHEDULE_STR
                                                                      + "}";
    // =======================================================================================================================

    // 履歴退避設定 ==========================================================================================================
    /** 履歴退避設定（囲み文字なし）. */
    public static final String TASK_HISTORY_SETTING_STR = "task-history";
    /** 履歴退避設定. */
    public static final String TASK_HISTORY_SETTING     = "${"
                                                          + TASK_HISTORY_SETTING_STR
                                                          + "}";
    // =======================================================================================================================


    // CSV入力/CSV出力の独自設定 =============================================================================================
    /** CSV入力/CSV出力設定（囲み文字なし）. */
    public static final String CSV_SETTING_STR = "csv";
    /** CSV入力/CSV出力設定. */
    public static final String CSV_SETTING     = "${" + CSV_SETTING_STR + "}";

    /** 読み込みCSVエンコード. */
    public static final String CSV_INPUT_ENCODE  = "${csv.input-encode}";
    /** 書き込みCSVエンコード. */
    public static final String CSV_OUTPUT_ENCODE = "${csv.output-encode}";

    /** ファイル名日付フォーマット（囲み文字なし）. */
    public static final String OUTPUT_FILE_NAME_DATE_FORMAT_STR = "csv.output-file-name-date-format";
    /** ファイル名日付フォーマット. */
    public static final String OUTPUT_FILE_NAME_DATE_FORMAT     = "${"
                                                                  + OUTPUT_FILE_NAME_DATE_FORMAT_STR
                                                                  + "}";

    /** 書き込みCSVファイルのファイル名日付タイムゾーン. */
    public static final String CSV_OUTPUT_FILE_NAME_DATE_TIME_ZONE = "${csv.output-file-name-date-time-zone}";
    // =======================================================================================================================

    // テーブルインポート/エクスポート独自設定 ===============================================================================
    /** CSV入力/CSV出力設定（囲み文字なし）. */
    public static final String TABLE_IE_SETTING_STR = "table-ie";
    /** CSV入力/CSV出力設定. */
    public static final String TABLE_IE_SETTING     = "${"
                                                      + TABLE_IE_SETTING_STR
                                                      + "}";
    // =======================================================================================================================


    // プリンタの独自設定 ====================================================================================================
    /** プリンタ設定（囲み文字なし）. */
    public static final String PRINTER_SETTING_STR    = "printer";
    /** プリンタ設定. */
    public static final String PRINTER_SETTING        = "${"
                                                        + PRINTER_SETTING_STR
                                                        + "}";
    /** 印刷日時タイムゾーン. */
    public static final String PRINTER_DATE_TIME_ZONE = "${printer.printing-date-time-zone}";
    // =======================================================================================================================


    // インバウンドサーバ/アウトバウンドクライアントで使うNetty関連の独自設定 ================================================
    /** インバウンドサーバ/アウトバウンドクライアント設定（囲み文字なし）. */
    public static final String IO_SETTING_STR = "io";
    /** インバウンドサーバ/アウトバウンドクライアント設定. */
    public static final String IO_SETTING     = "${" + IO_SETTING_STR + "}";

    /** 中間システムのシステム名（囲み文字なし）. */
    public static final String SYSTEM_NAME_STR = "io.systemname";
    /** 中間システムのシステム名. */
    public static final String SYSTEM_NAME     = "${" + SYSTEM_NAME_STR + "}";

    /** 中間システムインバウンドサーバのホスト. */
    public static final String INBND_SERVER_HOST                     = "${io.inbnd-server.host}";
    /** 中間システムインバウンドサーバのポート（囲み文字なし）. */
    public static final String INBND_SERVER_PORT_STR                 = "io.inbnd-server.port";
    /** 中間システムインバウンドサーバのポート. */
    public static final String INBND_SERVER_PORT                     = "${"
                                                                       + INBND_SERVER_PORT_STR
                                                                       + "}";
    /** 中間システムインバウンドサーバの最小受信バッファサイズ（囲み文字なし）. */
    public static final String INBND_SERVER_MIN_RECEVIE_BUF_SIZE_STR = "io.inbnd-server.min-receive-buf-size";
    /** 中間システムインバウンドサーバの最小受信バッファサイズ. */
    public static final String INBND_SERVER_MIN_RECEVIE_BUF_SIZE     = "${"
                                                                       + INBND_SERVER_MIN_RECEVIE_BUF_SIZE_STR
                                                                       + "}";
    /** 中間システムインバウンドサーバの最大受信バッファサイズ（囲み文字なし）. */
    public static final String INBND_SERVER_MAX_RECEVIE_BUF_SIZE_STR = "io.inbnd-server.max-receive-buf-size";
    /** 中間システムインバウンドサーバの最大受信バッファサイズ. */
    public static final String INBND_SERVER_MAX_RECEVIE_BUF_SIZE     = "${"
                                                                       + INBND_SERVER_MAX_RECEVIE_BUF_SIZE_STR
                                                                       + "}";
    /** 中間システムインバウンドサーバの起動遅延時間（ミリ秒）（囲み文字なし）. */
    public static final String INBND_SERVER_START_DELAYTIME_STR      = "io.inbnd-server.start-delaytime";
    /** 中間システムインバウンドサーバの起動遅延時間（ミリ秒）. */
    public static final String INBND_SERVER_START_DELAYTIME          = "${"
                                                                       + INBND_SERVER_START_DELAYTIME_STR
                                                                       + "}";
    /** 中間システムインバウンドサーバのバインドエラー時の再バインド待機時間（ミリ秒）（囲み文字なし）.. */
    public static final String INBND_SERVER_BIND_ERR_SLEEPTIME_STR   = "io.inbnd-server.bind-error-sleeptime";
    /** 中間システムインバウンドサーバのバインドエラー時の再バインド待機時間（ミリ秒）. */
    public static final String INBND_SERVER_BIND_ERR_SLEEPTIME       = "${"
                                                                       + INBND_SERVER_BIND_ERR_SLEEPTIME_STR
                                                                       + "}";
    /** 中間システムインバウンドサーバのread()タイムアウト時間（ミリ秒）（囲み文字なし）.. */
    public static final String INBND_SERVER_READ_TIMEOUTTIME_STR     = "io.inbnd-server.read-timeouttime";
    /** 中間システムインバウンドサーバのread()タイムアウト時間（ミリ秒）. */
    public static final String INBND_SERVER_READ_TIMEOUTTIME         = "${"
                                                                       + INBND_SERVER_READ_TIMEOUTTIME_STR
                                                                       + "}";

    /** WCSサーバのホスト（囲み文字なし）. */
    public static final String WCS_SERVER_HOST_STR                                             = "io.wcs-server.host";
    /** WCSサーバのホスト. */
    public static final String WCS_SERVER_HOST                                                 = "${"
                                                                                                 + WCS_SERVER_HOST_STR
                                                                                                 + "}";
    /** WCSサーバのポート（囲み文字なし）. */
    public static final String WCS_SERVER_PORT_STR                                             = "io.wcs-server.port";
    /** WCSサーバのポート. */
    public static final String WCS_SERVER_PORT                                                 = "${"
                                                                                                 + WCS_SERVER_PORT_STR
                                                                                                 + "}";
    /** WCSサーバへ接続エラー時の再接続待機時間（囲み文字なし）. */
    public static final String WCS_SERVER_CON_ERR_SLEEPTIME_STR                                = "io.wcs-server.connect-error-sleeptime";
    /** WCSサーバへ接続エラー時の再接続待機時間. */
    public static final String WCS_SERVER_CON_ERR_SLEEPTIME                                    = "${"
                                                                                                 + WCS_SERVER_CON_ERR_SLEEPTIME_STR
                                                                                                 + "}";
    /** WCSサーバ起動時にシステム情報を受け取る（その情報で中間システムのDBを更新する）（囲み文字なし）. */
    public static final String WCS_SERVER_RECEIVE_SI_WAKEUP_STR                                = "io.wcs-server.receive-system-information-at-wakeup";
    /** WCSサーバ起動時にシステム情報を受け取る（その情報で中間システムのDBを更新する）. */
    public static final String WCS_SERVER_RECEIVE_SI_WAKEUP                                    = "${"
                                                                                                 + WCS_SERVER_RECEIVE_SI_WAKEUP_STR
                                                                                                 + "}";
    /** 送信されたシュート情報がDB側に存在しない場合登録するフラグ（囲み文字なし）. */
    public static final String WCS_SERVER_SEND_CHUTE_IS_DB_SIDE_DOSE_NOT_EXIST_IF_REGISTER_STR = "io.wcs-server.send-chute-is-db-side-dose-not-exist-if-register";
    /** 送信されたシュート情報がDB側に存在しない場合登録するフラグ. */
    public static final String WCS_SERVER_SEND_CHUTE_IS_DB_SIDE_DOSE_NOT_EXIST_IF_REGISTER     = "${"
                                                                                                 + WCS_SERVER_SEND_CHUTE_IS_DB_SIDE_DOSE_NOT_EXIST_IF_REGISTER_STR
                                                                                                 + "}";

    /** RCSサーバのIPアドレス（囲み文字なし）. */
    public static final String RCS_SERVER_IP_ADDRESS_STR = "io.rcs-server.ip-address";
    /** RCSサーバのIPアドレス. */
    public static final String RCS_SERVER_IP_ADDRESS     = "${"
                                                           + RCS_SERVER_IP_ADDRESS_STR
                                                           + "}";

    /** RCSサーバのAPI（発信通知）（囲み文字なし）. */
    public static final String RCS_SERVER_API_START_NOTIFICATION_STR = "io.rcs-server.api-start-notification";
    /** RCSサーバのAPI（発信通知）. */
    public static final String RCS_SERVER_API_START_NOTIFICATION     = "${"
                                                                       + RCS_SERVER_API_START_NOTIFICATION_STR
                                                                       + "}";
    /** 中間システムアウトバウンドクライアント（囲み文字なし）. */
    public static final String OUTBND_CLIENT_STR                     = "io.outbnd-client";
    /** 中間システムアウトバウンドクライアント. */
    public static final String OUTBND_CLIENT                         = "${"
                                                                       + OUTBND_CLIENT_STR
                                                                       + "}";
    /** 中間システムアウトバウンドクライアントの起動遅延時間（ミリ秒）（囲み文字なし）. */
    public static final String OUTBND_CLIENT_START_DELAYTIME_STR     = "io.outbnd-client.start-delaytime";
    /** 中間システムアウトバウンドクライアントの起動遅延時間（ミリ秒）. */
    public static final String OUTBND_CLIENT_START_DELAYTIME         = "${"
                                                                       + OUTBND_CLIENT_START_DELAYTIME_STR
                                                                       + "}";
    /** 中間システムアウトバウンドクライアントのイベント発生間隔（ミリ秒）（囲み文字なし）. */
    public static final String OUTBND_CLIENT_UPDATE_TIME_STR         = "io.outbnd-client.updatetime";
    /** 中間システムアウトバウンドクライアントのイベント発生間隔（ミリ秒）. */
    public static final String OUTBND_CLIENT_UPDATE_TIME             = "${"
                                                                       + OUTBND_CLIENT_UPDATE_TIME_STR
                                                                       + "}";
    /** 中間システムアウトバウンドクライアントのハートビート間隔（ミリ秒）（囲み文字なし）. */
    public static final String OUTBND_CLIENT_HEARTBEAT_TIME_STR      = "io.outbnd-client.heartbeattime";
    /** 中間システムアウトバウンドクライアントのハートビート間隔（ミリ秒）. */
    public static final String OUTBND_CLIENT_HEARTBEAT_TIME          = "${"
                                                                       + OUTBND_CLIENT_HEARTBEAT_TIME_STR
                                                                       + "}";

    /** インバウンドサーバ/アウトバウンドクライアント設定（囲み文字なし）. */
    public static final String IO_MESSAGE_STR = "io.io-message";
    /** インバウンドサーバ/アウトバウンドクライアント設定. */
    public static final String IO_MESSAGE     = "${" + IO_MESSAGE_STR + "}";
    // =======================================================================================================================


    // 機器（ロボット）設定 ======================================================================================================
    /** 機器（ロボット）設定（囲み文字なし）. */
    public static final String EQUIPMENT_SETTING_STR = "equipment-setting";
    /** 機器（ロボット）設定. */
    public static final String EQUIPMENT_SETTING     = "${"
                                                       + EQUIPMENT_SETTING_STR
                                                       + "}";
    // =======================================================================================================================


    // 商品スキャン設定 ======================================================================================================
    /** 商品スキャン設定（囲み文字なし）. */
    public static final String ITEM_SCAN_SETTING_STR = "item-scan-setting";
    /** 商品スキャン設定. */
    public static final String ITEM_SCAN_SETTING     = "${"
                                                       + ITEM_SCAN_SETTING_STR
                                                       + "}";
    // =======================================================================================================================


    // スキャンコード設定 =========================================================================================================
    /** スキャンコード設定（囲み文字なし）. */
    public static final String SCAN_CODE_SETTING_STR = "scan-code-setting";
    /** スキャンコード設定. */
    public static final String SCAN_CODE_SETTING     = "${"
                                                       + SCAN_CODE_SETTING_STR
                                                       + "}";
    // =======================================================================================================================


    // RFIDデコード設定 ======================================================================================================
    /** RFIDデコード設定（囲み文字なし）. */
    public static final String RFID_DECODE_SETTING_STR = "rfid-decode-setting";
    /** RFIDデコード設定. */
    public static final String RFID_DECODE_SETTING     = "${"
                                                         + RFID_DECODE_SETTING_STR
                                                         + "}";
    // =======================================================================================================================


    // 仕分けプラン設定 ======================================================================================================
    /** 仕分けプラン設定（囲み文字なし）. */
    public static final String SORT_PLAN_SETTING_STR = "sort-plan-setting";
    /** 仕分けプラン設定. */
    public static final String SORT_PLAN_SETTING     = "${"
                                                       + SORT_PLAN_SETTING_STR
                                                       + "}";
    // =======================================================================================================================


    // バッチ管理画面設定 ====================================================================================================
    /** バッチ管理画面設定（囲み文字なし）. */
    public static final String BATCH_SETTING_STR = "batch-setting";
    /** バッチ管理画面設定. */
    public static final String BATCH_SETTING     = "${"
                                                   + BATCH_SETTING_STR + "}";

    // =======================================================================================================================

    // カウンタ設定 ====================================================================================================
    /** カウンタ設定（囲み文字なし）. */
    public static final String COUNTER_SETTING_STR = "counter-setting";
    /** カウンタ設定. */
    public static final String COUNTER_SETTING     = "${"
                                                     + COUNTER_SETTING_STR
                                                     + "}";

    // =======================================================================================================================

    // 箱番号自動採番設定 ====================================================================================================
    /** 箱番号自動採番設定（囲み文字なし）. */
    public static final String BOX_NO_STR = "counter-setting.box-no";
    /** 箱番号自動採番設定. */
    public static final String BOX_NO     = "${" + BOX_NO_STR + "}";

    // =======================================================================================================================

    // WES No自動採番設定 ====================================================================================================
    /** WES No自動採番設定（囲み文字なし）. */
    public static final String WES_NO_STR = "counter-setting.wes-no";
    /** WES No自動採番設定. */
    public static final String WES_NO     = "${" + WES_NO_STR + "}";

    // =======================================================================================================================
}
