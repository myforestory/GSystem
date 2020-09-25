package com.ever.gsystem.constants.entityvalue;

import lombok.experimental.UtilityClass;

/**
 * CSV種類マスタの画面の表示有無フラグ定数クラス.
 *
 * @since   0.0.1-SNAPSHOT
 * @since   2019/11/28
 * @version 0.0.1-SNAPSHOT
 * @author  Hiroshi Takano
 */
@UtilityClass   // Lombokでインスタンスの生成をできないようにする
public final class MstCsvTypeVisible {
    /** 表示しない. */
    public static final byte HIDE         = 0;
    /** 表示しない（ラッパー）. */
    public static final Byte WRAPPER_HIDE = Byte.valueOf(HIDE);
    /** 表示する. */
    public static final byte SHOW         = 1;
    /** 表示する（ラッパー）. */
    public static final Byte WRAPPER_SHOW = Byte.valueOf(SHOW);
}
