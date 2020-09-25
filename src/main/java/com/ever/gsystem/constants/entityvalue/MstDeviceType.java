package com.ever.gsystem.constants.entityvalue;

import lombok.experimental.UtilityClass;

/**
 * デバイスマスタのタイプ文字定数クラス.
 *
 * @since   1.0.4
 * @since   2020/07/21
 * @version 1.0.4
 * @author  Zeng YanYun
 */
@UtilityClass   // Lombokでインスタンスの生成をできないようにする
public final class MstDeviceType {
    /** 0：HT. */
    public static final byte HT      = 0;
    /** 1：プリンタ. */
    public static final byte PRINTER = 1;
}
