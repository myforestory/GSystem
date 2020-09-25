package com.ever.gsystem.constants.entityvalue;

import lombok.experimental.UtilityClass;

/**
 * 警告時発信フラグ定数クラス.
 *
 * @since   1.1.0
 * @since   2020/09/02
 * @version 1.1.0
 * @author  Shizu Taniyama
 */
@UtilityClass   // Lombokでインスタンスの生成をできないようにする
public final class ScanConfirmGoFlagOnWarn {
    /** OFF. */
    public static final byte OFF         = 0;
    /** OFF（ラッパー）. */
    public static final Byte WRAPPER_OFF = Byte.valueOf(OFF);

    /** ON. */
    public static final byte ON         = 1;
    /** ON（ラッパー）. */
    public static final Byte WRAPPER_ON = Byte.valueOf(ON);
}
