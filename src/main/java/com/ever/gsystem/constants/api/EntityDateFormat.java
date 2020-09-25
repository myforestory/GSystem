package com.ever.gsystem.constants.api;

import lombok.experimental.UtilityClass;

/**
 * エンティティの日付定数クラス.
 * <p>
 * 日時系の定数を定義する。<br>
 * {@link com.plus_automation.api.domain.entities}の他、<br>
 * {@link com.plus_automation.api.app.controllers.msg.requests}で使用する。<br>
 * </p>
 *
 * @since   0.0.1-SNAPSHOT
 * @since   2019/10/03
 * @version 0.0.1-SNAPSHOT
 * @author  Hiroshi Takano
 */
@UtilityClass   // Lombokでインスタンスの生成をできないようにする
public final class EntityDateFormat {
    /** 汎用日時の日付フォーマット */
    public static final String COMMON_TIME_FORMAT       = "yyyy-MM-dd HH:mm:ss";
    /** 登録日時の日付フォーマット */
    public static final String INSERT_TIME_FORMAT       = "yyyy-MM-dd HH:mm:ss";
    /** 更新日時の日付フォーマット */
    public static final String UPDATE_TIME_FORMAT       = "yyyy-MM-dd HH:mm:ss";
    /** 履歴登録日時の日付フォーマット */
    public static final String HST_INSERT_TIME_FORMAT   = "yyyy-MM-dd HH:mm:ss";
    /** エラーレスポンス返却用日付フォーマット */
    public static final String ERR_RESPONSE_TIME_FORMAT = "yyyy-MM-dd hh:mm:ss.SSS";
}
