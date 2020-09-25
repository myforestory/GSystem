package com.ever.gsystem.constants;

import lombok.experimental.UtilityClass;

/**
 * エラーコードとエラーメッセージ定数クラス.
 *
 * @since   0.0.1-SNAPSHOT
 * @since   2019/11/25
 * @version 1.1.0
 * @author  Hiroshi Takano
 */
@UtilityClass // Lombokでインスタンスの生成をできないようにする
public final class ErrorCdMsg {
    /** CSVファイルの行数名. */
    public static final String CSV_LINE_NAME    = "行目:";
    /** エラー詳細メッセージ. */
    public static final String ERROR_DETAIL_MSG = "errorDetailMsg";

    // 検証系のエラー ========================================================================================================
    /** リクエストメッセージ検証エラーコード. */
    public static final String REQ_VALID_ERR_CD  = "VALID_ERR_0001";
    /** リクエストメッセージ検証エラーメッセージ. */
    public static final String REQ_VALID_ERR_MSG = "入力値に誤りがあります。";

    /** アップロードファイル検証エラーコード. */
    public static final String UPD_FILE_VALID_ERR_CD  = "VALID_ERR_0002";
    /** アップロードファイルエラーメッセージ. */
    public static final String UPD_FILE_VALID_ERR_MSG = "アップロードされたCSVファイルの項目に誤りがあります。";

    /** アップロードファイル形式検証エラーコード. */
    public static final String UPD_FILE_VALID_FORMAT_ERR_CD  = "VALID_ERR_0003";
    /** アップロードファイル形式エラーメッセージ. */
    public static final String UPD_FILE_VALID_FORMAT_ERR_MSG = "アップロードされたCSVファイルの項目に誤りがあります。";

    /** アップロードファイル形式検証その他エラーコード. */
    public static final String UPD_FILE_VALID_FORMAT_OTHER_ERR_CD  = "VALID_ERR_0004";
    /** アップロードファイル形式その他エラーメッセージ. */
    public static final String UPD_FILE_VALID_FORMAT_OTHER_ERR_MSG = "アップロードされたCSVファイルの項目に誤りがあります。";
    // =======================================================================================================================


    // ファイルアップロード系のエラー ========================================================================================
    /** ファイルアップロード空のリクエストエラーコード. */
    public static final String FILE_UPD_EMPTY_REQ_ERR_CD  = "FILE_UPD_ERR_0001";
    /** ファイルアップロード空のリクエストエラーメッセージ. */
    public static final String FILE_UPD_EMPTY_REQ_ERR_MSG = "ファイルがアップロードされていません。アップロードしてください。";

    /** ファイルアップロードファイルなしエラーコード. */
    public static final String FILE_UPD_NONFILE_ERR_CD  = "FILE_UPD_ERR_0002";
    /** ファイルアップロードファイルなしメッセージ. */
    public static final String FILE_UPD_NONFILE_ERR_MSG = "ファイルが選択されていない状態でアップロードをしようとしました。ファイルを選択してください。";

    /** ファイルアップロードサーバ側のDBエラーコード. */
    public static final String FILE_UPD_DB_ERR_CD  = "FILE_UPD_ERR_0003";
    /** ファイルアップロードサーバ側のDBメッセージ. */
    public static final String FILE_UPD_DB_ERR_MSG = "サーバ側のデータベースに異常があります。管理者に問い合わせてください。";

    /** ファイルアップロードファイル種類不明エラーコード. */
    public static final String FILE_UPD_UNKNOWN_ERR_CD  = "FILE_UPD_ERR_0004";
    /** ファイルアップロードファイル種類不明メッセージ. */
    public static final String FILE_UPD_UNKNOWN_ERR_MSG = "アップロードされたファイルの種類が不明です。ファイル名を確認してください。";

    /** ファイルアップロードCSV読み込みエラーコード. */
    public static final String FILE_UPD_CSV_READ_ERR_CD  = "FILE_UPD_ERR_0005";
    /** ファイルアップロードCSV読み込みメッセージ. */
    public static final String FILE_UPD_CSV_READ_ERR_MSG = "アップロードされたCSVの読み込みに失敗しました。管理者に問い合わせてください。";

    /** ファイルアップロードプロパティファイルとDB不整合エラーコード. */
    public static final String FILE_UPD_PROP_AND_DB_ERR_CD  = "FILE_UPD_ERR_0006";
    /** ファイルアップロードプロパティファイルとDB不整合エラーメッセージ. */
    public static final String FILE_UPD_PROP_AND_DB_ERR_MSG = "サーバ側のデータベースに異常があります。管理者に問い合わせてください。";

    /** ファイルアップロードスキャンコード取得エラーコード. */
    public static final String FILE_UPD_GET_SCAN_CODE_ERR_CD  = "FILE_UPD_ERR_0007";
    /** ファイルアップロードスキャンコード取得エラーメッセージ. */
    public static final String FILE_UPD_GET_SCAN_CODE_ERR_MSG = "取り込んだファイルの商品番号が商品マスタに存在しませんでした。商品マスタのCSVファイルを先に登録してください。";

    /** ファイルアップロード店舗マスタ取得エラーコード. */
    public static final String FILE_UPD_GET_SHOP_ERR_CD  = "FILE_UPD_ERR_0008";
    /** ファイルアップロード店舗マスタ取得エラーメッセージ. */
    public static final String FILE_UPD_GET_SHOP_ERR_MSG = "取り込んだファイルの店舗番号が店舗マスタに存在しませんでした。店舗マスタのCSVファイルを先に登録してください。";

    /** レコード重複エラーコード. */
    public static final String FILE_UPD_DUPLICATE_RECORD_ERR_CD  = "FILE_UPD_ERR_0009";
    /** レコード重複エラーメッセージ. */
    public static final String FILE_UPD_DUPLICATE_RECORD_ERR_MSG = "登録しようとしましたが、重複したレコードが存在しました。";

    /** シュートNoがNULLエラーコード. */
    public static final String FILE_UPD_CHUTE_NO_NULL_ERR_CD  = "FILE_UPD_ERR_0010";
    /** シュートNoがNULLエラーメッセージ. */
    public static final String FILE_UPD_CHUTE_NO_NULL_ERR_MSG = "登録しようとしたバッチのシュートNoに空が存在しました。シュートNoはすべて入力してください。";

    /** 設定マスタエラーコード. */
    public static final String FILE_UPD_MST_SETTING_ERR_CD  = "FILE_UPD_ERR_0011";
    /** 設定マスタエラーメッセージ. */
    public static final String FILE_UPD_MST_SETTING_ERR_MSG = "サーバ側のデータベースに異常があります。管理者に問い合わせてください。";

    /** タスクシュート不整合エラーコード. */
    public static final String FILE_UPD_TASK_CHUTE_NO_ERR_CD  = "FILE_UPD_ERR_0013";
    /** タスクシュート不整合エラーメッセージ. */
    public static final String FILE_UPD_TASK_CHUTE_NO_ERR_MSG = "タスク順序の設定を行おうとしましたが、シュートマスタに該当のシュートがありませんでした。シュートマスタを見直してください。";

    /** ファイルアップロードシュートNoが空エラーコード. */
    public static final String FILE_UPD_CHUTE_NO_EMPTY_ERR_CD  = "FILE_UPD_ERR_0014";
    /** ファイルアップロードシュートNoが空エラーメッセージ. */
    public static final String FILE_UPD_CHUTE_NO_EMPTY_ERR_MSG = "取り込んだファイルのシュートNoに空が存在しました。シュートNoはすべて入力してください。";

