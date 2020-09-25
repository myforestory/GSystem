package com.ever.gsystem.constants.api;

import lombok.experimental.UtilityClass;

/**
 * 共通フィールド情報定数クラス.
 *
 * @since   0.0.1-SNAPSHOT
 * @since   2019/12/01
 * @version 0.0.1-SNAPSHOT
 * @author  Hiroshi Takano
 */
@UtilityClass   // Lombokでインスタンスの生成をできないようにする
public final class CmnFiledInfo {
    // 変数順序定義 ==========================================================================================================
    /** 登録日時の変数順序 */
    public static final int INSERT_TIME_POSITION     = 201;
    /** 更新日時の変数順序 */
    public static final int UPDATE_TIME_POSITION     = 202;
    /** 履歴登録日時の変数順序 */
    public static final int HST_INSERT_TIME_POSITION = 203;

    /** 取得レコード開始位置の変数順序 */
    public static final int OFFSET_VARIABLE_POSITION = 501;
    /** 取得レコード数の変数順序 */
    public static final int LIMIT_VARIABLE_POSITION  = 502;
    /** ソート条件の変数順序 */
    public static final int SORT_VARIABLE_POSITION   = 503;
    // =======================================================================================================================
}
