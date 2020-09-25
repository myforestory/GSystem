package com.ever.gsystem.constants.entityvalue;

import lombok.experimental.UtilityClass;

/**
 * バッチ＆タスクトランザクションの一時保留定数クラス.
 *
 * @since   1.0.1-SNAPSHOT
 * @since   2020/06/17
 * @version 1.0.1-SNAPSHOT
 * @author  Zeng YanYun
 */
@UtilityClass   // Lombokでインスタンスの生成をできないようにする
public final class BatchTaskTemporaryHolding {
    /** 保留なし. */
    public static final byte OFF         = 0;
    /** 保留なし（ラッパー）. */
    public static final Byte WRAPPER_OFF = Byte.valueOf(OFF);

    /** 保留中. */
    public static final byte ON         = 1;
    /** 保留中（ラッパー）. */
    public static final Byte WRAPPER_ON = Byte.valueOf(ON);
}
