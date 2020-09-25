package com.ever.gsystem.constants.properties;

/**
 * 重複レコードの動作モード.
 * <p>
 * 重複レコードがあった場合の動作を定義する。<br>
 * </p>
 *
 * @since   0.0.1-SNAPSHOT
 * @since   2020/03/20
 * @version 0.0.1-SNAPSHOT
 * @author  Hiroshi Takano
 */
public enum DuplicateRecordsOperationMode {
    /**
     * 再登録.
     * <p>
     * 登録日時と更新日時を現在時刻に更新しUPDATEを行う。<br>
     * </p>
     */
    REREGISTRATION,

    /**
     * 上書き.
     * <p>
     * 登録日時はDB側の重複レコードのままで、更新日時だけを現在時刻に更新しUPDATEを行う。<br>
     * </p>
     */
    OVERWRITING,

    /**
     * エラー.
     * <p>
     * エラー扱いにし、DBのロールバックを行う。<br>
     * </p>
     */
    ERROR,
}
