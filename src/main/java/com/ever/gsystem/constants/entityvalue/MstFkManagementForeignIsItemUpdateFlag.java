package com.ever.gsystem.constants.entityvalue;

import lombok.experimental.UtilityClass;

/**
 * FK管理マスタの外部中間システム項目更新フラグ定数クラス.
 *
 * @since   1.0.9
 * @since   2020/08/18
 * @version 1.0.9
 * @author  Shizu Taniyama
 */
@UtilityClass   // Lombokでインスタンスの生成をできないようにする
public final class MstFkManagementForeignIsItemUpdateFlag {
    /** FKキーとしてFKチェックおよびFK更新に使用する項目. */
    public static final byte OFF         = 0;
    /** FKキーとしてFKチェックおよびFK更新に使用する項目（ラッパー）. */
    public static final Byte WRAPPER_OFF = Byte.valueOf(OFF);

    /** FK更新のみに使用する項目. */
    public static final byte ON         = 1;
    /** FK更新のみに使用する項目（ラッパー）. */
    public static final Byte WRAPPER_ON = Byte.valueOf(ON);
}