    /** ファイルアップロードスキャンコードが空エラーコード. */
    public static final String FILE_UPD_SCAN_CODE_EMPTY_ERR_CD  = "FILE_UPD_ERR_0015";
    /** ファイルアップロードスキャンコードが空エラーメッセージ. */
    public static final String FILE_UPD_SCAN_CODE_EMPTY_ERR_MSG = "取り込んだファイルのスキャンコードに空が存在しました。";

    /** ファイルアップロードタスク順序が一部空エラーコード. */
    public static final String FILE_UPD_TASK_ORDER_PART_EMPTY_ERR_CD  = "FILE_UPD_ERR_0016";
    /** ファイルアップロードシュート順序が一部空エラーメッセージ. */
    public static final String FILE_UPD_TASK_ORDER_PART_EMPTY_ERR_MSG = "取り込んだファイルのタスク順序に一部空が存在しました。タスク順序はすべて空にするか、すべて入力してください。";

    // =======================================================================================================================

    // シュートマスタ関連チェックのエラーレスポンス作成メソッド ==================================================================
    /** リクエスト入力項目エラーコード. */
    public static final String FUNC_CHUTE_INPUT_ERR_CD  = "FUNC_CHUTE_ERR_0001";
    /** リクエスト入力項目エラーメッセージ. */
    public static final String FUNC_CHUTE_INPUT_ERR_MSG = "入力項目グリッドの値が大きすぎます。設定マスタの値を超えました。";

    /** 設定マスタエラーコード. */
    public static final String FUNC_CHUTE_MST_SETTING_ERR_CD  = "FUNC_CHUTE_ERR_002";
    /** 設定マスタエラーメッセージ. */
    public static final String FUNC_CHUTE_MST_SETTING_ERR_MSG = "サーバ側のデータベースに異常があります。管理者に問い合わせてください。";

    /** リクエスト入力項目デバイスIDエラーコード. */
    public static final String FUNC_CHUTE_INPUT_DEVICE_ID_ERR_CD  = "FUNC_CHUTE_ERR_0003";
    /** リクエスト入力項目デバイスIDエラーメッセージ. */
    public static final String FUNC_CHUTE_INPUT_DEVICE_ID_ERR_MSG = "デバイスIDがデバイスマスタに存在しません。";

    // =======================================================================================================================


    // 仕分けマスタ関連チェックのエラーレスポンス作成メソッド ==================================================================
    /** 仕分け設定マスタ該当データなしエラーコード. */
    public static final String MASTER_SORTING_SORTING_SETTING_NOT_FOUND_ERR_CD  = "MASTER_SORTING_ERR_0001";
    /** 仕分け設定マスタ該当データなしエラーメッセージ. */
    public static final String MASTER_SORTING_SORTING_SETTING_NOT_FOUND_ERR_MSG = "仕分け設定マスタに指定したタスクタイプが登録されていません。管理者にお問い合わせください。";

    /** 仕分け設定マスタとの仕分けキー入力有無チェックエラーコード. */
    public static final String MASTER_SORTING_SORTING_KEY_INPUT_ERR_CD  = "MASTER_SORTING_ERR_0002";
    /** 仕分け設定マスタとの仕分けキー入力有無チェックエラーメッセージ. */
    public static final String MASTER_SORTING_SORTING_KEY_INPUT_ERR_MSG = "仕分け設定マスタと仕分けキーの入力がずれています。";

    /** タスクタイプと仕分けキーでの重複チェックエラーコード. */
    public static final String MASTER_SORTING_OVERLAP_ERR_CD  = "MASTER_SORTING_ERR_0003";
    /** タスクタイプと仕分けキーでの重複チェックエラーメッセージ. */
    public static final String MASTER_SORTING_OVERLAP_ERR_MSG = "タスクタイプ、仕分けキーが同じ組合せで既に登録されています。";

    // =======================================================================================================================


    // タスク明細関連のエラーレスポンス作成メソッド ==================================================================
    /** 該当タスクなしエラーコード. */
    public static final String WORK_TASK_NOT_FOUND_ERR_CD  = "WORK_TASK_ERR_0001";
    /** 該当タスクなしエラーメッセージ. */
    public static final String WORK_TASK_NOT_FOUND_ERR_MSG = "該当タスクが見つかりませんでした。";

    /** ステータス変更不可エラーコード. */
    public static final String WORK_TASK_STATUS_CHANGE_ERR_CD  = "WORK_TASK_ERR_002";
    /** ステータス変更不可エラーメッセージ. */
    public static final String WORK_TASK_STATUS_CHANGE_ERR_MSG = "ステータスを変更できません。「処理中」から「開始済み」または「完了済み」への更新のみ可能です。";

    /** 該当バッチなしエラーコード. */
    public static final String WORK_TASK_BATCH_NOT_FOUND_ERR_CD  = "WORK_TASK_ERR_0003";
    /** 該当バッチなしエラーメッセージ. */
    public static final String WORK_TASK_BATCH_NOT_FOUND_ERR_MSG = "該当バッチが見つかりませんでした。";
    // =======================================================================================================================


    // タスクシュート割付機能のエラーレスポンス作成メソッド ==================================================================
    /** リクエスト空エラーコード. */
    public static final String FUNC_ASSIGN_REQUEST_ERR_CD  = "FUNC_ASSIGN_ERR_0001";
    /** リクエスト空エラーメッセージ. */
    public static final String FUNC_ASSIGN_REQUEST_ERR_MSG = "バッチ番号を指定してください。";

    /** リクエストありバッチなしエラーコード. */
    public static final String FUNC_ASSIGN_REQUEST_NO_BATCH_ERR_CD  = "FUNC_ASSIGN_ERR_0002";
    /** リクエストありバッチなしエラーメッセージ. */
    public static final String FUNC_ASSIGN_REQUEST_NO_BATCH_ERR_MSG = "バッチ番号を指定してください。";

    /** バッチ検索該当なしエラーコード. */
    public static final String FUNC_ASSIGN_NOT_FOUND_BATCH_ERR_CD  = "FUNC_ASSIGN_ERR_0003";
    /** バッチ検索該当なしエラーメッセージ. */
    public static final String FUNC_ASSIGN_NOT_FOUND_BATCH_ERR_MSG = "シュート割付をしようとしましたが、該当のバッチを見つけることができませんでした。更新ボタンを押して最新の状態にしてください。";

    /** バッチステータスエラーコード. */
    public static final String FUNC_ASSIGN_BAT_STATUS_ERR_CD  = "FUNC_ASSIGN_ERR_0004";
    /** バッチステータスエラーメッセージ. */
    public static final String FUNC_ASSIGN_BAT_STATUS_ERR_MSG = "シュート割付をしようとしましたが、ステータスが「未処理」以外だったため、できませんでした。";

    /** バッチ処理中ステータス存在エラーコード. */
    public static final String FUNC_ASSIGN_BAT_IN_PROCESS_STATUS_EXIST_ERR_CD  = "FUNC_ASSIGN_ERR_0005";
    /** バッチ処理中ステータス存在エラーメッセージ. */
    public static final String FUNC_ASSIGN_BAT_IN_PROCESS_STATUS_EXIST_ERR_MSG = "シュート割付をしようとしましたが、他のバッチが既に開始中のため割り付けができませんでした。";

    /** タスク検索該当なしエラーコード. */
    public static final String FUNC_ASSIGN_NOT_FOUND_TASK_ERR_CD = "FUNC_ASSIGN_ERR_0006";
    /** タスク検索該当なしエラーメッセージ. */
    public static final String FUNC_NOT_FOUND_TASK_ERR_MSG       = "シュート割付をしようとしましたが、該当のタスクを見つけることができませんでした。更新ボタンを押して最新の状態にしてください。";

