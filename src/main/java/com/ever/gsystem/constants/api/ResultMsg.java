package com.ever.gsystem.constants.api;

import lombok.experimental.UtilityClass;

/**
 * 完了通知メッセージ定数クラス.
 *
 * @since   0.0.1-SNAPSHOT
 * @since   2019/12/11
 * @version 1.1.0
 * @author  Hiroshi Takano
 */
@UtilityClass // Lombokでインスタンスの生成をできないようにする
public final class ResultMsg {
    /** アップロード完了メッセージ. */
    public static final String UPLOAD_RESULT_MSG = "完了";

    /** インポート完了メッセージ. */
    public static final String IMPORT_RESULT_MSG = "完了";

    /** シュート割付完了メッセージ. */
    public static final String ASSIGN_RESULT_MSG = "シュート割付完了";

    /** バッチ開始完了メッセージ. */
    public static final String TASK_START_RESULT_OK_MSG = "OK";
    /** バッチ開始失敗メッセージ. */
    public static final String TASK_START_RESULT_NG_MSG = "NG";

    /** バッチ一時保留メッセージ. */
    public static final String TASK_TEMPORARY_HOLDING_ON_RESULT_OK_MSG = "OK";
    /** バッチ一時保留メッセージ. */
    public static final String TASK_TEMPORARY_HOLDING_ON_RESULT_NG_MSG = "NG";

    /** バッチ一時保留解除メッセージ. */
    public static final String TASK_TEMPORARY_HOLDING_OFF_RESULT_OK_MSG = "OK";
    /** バッチ一時保留解除メッセージ. */
    public static final String TASK_TEMPORARY_HOLDING_OFF_RESULT_NG_MSG = "NG";

    /** バッチ取り消し完了メッセージ. */
    public static final String TASK_CANCEL_RESULT_OK_MSG = "OK";
    /** バッチ取り消し失敗メッセージ. */
    public static final String TASK_CANCEL_RESULT_NG_MSG = "NG";

    /** タスク終了成功メッセージ。 */
    public static final String TASK_END_RESULT_OK_MSG = "OK";
    /** タスク終了失敗メッセージ。 */
    public static final String TASK_END_RESULT_NG_MSG = "NG";

    /** シュートスキャン正常メッセージ. */
    public static final String CHUTE_SCAN_RESULT_OK_MSG = "読み取り成功";
    /** シュートスキャン失敗メッセージ. */
    public static final String CHUTE_SCAN_RESULT_NG_MSG = "読み取り失敗";

    /** シュートスキャン詳細メッセージ シュート開始から停止. */
    public static final String CHUTE_SCAN_RESULT_DETAIL_MSG_START_TO_STOP = "シュートが停止しました。箱入替え作業を開始してください。";
    /** シュートスキャン詳細メッセージ シュート停止から開始. */
    public static final String CHUTE_SCAN_RESULT_DETAIL_MSG_STOP_TO_START = "シュートを開始しました。";
    /** シュートスキャン詳細メッセージ 読取失敗メッセージ. */
    public static final String CHUTE_SCAN_RESULT_DETAIL_MSG_READ_ERROR    = "登録されていないシュートがスキャンされました。";
    /** シュートスキャン詳細メッセージ 印刷失敗メッセージ. */
    public static final String CHUTE_SCAN_RESULT_DETAIL_MSG_PRINT_ERROR   = "印刷に失敗しました。もう一度シュートをスキャンしてください。何度か失敗した場合はサーバかプリンタに問題がある可能性があります。";

    /** シュートスキャン詳細メッセージ 印刷失敗メッセージ 対象タスクが存在しない. */
    public static final String CHUTE_SCAN_RESULT_DETAIL_MSG_PRINT_ERROR_TARGET_TASK_NOT_EXISTS = "印刷に失敗しました。シュートに格納したタスクを見つけることができませんでした。停止しようとしたシュートに割り当てられているタスクが存在しないか空のシュートの可能性があります。";

    /** シュート取得詳細メッセージ 読取失敗メッセージ. */
    public static final String GET_CHUTE_RESULT_DETAIL_MSG_READ_ERROR = "登録されていないシュートがスキャンされました。";
    /** シュート取得詳細メッセージ リクエスト空メッセージ. */
    public static final String GET_CHUTE_REQUEST_ERR_MSG              = "シュートNoを指定してください。";

    /** シュートラベル取得詳細メッセージ 正常メッセージ. */
    public static final String GET_CHUTE_LABEL_OK_MSG          = "印刷に成功しました。";
    /** シュートラベル取得詳細メッセージ シュートマスタ空エラーメッセージ. */
    public static final String GET_CHUTE_LABEL_ERR_MSG         = "印刷に失敗しました。シュートマスタを確認してください。";
    /** シュートラベル取得詳細メッセージ シュートNOエラーメッセージ. */
    public static final String GET_CHUTE_LABEL_CHUTENO_ERR_MSG = "印刷に失敗しました。Fromを指定してください。";

