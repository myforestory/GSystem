package com.ever.gsystem.constants.entityvalue;

import lombok.experimental.UtilityClass;

/**
 * CSV種類マスタのヘッダ有無フラグ定数クラス.
 *
 * @since   0.0.1-SNAPSHOT
 * @since   2019/11/28
 * @version 0.0.1-SNAPSHOT
 * @author  Hiroshi Takano
 */
@UtilityClass   // Lombokでインスタンスの生成をできないようにする
public final class MstCsvTypeHederPresenceFlag {
    /** なし. */
    public static final byte HEDER_OFF = 0;
    /** あり. */
    public static final byte HEDER_ON  = 1;
}