    /** シュートマスタ空エラーコード. */
    public static final String FUNC_ASSIGN_NO_MST_CHUTE_ERR_CD  = "FUNC_ASSIGN_ERR_0007";
    /** シュートマスタ空エラーメッセージ. */
    public static final String FUNC_ASSIGN_NO_MST_CHUTE_ERR_MSG = "シュート割付をしようとしましたが、割り当て可能なシュートがありませんでした。割り当て可能なシュートを取り込んでください。";

    /** 設定マスタ空エラーコード. */
    public static final String FUNC_ASSIGN_NO_MST_SETTING_ERR_CD  = "FUNC_ASSIGN_ERR_0008";
    /** 設定マスタ空エラーメッセージ. */
    public static final String FUNC_ASSIGN_NO_MST_SETTING_ERR_MSG = "サーバ側のデータベースに異常があります。管理者に問い合わせてください。";

    /** 仕分け設定マスタ空エラーコード. */
    public static final String FUNC_ASSIGN_NO_MST_SORTING_SETTING_ERR_CD  = "FUNC_ASSIGN_ERR_0009";
    /** 仕分け設定マスタ空エラーメッセージ. */
    public static final String FUNC_ASSIGN_NO_MST_SORTING_SETTING_ERR_MSG = "シュート割付をしようとしましたが、仕分け設定がありませんでした。管理者に問い合わせてください。";

    // =======================================================================================================================


    // バッチ開始機能のエラーレスポンス作成メソッド ==========================================================================
    /** リクエスト空エラーコード. */
    public static final String FUNC_BATCH_START_REQUEST_ERR_CD  = "FUNC_BATCH_START_ERR_0001";
    /** リクエスト空エラーメッセージ. */
    public static final String FUNC_BATCH_START_REQUEST_ERR_MSG = "バッチ番号を指定してください。";

    /** リクエストありバッチなしエラーコード. */
    public static final String FUNC_BATCH_START_REQUEST_NO_BATCH_ERR_CD  = "FUNC_BATCH_START_ERR_0002";
    /** リクエストありバッチなしエラーメッセージ. */
    public static final String FUNC_BATCH_START_REQUEST_NO_BATCH_ERR_MSG = "バッチ番号を指定してください。";

    /** バッチ検索該当なしエラーコード. */
    public static final String FUNC_BATCH_START_NOT_FOUND_BATCH_ERR_CD  = "FUNC_BATCH_START_ERR_0003";
    /** バッチ検索該当なしエラーメッセージ. */
    public static final String FUNC_BATCH_START_NOT_FOUND_BATCH_ERR_MSG = "バッチを開始しようとしましたが、該当のバッチを見つけることができませんでした。更新ボタンを押して最新の状態にしてください。";

    /** バッチステータスエラーコード. */
    public static final String FUNC_BATCH_START_BAT_STATUS_ERR_CD  = "FUNC_BATCH_START_ERR_0004";
    /** バッチステータスエラーメッセージ. */
    public static final String FUNC_BATCH_START_BAT_STATUS_ERR_MSG = "バッチを開始できる状態ではありませんでした。";
    // =======================================================================================================================


    // バッチ一時保留処理機能APIのエラーレスポンス作成メソッド ===============================================================
    /** リクエストバッチがnullエラーコード */
    public static final String FUNC_BATCH_TEMPORARY_HOLDING_ON_REQUEST_NO_REQUEST_ERR_CD  = "FUNC_BATCH_TEMPORARY_HOLDING_ON_ERR_0001";
    /** リクエストバッチがnullエラーメッセージ. */
    public static final String FUNC_BATCH_TEMPORARY_HOLDING_ON_REQUEST_NO_REQUEST_ERR_MSG = "バッチ番号を指定してください。";

    /** リクエストメッセージがnullエラーコード. */
    public static final String FUNC_BATCH_TEMPORARY_HOLDING_ON_REQUEST_NULL_REQUEST_ERR_CD  = "FUNC_BATCH_TEMPORARY_HOLDING_ON_ERR_0002";
    /** リクエストメッセージがnullエラーメッセージ. */
    public static final String FUNC_BATCH_TEMPORARY_HOLDING_ON_REQUEST_NULL_REQUEST_ERR_MSG = "バッチ番号を指定してください。";

    /** リクエストバッチ番号がnullか空エラーコード. */
    public static final String FUNC_BATCH_TEMPORARY_HOLDING_ON_REQUEST_BLANK_REQUEST_ERR_CD  = "FUNC_BATCH_TEMPORARY_HOLDING_ON_ERR_0003";
    /** リクエストバッチ番号がnullか空エラーメッセージ. */
    public static final String FUNC_BATCH_TEMPORARY_HOLDING_ON_REQUEST_BLANK_REQUEST_ERR_MSG = "バッチ番号を指定してください。";

    // =======================================================================================================================

    // バッチ一時保留解除処理機能APIのエラーレスポンス作成メソッド ===============================================================
    /** リクエストバッチがnullエラーコード */
    public static final String FUNC_BATCH_TEMPORARY_HOLDING_OFF_REQUEST_NO_REQUEST_ERR_CD  = "FUNC_BATCH_TEMPORARY_HOLDING_OFF_ERR_0001";
    /** リクエストバッチがnullエラーメッセージ. */
    public static final String FUNC_BATCH_TEMPORARY_HOLDING_OFF_REQUEST_NO_REQUEST_ERR_MSG = "バッチ番号を指定してください。";

    /** リクエストメッセージがnullエラーコード. */
    public static final String FUNC_BATCH_TEMPORARY_HOLDING_OFF_REQUEST_NULL_REQUEST_ERR_CD  = "FUNC_BATCH_TEMPORARY_HOLDING_OFF_ERR_0002";
    /** リクエストメッセージがnullエラーメッセージ. */
    public static final String FUNC_BATCH_TEMPORARY_HOLDING_OFF_REQUEST_NULL_REQUEST_ERR_MSG = "バッチ番号を指定してください。";

    /** リクエストバッチ番号がnullか空エラーコード. */
    public static final String FUNC_BATCH_TEMPORARY_HOLDING_OFF_REQUEST_BLANK_REQUEST_ERR_CD  = "FUNC_BATCH_TEMPORARY_HOLDING_OFF_ERR_0003";
    /** リクエストバッチ番号がnullか空エラーメッセージ. */
    public static final String FUNC_BATCH_TEMPORARY_HOLDING_OFF_REQUEST_BLANK_REQUEST_ERR_MSG = "バッチ番号を指定してください。";

    /** バッチステータスエラーコード. */
    public static final String FUNC_BATCH_TEMPORARY_HOLDING_OFF_BAT_STATUS_ERR_CD  = "FUNC_TAST_TEMPORARY_HOLDING_OFF_ERR_0004";
    /** バッチステータスエラーメッセージ. */
    public static final String FUNC_BATCH_TEMPORARY_HOLDING_OFF_BAT_STATUS_ERR_MSG = "バッチを一時保留解除できる状態ではありませんでした。";

    // =======================================================================================================================

    // バッチ取り消し処理機能APIのエラーレスポンス作成メソッド ===============================================================
    /** リクエスト空エラーコード. */
    public static final String FUNC_BATCH_CANCEL_REQUEST_ERR_CD  = "FUNC_BATCH_CANCEL_ERR_0001";
    /** リクエスト空エラーメッセージ. */
    public static final String FUNC_BATCH_CANCEL_REQUEST_ERR_MSG = "バッチ番号とバッチ明細番号を指定してください。";