    /** シュート更新詳細メッセージ 読取失敗メッセージ. */
    public static final String UPDATE_CHUTE_RESULT_DETAIL_MSG_READ_ERROR    = "登録されていないシュートがスキャンされました。";
    /** シュート更新詳細メッセージ シュート開始から停止. */
    public static final String UPDATE_CHUTE_RESULT_DETAIL_MSG_START_TO_STOP = "シュートが停止しました。箱入替え作業を開始してください。";
    /** シュート更新詳細メッセージ シュート停止から開始. */
    public static final String UPDATE_CHUTE_RESULT_DETAIL_MSG_STOP_TO_START = "シュートが開始しました。";
    /** シュート更新詳細メッセージ リクエストシュートNo空メッセージ. */
    public static final String UPDATE_CHUTE_CHUTE_NO_EMPTY_MSG              = "シュートNoを指定してください。";
    /** シュート更新詳細メッセージ リクエストステータス空メッセージ. */
    public static final String UPDATE_CHUTE_STATUS_EMPTY_MSG                = "ステータスを指定してください。";

    /** デバイス情報取得メッセージ デバイス取得失敗メッセージ. */
    public static final String GET_DEVICE_NG_MSG          = "デバイス情報が取得できませんでした。デバイス情報が登録されていない可能性があります。";
    /** デバイス情報取得メッセージ デバイス取得失敗メッセージ. */
    public static final String GET_DEVICE_REQUEST_ERR_MSG = "デバイス情報を指定してください。";

    /** ラベル作成詳細メッセージ シュートNoよりタスク取得失敗メッセージ. */
    public static final String CREATE_LABEL_BY_CHUTE_NO_NG_MSG = "スキャンされたシュートは箱入れ替え対象ではありませんでした。タスクを確認してください。";
    /** ラベル作成詳細メッセージ 箱番号よりタスク取得失敗メッセージ. */
    public static final String CREATE_LABEL_BY_BOX_NO_NG_MSG   = "箱IDが間違っています。";
    /** ラベル作成詳細メッセージ リクエスト空メッセージ. */
    public static final String CREATE_LABEL_REQUEST_ERR_MSG    = "シュートNoあるいは箱IDを指定してください。";

    /** デバイス情報作成正常メッセージ. */
    public static final String CREATE_DEVICE_OK_MSG                           = "ペアリングに成功しました。";
    /** デバイス情報作成失敗メッセージ. */
    public static final String CREATE_DEVICE_NG_MSG                           = "ペアリングに失敗しました。";
    /** デバイス情報作成メッセージ リクエスト空メッセージ. */
    public static final String CREATE_DEVICE_REQUEST_ERR_MSG                  = "デバイス情報を指定してください。";
    /** デバイス情報作成メッセージ 外部デバイスID空メッセージ. */
    public static final String CREATE_DEVICE_EXTERNAL_DEVICE_ID_EMPTY_ERR_MSG = "ペアリングに失敗しました。外部デバイスIDを指定してください。";
    /** デバイス情報作成メッセージ BluetoothアドレスまたはIPアドレス空メッセージ. */
    public static final String CREATE_DEVICE_PRINTER_EMPTY_ERR_MSG            = "ペアリングに失敗しました。BluetoothアドレスあるいはIPアドレスを指定してください。";

    /** 到着通知正常メッセージ. */
    public static final String ARRIVAL_NOTIFICATION_OK_MSG           = "到着に成功しました。";
    /** 到着通知失敗メッセージ. */
    public static final String ARRIVAL_NOTIFICATION_NG_MSG           = "到着に失敗しました。";
    /** インダクション取得詳細メッセージ リクエスト空メッセージ. */
    public static final String GET_INDUCTION_REQUEST_ERR_MSG         = "インダクションが見つかりませんでした。インダクションを設定してください。";
    /** インダクション取得詳細メッセージ 読取失敗メッセージ. */
    public static final String GET_SCAN_SYSTEM_FIELD_REQUEST_ERR_MSG = "リクエストが空です。";
    /** スキャン確定詳細メッセージ デバイス取得失敗メッセージ. */
    public static final String SCAN_CONFIRM_DEVICE_EMPTY_ERR_MSG     = "デバイス情報が取得できませんでした。インダクション設定を行ってください。";
    /** スキャン確定詳細メッセージ インダクション取得失敗メッセージ. */
    public static final String SCAN_CONFIRM_INDUCTION_EMPTY_ERR_MSG  = "インダクション情報が取得できませんでした。インダクション設定を行ってください。";
    /** スキャン確定詳細メッセージ ロボット不在メッセージ. */
    public static final String SCAN_CONFIRM_ROBOT_EXIST_ERR_MSG      = "ロボットが投入口にいません。しばらくお待ちください。";
    /** スキャン確定詳細メッセージ ロボット緊急停止中メッセージ. */
    public static final String SCAN_CONFIRM_EMERGENCY_STOP_ERR_MSG   = "ロボットが緊急停止中です。";
    //    /** スキャン確定詳細メッセージ タスク取得失敗メッセージ. */
    //    public static final String SCAN_CONFIRM_TASK_EMPTY_ERR_MSG       = "作業を行おうとしていたタスクが消えました。スキャンし直してください。";


    /** インダクションとデバイスの紐づけ機能正常メッセージ. */
    public static final String LINK_INDUCTION_DEVICE_OK_MSG = "に紐づけられました。";
    /** インダクションとデバイスの紐づけ機能失敗メッセージ. */
    public static final String LINK_INDUCTION_DEVICE_NG_MSG = "インダクションの紐づけに失敗しました。インダクションを登録してください。";
}
