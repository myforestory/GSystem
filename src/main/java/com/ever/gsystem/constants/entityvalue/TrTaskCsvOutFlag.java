package com.ever.gsystem.constants.entityvalue;

import lombok.experimental.UtilityClass;

/**
 * 自動CSV出力フラグ定数クラス.
 *
 * @since   0.0.1-SNAPSHOT
 * @since   2020/02/13
 * @version 0.0.1-SNAPSHOT
 * @author  Hiroshi Takano
 */
@UtilityClass   // Lombokでインスタンスの生成をできないようにする
public final class TrTaskCsvOutFlag {
    /** 未出力. */
    public static final byte UNPRINTED         = 0;
    /** 未出力（ラッパー）. */
    public static final Byte WRAPPER_UNPRINTED = Byte.valueOf(UNPRINTED);

    /** 出力済. */
    public static final byte PRINTED         = 1;
    /** 出力済（ラッパー）. */
    public static final Byte WRAPPER_PRINTED = Byte.valueOf(PRINTED);
}