    /** リクエストありバッチなしエラーコード. */
    public static final String FUNC_BATCH_CANCEL_REQUEST_NO_BATCH_ERR_CD  = "FUNC_BATCH_CANCEL_ERR_0002";
    /** リクエストありバッチなしエラーメッセージ. */
    public static final String FUNC_BATCH_CANCEL_REQUEST_NO_BATCH_ERR_MSG = "バッチ番号とバッチ明細番号を指定してください。";

    /** バッチ検索該当なしエラーコード. */
    public static final String FUNC_BATCH_CANCEL_NOT_FOUND_BATCH_ERR_CD  = "FUNC_BATCH_CANCEL_ERR_0003";
    /** バッチ検索該当なしエラーメッセージ. */
    public static final String FUNC_BATCH_CANCEL_NOT_FOUND_BATCH_ERR_MSG = "バッチを終了しようとしましたが、該当のバッチを見つけることができませんでした。更新ボタンを押して最新の状態にしてください。";

    /** バッチステータスエラーコード. */
    public static final String FUNC_BATCH_CANCEL_BAT_STATUS_ERR_CD  = "FUNC_TAST_CANCEL_ERR_0004";
    /** バッチステータスエラーメッセージ. */
    public static final String FUNC_BATCH_CANCEL_BAT_STATUS_ERR_MSG = "バッチを取り消せる状態ではありませんでした。";
    // =======================================================================================================================

    // バッチ終了機能APIのエラーレスポンス作成メソッド =======================================================================
    /** リクエストバッチがnullエラーコード */
    public static final String FUNC_BATCH_END_REQUEST_NO_REQUEST_ERR_CD  = "FUNC_BATCH_END_ERR_0001";
    /** リクエストバッチがnullエラーメッセージ. */
    public static final String FUNC_BATCH_END_REQUEST_NO_REQUEST_ERR_MSG = "バッチ番号を指定してください。";

    /** リクエストメッセージがnullエラーコード. */
    public static final String FUNC_BATCH_END_REQUEST_NULL_REQUEST_ERR_CD  = "FUNC_BATCH_END_ERR_0002";
    /** リクエストメッセージがnullエラーメッセージ. */
    public static final String FUNC_BATCH_END_REQUEST_NULL_REQUEST_ERR_MSG = "バッチ番号を指定してください。";

    /** リクエストバッチ番号がnullか空エラーコード. */
    public static final String FUNC_BATCH_END_REQUEST_BLANK_REQUEST_ERR_CD  = "FUNC_BATCH_END_ERR_0003";
    /** リクエストバッチ番号がnullか空エラーメッセージ. */
    public static final String FUNC_BATCH_END_REQUEST_BLANK_REQUEST_ERR_MSG = "バッチ番号を指定してください。";

    // =======================================================================================================================

    //ダッシュボード割り当て関数のエラー応答作成メソッド =====================================================================
    /** 検索バッチのバッチ番号かバッチ明細番号がどちらか空エラーコード. */
    public static final String FUNC_DASHBOARD_REQUEST_NOT_VALID_VALUE_ERR_CD  = "FUNC_DASHBOARD_ERR_0001";
    /** 検索バッチのバッチ番号かバッチ明細番号がどちらか空エラーメッセージ. */
    public static final String FUNC_DASHBOARD_REQUEST_NOT_VALID_VALUE_ERR_MSG = "リクエストされたバッチ番号とバッチ明細番号を検索した結果、検索されたバッチ番号とバッチ明細番号のどちらかが空でした。通常あり得ない挙動のため管理者に問い合わせてください。";
    /** リクエストのバッチ番号かバッチ明細番号がどちらか空エラーコード. */
    public static final String FUNC_DASHBOARD_REQUEST_NOT_VALID_INPUT_ERR_CD  = "FUNC_DASHBOARD_ERR_0002";
    /** リクエストのバッチ番号かバッチ明細番号がどちらか空エラーメッセージ. */
    public static final String FUNC_DASHBOARD_REQUEST_NOT_VALID_INPUT_ERR_MSG = "リクエストにバッチ番号とバッチ明細番号を指定しましたが、どちらかが空でした。指定をしてください。";
    // =======================================================================================================================


    // シュートスキャン機能のエラーレスポンス作成メソッド ====================================================================
    /** リクエスト空エラーコード. */
    public static final String FUNC_CHUTE_SCAN_REQUEST_ERR_CD  = "FUNC_CHUTE_SCAN_ERR_0001";
    /** リクエスト空エラーメッセージ. */
    public static final String FUNC_CHUTE_SCAN_REQUEST_ERR_MSG = "シュートNoを指定してください。";

    /** リクエスト空エラーコード. */
    public static final String FUNC_CHUTE_SCAN_MSTCHUTE_EMPTY_ERR_CD  = "FUNC_CHUTE_SCAN_ERR_0002";
    /** リクエスト空エラーメッセージ. */
    public static final String FUNC_CHUTE_SCAN_MSTCHUTE_EMPTY_ERR_MSG = "シュートNoに紐づくシュートがシュートマスタにありませんでした。指定したシュートNo：";
    // =======================================================================================================================

    // バッチ機能のエラー受付作成方法 ====================================================================
    /** リクエスト空エラーコード. */
    public static final String FUNC_BATCH_SERVICE_EMPTY_DELETE_REQUEST_ERR_CD  = "FUNC_BATCH_SERVICE_ERR_0001";
    /** リクエスト空エラーメッセージ. */
    public static final String FUNC_BATCH_SERVICE_EMPTY_DELETE_REQUEST_ERR_MSG = "バッチ番号を指定してください。";
    /** NULLエラーコードを要求する. */
    public static final String FUNC_BATCH_SERVICE_NULL_DELETE_REQUEST_ERR_CD   = "FUNC_BATCH_SERVICE_ERR_0002";
    /** NULLエラーメッセージを要求する. */
    public static final String FUNC_BATCH_SERVICE_NULL_DELETE_REQUEST_ERR_MSG  = "バッチ番号を指定してください。";
    // =======================================================================================================================


    // デバイス情報取得のエラーレスポンス作成メソッド ============================================================================
    /** リクエストが存在しないエラーコード. */
    public static final String FUNC_GET_DEVICE_REQUEST_ERR_CD  = "FUNC_GET_DEVICEL_ERR_0001";
    /** リクエストが存在しないエラーメッセージ. */
    public static final String FUNC_GET_DEVICE_REQUEST_ERR_MSG = "リクエストが存在しませんでした。";

    /** 対象デバイス情報が存在しないエラーコード. */
    public static final String FUNC_GET_DEVICE_MST_DEVICE_NOT_EXISTS_ERR_CD  = "FUNC_GET_DEVICEL_ERR_0002";
    /** 対象デバイス情報が存在しないエラーメッセージ. */
    public static final String FUNC_GET_DEVICE_MST_DEVICE_NOT_EXISTS_ERR_MSG = "デバイスが存在しませんでした。";
    // =======================================================================================================================


    // ラベル作成のエラーレスポンス作成メソッド ============================================================================
    /** シュートNoから対象タスクが存在しないエラーコード. */
    public static final String FUNC_CREATE_LABEL_BY_CHUTE_NO_TASK_NOT_EXISTS_ERR_CD  = "FUNC_CREATE_LABEL_ERR_0001";
    /** シュートNoから対象タスクが存在しないエラーメッセージ. */
    public static final String FUNC_CREATE_LABEL_BY_CHUTE_NO_TASK_NOT_EXISTS_ERR_MSG = "タスクを取得できませんでした。";

