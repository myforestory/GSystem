package com.ever.gsystem.constants.entityvalue;

import lombok.experimental.UtilityClass;

/**
 * テーブル管理マスタのデータタイプ定数クラス.
 *
 * @since   0.0.1-SNAPSHOT
 * @since   2019/11/24
 * @version 0.0.1-SNAPSHOT
 * @author  Hiroshi Takano
 */
@UtilityClass   // Lombokでインスタンスの生成をできないようにする
public final class MstTableManagementDataType {
    /** テキスト. */
    public static final byte TEXT_TYPE = 0;
    /** 数値. */
    public static final byte NUM_TYPE  = 1;
    /** リスト. */
    public static final byte LIST_TYPE = 2;
    /** 日時. */
    public static final byte DATE_TYPE = 3;
}
