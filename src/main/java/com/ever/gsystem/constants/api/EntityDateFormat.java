package com.ever.gsystem.constants.api;

import lombok.experimental.UtilityClass;

/**
 * Entity date constant class.
 * <p>
 * Define date and time constants。<br>
 * {@link com.ever.gsystem.api.domain.entities}<br>
 * </p>
 *
 * @since   0.0.1-SNAPSHOT
 * @since   2020/09/23
 * @version 0.0.1-SNAPSHOT
 * @author  Zeng YanYun
 */
@UtilityClass   // Prevent Lombok from being instantiated.
public final class EntityDateFormat {
    /** 泛用日期時間FORMAT */
    public static final String COMMON_TIME_FORMAT       = "yyyy-MM-dd HH:mm:ss";
    /** 新增日期時間FORMAT */
    public static final String INSERT_TIME_FORMAT       = "yyyy-MM-dd HH:mm:ss";
    /** 更新日期時間FORMAT */
    public static final String UPDATE_TIME_FORMAT       = "yyyy-MM-dd HH:mm:ss";
    /** 上架日期時間FORMAT */
    public static final String UPLOAD_TIME_FORMAT       = "yyyy-MM-dd HH:mm:ss";
    /** 下架日期時間FORMAT */
    public static final String REMOVE_TIME_FORMAT       = "yyyy-MM-dd HH:mm:ss";
    /** ERROR RESPONSE返回用FORMAT */
    public static final String ERR_RESPONSE_TIME_FORMAT = "yyyy-MM-dd hh:mm:ss.SSS";
}
