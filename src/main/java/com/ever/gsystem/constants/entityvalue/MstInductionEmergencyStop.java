package com.ever.gsystem.constants.entityvalue;

import lombok.experimental.UtilityClass;

/**
 * インダクションマスタの緊急停止文字定数クラス.
 *
 * @since   1.1.0
 * @since   2020/08/28
 * @version 1.1.0
 * @author  Miji Jo
 */
@UtilityClass   // Lombokでインスタンスの生成をできないようにする
public final class MstInductionEmergencyStop {
    /** エラー復旧. */
    public static final byte ERROR_RECOVERY         = 0;
    /** エラー復旧（ラッパー）. */
    public static final Byte WRAPPER_ERROR_RECOVERY = Byte.valueOf(ERROR_RECOVERY);
    /** エラー時. */
    public static final byte ERROR_STOP             = 1;
    /** エラー時（ラッパー）. */
    public static final Byte WRAPPER_ERROR_STOP     = Byte.valueOf(ERROR_STOP);
}
