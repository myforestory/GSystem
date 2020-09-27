package com.ever.gsystem.constants.api;

import lombok.experimental.UtilityClass;

/**
 * Common field information constant class.
 *
 * @since   0.0.1-SNAPSHOT
 * @since   2020/09/23
 * @version 0.0.1-SNAPSHOT
 * @author  Zeng YanYun
 */
@UtilityClass   //Prevent Lombok from being instantiated.
public final class CmnFiledInfo {
    // 變數順序定義 ==========================================================================================================
    /** 新增日期時間變數順序 */
    public static final int INSERT_TIME_POSITION     = 201;
    /** 更新日期時間變數順序 */
    public static final int UPDATE_TIME_POSITION     = 202;
    /** 更新日期時間變數順序 */
    public static final int UPLOAD_TIME_POSITION     = 203;
    /** 刪除日期時間變數順序 */
    public static final int REMOVE_TIME_POSITION     = 203;

    /** 取得資料開始位置變數順序 */
    public static final int OFFSET_VARIABLE_POSITION = 501;
    /** 取得資料數變數順序 */
    public static final int LIMIT_VARIABLE_POSITION  = 502;
    /** 排序條件變數順序 */
    public static final int SORT_VARIABLE_POSITION   = 503;
    // =======================================================================================================================
}