    /** 箱番号から対象タスクが存在しないエラーコード. */
    public static final String FUNC_CREATE_LABEL_BY_BOX_NO_TASK_NOT_EXISTS_ERR_CD  = "FUNC_CREATE_LABEL_ERR_0002";
    /** 箱番号から対象タスクが存在しないエラーメッセージ. */
    public static final String FUNC_CREATE_LABEL_BY_BOX_NO_TASK_NOT_EXISTS_ERR_MSG = "タスクを取得できませんでした。";

    /** リクエスト空エラーコード. */
    public static final String FUNC_CREATE_LABEL_REQUEST_ERR_CD  = "FUNC_CREATE_LABEL_ERR_0003";
    /** リクエスト空エラーメッセージ. */
    public static final String FUNC_CREATE_LABEL_REQUEST_ERR_MSG = "シュートNoあるいは箱IDを指定してください。";
    // =======================================================================================================================


    // 実績出力機能のエラーレスポンス作成メソッド ============================================================================
    /** リクエスト空エラーコード. */
    public static final String FUNC_RESULT_OUTPUT_REQUEST_ERR_CD  = "FUNC_RESULT_OUTPUT_ERR_0001";
    /** リクエスト空エラーメッセージ. */
    public static final String FUNC_RESULT_OUTPUT_REQUEST_ERR_MSG = "バッチ番号、バッチ明細番号を指定してください。";

    /** リクエストありバッチなしエラーコード. */
    public static final String FUNC_RESULT_OUTPUT_REQUEST_NO_BATCH_ERR_CD  = "FUNC_RESULT_OUTPUT_ERR_0002";
    /** リクエストありバッチなしエラーメッセージ. */
    public static final String FUNC_RESULT_OUTPUT_REQUEST_NO_BATCH_ERR_MSG = "バッチ番号、バッチ明細番号を指定してください。";

    /** バッチ検索該当なしエラーコード. */
    public static final String FUNC_RESULT_OUTPUT_NOT_FOUND_BATCH_ERR_CD  = "FUNC_RESULT_OUTPUT_ERR_0003";
    /** バッチ検索該当なしエラーメッセージ. */
    public static final String FUNC_RESULT_OUTPUT_NOT_FOUND_BATCH_ERR_MSG = "実績を出力しようとしましたが、該当のバッチを見つけることができませんでした。更新ボタンを押して最新の状態にしてください。";
    // =======================================================================================================================


    // インポート系のエラー ==================================================================================================
    /** インポート空のリクエストエラーコード. */
    public static final String IMPORT_EMPTY_REQ_ERR_CD  = "IMPORT_ERR_0001";
    /** インポート空のリクエストエラーメッセージ. */
    public static final String IMPORT_EMPTY_REQ_ERR_MSG = "ファイルがアップロードされていません。アップロードしてください。";

    /** インポートファイルなしエラーコード. */
    public static final String IMPORT_NONFILE_ERR_CD  = "IMPORT_ERR_0002";
    /** インポートファイルなしメッセージ. */
    public static final String IMPORT_NONFILE_ERR_MSG = "ファイルが選択されていない状態でアップロードをしようとしました。ファイルを選択してください。";

    /** インポートサーバ側のDBエラーコード. */
    public static final String IMPORT_DB_ERR_CD  = "IMPORT_ERR_0003";
    /** インポートサーバ側のDBメッセージ. */
    public static final String IMPORT_DB_ERR_MSG = "サーバ側のデータベースに異常があります。管理者に問い合わせてください。";

    /** インポートCSV読み込みエラーコード. */
    public static final String IMPORT_CSV_READ_ERR_CD  = "IMPORT_ERR_0004";
    /** インポートCSV読み込みメッセージ. */
    public static final String IMPORT_CSV_READ_ERR_MSG = "アップロードされたCSVの読み込みに失敗しました。管理者に問い合わせてください。";

    /** インポートプロパティファイルとDB不整合エラーコード. */
    public static final String IMPORT_PROP_AND_DB_ERR_CD  = "IMPORT_ERR_0005";
    /** インポートプロパティファイルとDB不整合エラーメッセージ. */
    public static final String IMPORT_PROP_AND_DB_ERR_MSG = "サーバ側のデータベースに異常があります。管理者に問い合わせてください。";

    /** レコード重複エラーコード. */
    public static final String IMPORT_DUPLICATE_RECORD_ERR_CD  = "IMPORT_ERR_0006";
    /** レコード重複エラーメッセージ. */
    public static final String IMPORT_DUPLICATE_RECORD_ERR_MSG = "登録しようとしましたが、重複したレコードが存在しました。";
    // =======================================================================================================================


    // エクスポートのエラーレスポンス作成メソッド ============================================================================
    /** プロパティファイルとDB不整合エラーコード. */
    public static final String EXPORT_PROP_AND_DB_ERR_CD      = "EXPORT_ERR_0001";
    /** プロパティファイルとDB不整合エラーメッセージ. */
    public static final String EXPORT_UPD_PROP_AND_DB_ERR_MSG = "サーバ側のデータベースに異常があります。管理者に問い合わせてください。";
    // =======================================================================================================================


    // プラン選択機能のエラーレスポンス作成メソッド ==========================================================================
    /** リクエスト空エラーコード. */
    public static final String FUNC_PLAN_SELECTION_REQUEST_ERR_CD  = "FUNC_PLAN_SELECTION_ERR_0001";
    /** リクエスト空エラーメッセージ. */
    public static final String FUNC_PLAN_SELECTION_REQUEST_ERR_MSG = "仕分けプラン状態を指定してください。";

    /** リクエストの設定マスタ空エラーコード. */
    public static final String FUNC_PLAN_SELECTION_MSTSETTING_EMPTY_ERR_CD  = "FUNC_PLAN_SELECTION_ERR_0002";
    /** リクエストの設定マスタ空エラーメッセージ. */
    public static final String FUNC_PLAN_SELECTION_MSTSETTING_EMPTY_ERR_MSG = "仕分けプラン状態を指定してください。";

    /** リクエスト設定マスタの仕分けプランモード状態空エラーコード. */
    public static final String FUNC_PLAN_SELECTION_SORT_PLAN_MODE_STATE_EMPTY_ERR_CD  = "FUNC_PLAN_SELECTION_ERR_0003";
    /** リクエスト設定マスタの仕分けプランモード状態空エラーメッセージ. */
    public static final String FUNC_PLAN_SELECTION_SORT_PLAN_MODE_STATE_EMPTY_ERR_MSG = "仕分けプラン状態を指定してください。";

    /** リクエスト設定マスタの仕分けプランモード状態範囲外エラーコード. */
    public static final String FUNC_PLAN_SELECTION_SORT_PLAN_MODE_STATE_OUT_OF_RANGE_ERR_CD  = "FUNC_PLAN_SELECTION_ERR_0004";
    /** リクエスト設定マスタの仕分けプランモード状態範囲外メッセージ. */
    public static final String FUNC_PLAN_SELECTION_SORT_PLAN_MODE_STATE_OUT_OF_RANGE_ERR_MSG = "仕分けプラン状態の指定が範囲外です。";
    // =======================================================================================================================

    // シュート取得機能のエラーレスポンス作成メソッド ====================================================================
    /** リクエスト空エラーコード. */
    public static final String FUNC_GET_CHUTE_REQUEST_ERR_CD  = "FUNC_GET_CHUTE_ERR_0001";
    /** リクエスト空エラーメッセージ. */
    public static final String FUNC_GET_CHUTE_REQUEST_ERR_MSG = "シュートNoを指定してください。";

    /** リクエスト空エラーコード. */
    public static final String FUNC_GET_CHUTE_NO_CHUTENO_ERR_CD  = "FUNC_GET_CHUTE_ERR_0002";
    /** リクエスト空エラーメッセージ. */
    public static final String FUNC_GET_CHUTE_NO_CHUTENO_ERR_MSG = "シュートNoに紐づくシュートがシュートマスタにありませんでした。指定したシュートNo：";
    // =======================================================================================================================

