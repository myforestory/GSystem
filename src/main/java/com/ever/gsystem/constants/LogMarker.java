package com.ever.gsystem.constants;

import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import lombok.experimental.UtilityClass;

/**
 * ログフィルタ用のマーカ.
 *
 * @since   0.0.1-SNAPSHOT
 * @since   2020/01/29
 * @version 0.0.1-SNAPSHOT
 * @author  Hiroshi Takano
 */
@UtilityClass   // Lombokでインスタンスの生成をできないようにする
public final class LogMarker {
    /** メッセージ系のサフィックス */
    public static String SUFFIX_MSG               = "_MSG";
    /** ハートビートメッセージ（WCS→中間システム）ログマーカ. */
    public static Marker WCS_TO_IS_HEART_BEAT_MSG = MarkerFactory.getMarker("600"
                                                                            + SUFFIX_MSG);
    /** ハートビートメッセージ（中間システム→WCS）ログマーカ. */
    public static Marker IS_TO_WCS_HEART_BEAT_MSG = MarkerFactory.getMarker("700"
                                                                            + SUFFIX_MSG);
}
