package com.ever.gsystem.constants.entityvalue;

import lombok.experimental.UtilityClass;

/**
 * バッチ＆タスクトランザクションのステータス定数クラス.
 *
 * @since   0.0.1-SNAPSHOT
 * @since   2019/12/12
 * @version 0.0.1-SNAPSHOT
 * @author  Hiroshi Takano
 */
@UtilityClass   // Lombokでインスタンスの生成をできないようにする
public final class BatchTaskStatus {
    /** 未処理. */
    public static final byte NOT_PROCESSED         = 0;
    /** 未処理（ラッパー）. */
    public static final Byte WRAPPER_NOT_PROCESSED = Byte.valueOf(NOT_PROCESSED);

    /** 割当済. */
    public static final byte ASSIGNED         = 1;
    /** 割当済（ラッパー）. */
    public static final Byte WRAPPER_ASSIGNED = Byte.valueOf(ASSIGNED);

    /** 開始済. */
    public static final byte STARTED         = 2;
    /** 開始済（ラッパー）. */
    public static final Byte WRAPPER_STARTED = Byte.valueOf(STARTED);

    /** 処理中. */
    public static final byte PROCESSING         = 3;
    /** 処理中（ラッパー）. */
    public static final Byte WRAPPER_PROCESSING = Byte.valueOf(PROCESSING);

    /** 完了済. */
    public static final byte COMPLETED         = 4;
    /** 完了済（ラッパー）. */
    public static final Byte WRAPPER_COMPLETED = Byte.valueOf(COMPLETED);

    /** 終了. */
    public static final byte FINISHED         = 5;
    /** 終了（ラッパー）. */
    public static final Byte WRAPPER_FINISHED = Byte.valueOf(FINISHED);
}