    // シュート取得機能のエラーレスポンス作成メソッド ====================================================================
    /** リクエスト空エラーコード. */
    public static final String FUNC_UPDATE_CHUTE_REQUEST_ERR_CD  = "FUNC_UPDATE_CHUTE_ERR_0001";
    /** リクエスト空エラーメッセージ. */
    public static final String FUNC_UPDATE_CHUTE_REQUEST_ERR_MSG = "シュートNoを指定してください。";

    /** シュートNo存在しないエラーコード. */
    public static final String FUNC_UPDATE_CHUTE_NO_CHUTENO_ERR_CD  = "FUNC_UPDATE_CHUTE_ERR_0002";
    /** シュートNo存在しないエラーメッセージ. */
    public static final String FUNC_UPDATE_CHUTE_NO_CHUTENO_ERR_MSG = "シュートNoに紐づくシュートがシュートマスタにありませんでした。指定したシュートNo：";

    /** ステータスNullエラーコード. */
    public static final String FUNC_UPDATE_CHUTE_STATUS_ERR_CD  = "FUNC_UPDATE_CHUTE_ERR_0003";
    /** ステータスNullエラーメッセージ. */
    public static final String FUNC_UPDATE_CHUTE_STATUS_ERR_MSG = "ステータスがNullです。";
    // =======================================================================================================================


    // シュートラベル取得機能のエラーレスポンス作成メソッド ====================================================================
    /** リクエスト空エラーコード. */
    public static final String FUNC_GET_CHUTE_LABEL_REQUEST_ERR_CD  = "FUNC_GET_CHUTE_LABEL_ERR_0001";
    /** リクエスト空エラーメッセージ. */
    public static final String FUNC_GET_CHUTE_LABEL_REQUEST_ERR_MSG = "印刷に失敗しました。シュートマスタを確認してください。";

    /** リクエスト空エラーコード. */
    public static final String FUNC_GET_CHUTE_LABEL_NO_TO_CHUTENO_ERR_CD  = "FUNC_GET_CHUTE_LABEL_ERR_0002";
    /** リクエスト空エラーメッセージ. */
    public static final String FUNC_GET_CHUTE_LABEL_NO_TO_CHUTENO_ERR_MSG = "FromとTo両方指定してください。";
    // =======================================================================================================================

    // デバイス情報作成機能のエラーレスポンス作成メソッド ====================================================================
    /** リクエスト空エラーコード. */
    public static final String FUNC_CREATE_DEVICE_REQUEST_ERR_CD  = "FUNC_CREATE_DEVICE_ERR_0001";
    /** リクエスト空エラーメッセージ. */
    public static final String FUNC_CREATE_DEVICE_REQUEST_ERR_MSG = "デバイス情報を指定してください。";

    /** リクエストタイプnullエラーコード. */
    public static final String FUNC_CREATE_DEVICE_REQUEST_TYPE_NULL_ERR_CD  = "FUNC_CREATE_DEVICE_ERR_0002";
    /** リクエストタイプnullエラーメッセージ. */
    public static final String FUNC_CREATE_DEVICE_REQUEST_TYPE_NULL_ERR_MSG = "デバイスのタイプを指定してください。";

    /** リクエスト外部デバイスID空エラーコード. */
    public static final String FUNC_CREATE_DEVICE_EXTERNAL_DEVICE_ID_EMPTY_ERR_CD  = "FUNC_CREATE_DEVICE_ERR_0003";
    /** リクエスト外部デバイスID空エラーメッセージ. */
    public static final String FUNC_CREATE_DEVICE_EXTERNAL_DEVICE_ID_EMPTY_ERR_MSG = "HTで外部デバイスIDが空";

    /** リクエストBluetoothアドレスまたはIPアドレス空エラーコード. */
    public static final String FUNC_CREATE_DEVICE_PRINTER_EMPTY_ERR_CD  = "FUNC_CREATE_DEVICE_ERR_0004";
    /** リクエストBluetoothアドレスまたはIPアドレス空エラーメッセージ. */
    public static final String FUNC_CREATE_DEVICE_PRINTER_EMPTY_ERR_MSG = "プリンタでBluetoothアドレスかIPアドレスが空";

    /** デバイスID採番エラーコード. */
    public static final String FUNC_CREATE_DEVICE_DEVICE_ID_ERR_CD  = "FUNC_CREATE_DEVICE_ERR_0005";
    /** デバイスID採番エラーメッセージ. */
    public static final String FUNC_CREATE_DEVICE_DEVICE_ID_ERR_MSG = "デバイスIDの採番に失敗しました。";

    /** リクエスト空エラーコード. */
    public static final String FUNC_CREATE_DEVICE_MSTCHUTE_EMPTY_ERR_CD  = "FUNC_CREATE_DEVICE_ERR_0006";
    /** リクエスト空エラーメッセージ. */
    public static final String FUNC_CREATE_DEVICE_MSTCHUTE_EMPTY_ERR_MSG = "デバイスIDに紐づくデバイスがデバイスマスタにありませんでした。指定したデバイスID：";
    // =======================================================================================================================
    // デバイス明細マスタ登録・更新チェックエラーレスポンス作成メソッド ====================================================================
    /** デバイスID整合性エラーコード. */
    public static final String FUNC_CREATE_DETAIL_DEVICE_DEVICEID_EMPTY_ERR_CD  = "FUNC_CREATE_DETAIL_DEVICE_ERR_0001";
    /** デバイスID整合性エラーメッセージ. */
    public static final String FUNC_CREATE_DETAIL_DEVICE_DEVICEID_EMPTY_ERR_MSG = "デバイスマスタに紐づくデバイスIDが存在しないか、タイプがHTではありませんでした。";

    /** 子デバイスID整合性エラーコード. */
    public static final String FUNC_CREATE_DETAIL_DEVICE_CHILD_DEVICEID_EMPTY_ERR_CD  = "FUNC_CREATE_DETAIL_DEVICE_ERR_0002";
    /** 子デバイスID整合性エラーメッセージ. */
    public static final String FUNC_CREATE_DETAIL_DEVICE_CHILD_DEVICEID_EMPTY_ERR_MSG = "デバイスマスタに紐づく子デバイスIDが存在しないか、タイプがプリンタではありませんでした。";

    /** 紐づくデバイスマスタのアドレスNullエラーコード. */
    public static final String FUNC_CREATE_DETAIL_DEVICE_ADDRESS_EMPTY_ERR_CD  = "FUNC_CREATE_DETAIL_DEVICE_ERR_0003";
    /** 子デバイスID整合性エラーメッセージ. */
    public static final String FUNC_CREATE_DETAIL_DEVICE_ADDRESS_EMPTY_ERR_MSG = "デバイスマスタに紐づくデータのIPアドレス・Bluetoothアドレスが両方とも空です。";

    // インダクション情報取得のエラーレスポンス作成メソッド ============================================================================
    /** リクエスト空エラーコード. */
    public static final String FUNC_GET_INDUCTION_REQUEST_ERR_CD  = "FUNC_GET_INDUCTION_ERR_0001";
    /** リクエスト空エラーメッセージ. */
    public static final String FUNC_GET_INDUCTION_REQUEST_ERR_MSG = "インダクションが存在しませんでした。";

