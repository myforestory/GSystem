package com.ever.gsystem.constants.entityvalue;

import lombok.experimental.UtilityClass;

/**
 * シュートマスタのステータス文字定数クラス.
 *
 * @since   0.0.1-SNAPSHOT
 * @since   2019/12/15
 * @version 0.0.1-SNAPSHOT
 * @author  Hiroshi Takano
 */
@UtilityClass   // Lombokでインスタンスの生成をできないようにする
public final class MstChuteStatus {
    /** 停止. */
    public static final byte STOP  = 0;
    /** 開始. */
    public static final byte START = 1;
}
