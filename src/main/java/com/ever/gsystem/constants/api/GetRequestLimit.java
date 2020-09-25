package com.ever.gsystem.constants.api;

import lombok.experimental.UtilityClass;

/**
 * リクエストメッセージの文字数制限定数クラス.
 *
 * @since   0.0.1-SNAPSHOT
 * @since   2019/11/25
 * @version 0.0.1-SNAPSHOT
 * @author  Hiroshi Takano
 */
@UtilityClass   // Lombokでインスタンスの生成をできないようにする
public final class GetRequestLimit {
    /** 検索のテキスト最小文字数. */
    public static final int TEXT_MIN  = 1;
    /** 検索のテキスト最大文字数. */
    public static final int TEXT_MAX  = 5000;
    /** 検索の数値最小値. */
    public static final int NUM_MIN   = 0;
    /** 検索の数値最大値. */
    public static final int NUM_MAX   = 2000000000;
    /** 検索のリスト最小値. */
    public static final int LIST_MIN  = 0;
    /** 検索のリスト最大値. */
    public static final int LIST_MAX  = Integer.MAX_VALUE;
    /** 検索の取得レコード数最小値. */
    public static final int LIMIT_MIN = 0;
    /** 検索の取得レコード数最大値. */
    public static final int LIMIT_MAX = 1000;
}