    // ======================================================================================================================
    // スキャンシステムフィールド情報取得のエラーレスポンス作成メソッド ============================================================================
    /** リクエストが存在しないエラーコード. */
    public static final String FUNC_GET_SCAN_SYSTEM_FIELD_REQUEST_ERR_CD  = "FUNC_GET_SCAN_SYSTEM_FIELD_ERR_0001";
    /** リクエストが存在しないエラーメッセージ. */
    public static final String FUNC_GET_SCAN_SYSTEM_FIELD_REQUEST_ERR_MSG = "リクエストが存在しませんでした。";
    // ======================================================================================================================

    // スキャン確定機能のエラーレスポンス作成メソッド ====================================================================
    /** デバイス取得エラーコード. */
    public static final String FUNC_SCAN_CONFIRM_DEVICE_EMPTY_ERR_CD  = "FUNC_SCAN_CONFIRM_ERR_0001";
    /** デバイス取得エラーメッセージ. */
    public static final String FUNC_SCAN_CONFIRM_DEVICE_EMPTY_ERR_MSG = "デバイスが存在しませんでした。";

    /** インダクション取得エラーコード. */
    public static final String FUNC_SCAN_CONFIRM_INDUCTION_EMPTY_ERR_CD  = "FUNC_SCAN_CONFIRM_ERR_0002";
    /** インダクション取得エラーメッセージ. */
    public static final String FUNC_SCAN_CONFIRM_INDUCTION_EMPTY_ERR_MSG = "デバイスに紐づくインダクションが存在しませんでした。";

    /** ロボット不在エラーコード. */
    public static final String FUNC_SCAN_CONFIRM_ROBOT_EXIST_ERR_CD  = "FUNC_SCAN_CONFIRM_ERR_0003";
    /** ロボット不在エラーメッセージ. */
    public static final String FUNC_SCAN_CONFIRM_ROBOT_EXIST_ERR_MSG = "インダクションにロボットが存在しません。";

    /** ロボット緊急停止中エラーコード. */
    public static final String FUNC_SCAN_CONFIRM_EMERGENCY_STOP_ERR_CD  = "FUNC_SCAN_CONFIRM_ERR_0004";
    /** ロボット緊急停止中エラーメッセージ. */
    public static final String FUNC_SCAN_CONFIRM_EMERGENCY_STOP_ERR_MSG = "インダクションのロボットが緊急停止中です。";

    //    /** タスク取得エラーコード. */
    //    public static final String FUNC_SCAN_CONFIRM_TASK_EMPTY_ERR_CD  = "FUNC_SCAN_CONFIRM_ERR_0005";
    //    /** タスク取得エラーメッセージ. */
    //    public static final String FUNC_SCAN_CONFIRM_TASK_EMPTY_ERR_MSG = "マークWES番号に該当するタスクが存在しませんでした。";

    /** リクエスト空エラーコード. */
    public static final String FUNC_SCAN_CONFIRM_REQUEST_EMPTY_ERR_CD  = "FUNC_SCAN_CONFIRM_ERR_0006";
    /** リクエスト空エラーメッセージ. */
    public static final String FUNC_SCAN_CONFIRM_REQUEST_EMPTY_ERR_MSG = "リクエストが存在しませんでした。";

    /** リクエストチェックエラーコード. */
    public static final String FUNC_SCAN_CONFIRM_REQUEST_CHECK_ERR_CD  = "FUNC_SCAN_CONFIRM_ERR_0007";
    /** リクエストチェックエラーメッセージ. */
    public static final String FUNC_SCAN_CONFIRM_REQUEST_CHECK_ERR_MSG = "リクエスト内容に不備がありました。";

    /** 開始中バッチチェックエラーコード. */
    public static final String FUNC_SCAN_CONFIRM_BATCH_NON_STARTED_ERR_CD  = "FUNC_SCAN_CONFIRM_ERR_0008";
    /** 開始中バッチチェックエラーメッセージ. */
    public static final String FUNC_SCAN_CONFIRM_BATCH_NON_STARTED_ERR_MSG = "バッチが未開始状態です。";

    /** 開始中タスク取得エラーコード. */
    public static final String FUNC_SCAN_CONFIRM_TASK_NON_STARTED_ERR_CD  = "FUNC_SCAN_CONFIRM_ERR_0009";
    /** 開始中タスク取得エラーメッセージ. */
    public static final String FUNC_SCAN_CONFIRM_TASK_NON_STARTED_ERR_MSG = "対象スキャンコードで開始中に該当するレコードがタスクテーブルに存在しませんでした。";

    /** 未完了タスク取得エラーコード. */
    public static final String FUNC_SCAN_CONFIRM_TASK_EXCESS_ENTRY_ERR_CD  = "FUNC_SCAN_CONFIRM_ERR_0010";
    /** 未完了タスク取得エラーメッセージ. */
    public static final String FUNC_SCAN_CONFIRM_TASK_EXCESS_ENTRY_ERR_MSG = "対象スキャンコードで未完了のレコードがタスクテーブルに存在しませんでした。";

    /** シュート停止中エラーコード. */
    public static final String FUNC_SCAN_CONFIRM_CHUTE_STOP_ERR_CD  = "FUNC_SCAN_CONFIRM_ERR_0011";
    /** シュート停止中エラーメッセージ. */
    public static final String FUNC_SCAN_CONFIRM_CHUTE_STOP_ERR_MSG = "処理を行おうとしたタスクすべてがシュート停止中だったため、処理を続けることができませんでした。";

    /** 設定情報取得エラーコード. */
    public static final String FUNC_SCAN_CONFIRM_SCAN_SETTING_ERR_CD  = "FUNC_SCAN_CONFIRM_ERR_0012";
    /** 設定情報取得エラーメッセージ. */
    public static final String FUNC_SCAN_CONFIRM_SCAN_SETTING_ERR_MSG = "サーバ内部エラーが発生しました。";
    // =======================================================================================================================

    // 発信通知機能のエラーレスポンス作成メソッド ====================================================================
    /** リクエスト空エラーコード. */
    public static final String API_START_NOTIFICATION_REQUEST_ERR_CD  = "API_START_NOTIFICATION_ERR_0001";
    /** リクエスト空エラーメッセージ. */
    public static final String API_START_NOTIFICATION_REQUEST_ERR_MSG = "リクエストが存在しませんでした。";

    /** タスク取得エラーコード. */
    public static final String API_START_NOTIFICATION_TASK_EMPTY_ERR_CD  = "API_START_NOTIFICATION_ERR_0002";
    /** タスク取得エラーメッセージ. */
    public static final String API_START_NOTIFICATION_TASK_EMPTY_ERR_MSG = "WES番号に紐づくタスクがタスク明細にありませんでした。指定したWES番号：";

    /** タスク値Nullエラーコード. */
    public static final String API_START_NOTIFICATION_TASK_VALUE_EMPTY_ERR_CD  = "API_START_NOTIFICATION_ERR_0003";
    /** タスク値Nullエラーメッセージ. */
    public static final String API_START_NOTIFICATION_TASK_VALUE_EMPTY_ERR_MSG = "対象タスクの以下のいずれかの値が取得できませんでした。";

    /** バッチ取得エラーコード. */
    public static final String API_START_NOTIFICATION_BATCH_EMPTY_ERR_CD  = "API_START_NOTIFICATION_ERR_0004";
    /** バッチ取得エラーメッセージ. */
    public static final String API_START_NOTIFICATION_BATCH_EMPTY_ERR_MSG = "バッチ番号、バッチ明細番号に紐づくバッチがバッチ管理にありませんでした。指定した";

    /** インダクションマスタ取得エラーコード. */
    public static final String API_START_NOTIFICATION_INDUCTION_EMPTY_ERR_CD  = "API_START_NOTIFICATION_ERR_0005";
    /** インダクションマスタ取得エラーメッセージ. */
    public static final String API_START_NOTIFICATION_INDUCTION_EMPTY_ERR_MSG = "インダクションIDに紐づくインダクションがインダクションマスタにありませんでした。指定したインダクションID：";
    // =======================================================================================================================

