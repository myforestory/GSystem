package com.ever.gsystem.constants.entityvalue;

import lombok.experimental.UtilityClass;

/**
 * CSV種類マスタの区切り文字定数クラス.
 *
 * @since   0.0.1-SNAPSHOT
 * @since   2019/11/28
 * @version 0.0.1-SNAPSHOT
 * @author  Hiroshi Takano
 */
@UtilityClass   // Lombokでインスタンスの生成をできないようにする
public final class MstCsvTypeDelimiter {
    /** タブ. */
    public static final byte TAB   = 0;
    /** カンマ. */
    public static final byte COMMA = 1;
}