    // 完了通知機能のエラーレスポンス作成メソッド ====================================================================
    /** リクエストが空エラーコード. */
    public static final String API_DIVERT_CONFIRM_REQUEST_ERR_CD  = "API_DIVERT_CONFIRM_ERR_0001";
    /** リクエストが空エラーメッセージ. */
    public static final String API_DIVERT_CONFIRM_REQUEST_ERR_MSG = "リクエストが空です。";

    /** リクエストWESNoエラーコード. */
    public static final String API_DIVERT_CONFIRM_WESNO_ERR_CD  = "API_DIVERT_CONFIRM_ERR_0002";
    /** リクエストWESNoエラーメッセージ. */
    public static final String API_DIVERT_CONFIRM_WESNO_ERR_MSG = "WesNoが空です。";

    /** タスク取得エラーコード. */
    public static final String API_DIVERT_CONFIRM_TASK_EMPTY_ERR_CD  = "API_DIVERT_CONFIRM_ERR_0003";
    /** タスク取得エラーメッセージ. */
    public static final String API_DIVERT_CONFIRM_TASK_EMPTY_ERR_MSG = "WES番号に紐づくタスクがタスク明細にありませんでした。";

    /** バッチ取得エラーコード. */
    public static final String API_DIVERT_CONFIRM_BATCH_EMPTY_ERR_CD  = "API_DIVERT_CONFIRM_ERR_0004";
    /** バッチ取得エラーメッセージ. */
    public static final String API_DIVERT_CONFIRM_BATCH_EMPTY_ERR_MSG = "バッチ番号、バッチ明細番号に紐づくバッチがバッチ管理にありませんでした。";
    // ====================================================================================================

    // 到着通知機能のエラーレスポンス作成メソッド ====================================================================
    /** リクエストが空エラーコード. */
    public static final String API_ARRIVAL_NOTIFICATION_REQUEST_ERR_CD  = "API_ARRIVAL_NOTIFICATION_ERR_0001";
    /** リクエストが空エラーメッセージ. */
    public static final String API_ARRIVAL_NOTIFICATION_REQUEST_ERR_MSG = "リクエストが空です。";

    /** インダクションIDエラーコード. */
    public static final String API_ARRIVAL_NOTIFICATION_INDUCTIOIN_ID_EMPTY_ERR_CD  = "API_ARRIVAL_NOTIFICATION_ERR_0002";
    /** インダクションIDエラーメッセージ. */
    public static final String API_ARRIVAL_NOTIFICATION_INDUCTIOIN_ID_EMPTY_ERR_MSG = "インダクションIDに紐づくインダクションがインダクションマスタにありませんでした。";

    // ====================================================================================================
    // 発信通知機能のエラーレスポンス作成メソッド ====================================================================
    /** リクエストが空エラーコード. */
    public static final String API_ERROR_NONTIFICATION_REQUEST_ERR_CD  = "API_ERROR_NONTIFICATION_ERR_0001";
    /** リクエストが空エラーメッセージ. */
    public static final String API_ERROR_NONTIFICATION_REQUEST_ERR_MSG = "リクエストが空です。";
    // ====================================================================================================

    // インダクションとデバイスの紐づけ機能のエラーレスポンス作成メソッド ====================================================================
    /** リクエストが空エラーコード. */
    public static final String FUNC_LINK_INDUCTION_DEVICE_REQUEST_ERR_CD  = "FUNC_LINK_INDUCTION_DEVICE_ERR_0001";
    /** リクエストが空エラーメッセージ. */
    public static final String FUNC_LINK_INDUCTION_DEVICE_REQUEST_ERR_MSG = "リクエストが空です。";

    /** リクエストのtypeがHT（定数の0）ではない場合. */
    public static final String FUNC_LINK_INDUCTION_DEVICE_TYPE_ERR_CD  = "FUNC_LINK_INDUCTION_DEVICE_ERR_0002";
    /** リクエストのtypeがHT（定数の0）ではない場合. */
    public static final String FUNC_LINK_INDUCTION_DEVICE_TYPE_ERR_MSG = "typeがHTではありません。";

    /** リクエストのインダクションが存在しないエラーコード. */
    public static final String FUNC_LINK_INDUCTION_DEVICE_INDUCTION_ERR_CD  = "FUNC_LINK_INDUCTION_DEVICE_ERR_0003";
    /** リクエストのインダクションが存在しないエラーメッセージ. */
    public static final String FUNC_LINK_INDUCTION_DEVICE_INDUCTION_ERR_MSG = "インダクションの紐づけに失敗しました。インダクションを登録してください。";

    /** デバイスID採番エラーコード. */
    public static final String FUNC_LINK_INDUCTION_DEVICE_ID_ERR_CD  = "FUNC_LINK_INDUCTION_DEVICE_ERR_0004";
    /** デバイスID採番エラーメッセージ. */
    public static final String FUNC_LINK_INDUCTION_DEVICE_ID_ERR_MSG = "デバイスIDの採番に失敗しました。";

    // ====================================================================================================

    // テーブルチェック機能のエラーレスポンス作成メソッド ====================================================================
    /** データタイプ取得エラーコード. */
    public static final String TABLE_CHECK_GET_DATA_TYPE_ERR_CD  = "TABLE_CHECK_ERR_0001";
    /** データタイプ取得エラーメッセージ. */
    public static final String TABLE_CHECK_GET_DATA_TYPE_ERR_MSG = "データタイプが取得できませんでした。項目名：";

    /** PK必須チェックエラーコード. */
    public static final String TABLE_CHECK_PK_NULL_ERR_CD  = "TABLE_CHECK_ERR_0002";
    /** PK必須チェックエラーメッセージ. */
    public static final String TABLE_CHECK_PK_NULL_ERR_MSG = "値が設定されていません。項目名：";

    /** PK違反エラーコード. */
    public static final String TABLE_CHECK_PK_ERR_CD  = "TABLE_CHECK_ERR_0003";
    /** PK違反エラーメッセージ. */
    public static final String TABLE_CHECK_PK_ERR_MSG = "PK違反が発生しました。";

    /** FK違反エラーコード. */
    public static final String TABLE_CHECK_FK_ERR_CD  = "TABLE_CHECK_ERR_0004";
    /** FK違反エラーメッセージ. */
    public static final String TABLE_CHECK_FK_ERR_MSG = "FK違反が発生しました。";

    /** FK削除違反エラーコード. */
    public static final String TABLE_CHECK_FK_DELETE_ERR_CD  = "TABLE_CHECK_ERR_0005";
    /** FK削除違反エラーメッセージ. */
    public static final String TABLE_CHECK_FK_DELETE_ERR_MSG = "FK削除違反が発生しました。";

    /** PK(業務キー)重複レコードありエラーコード. */
    public static final String TABLE_CHECK_PK_OVERLAP_ERR_CD  = "TABLE_CHECK_ERR_0006";
    /** PK(業務キー)重複レコードありメッセージ. */
    public static final String TABLE_CHECK_PK_OVERLAP_ERR_MSG = "PKが重複したレコードが登録されています。";
    // =======================================================================================================================


    // その他エラー ==========================================================================================================
    /** 予想外エラーコード. */
    public static final String UNEXPECTED_ERR_CD  = "UNEXPECTED_ERR";
    /** 予想外エラーメッセージ. */
    public static final String UNEXPECTED_ERR_MSG = "予期しないエラーが起きました。エラー発生時刻をサーバ管理者に伝えて問い合わせてください。";
    // =======================================================================================================================
}
