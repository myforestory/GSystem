package com.ever.gsystem.constants;

import lombok.experimental.UtilityClass;

/**
 * パッケージ名定数クラス.
 *
 * @since   0.0.1-SNAPSHOT
 * @since   2019/11/21
 * @version 0.0.1-SNAPSHOT
 * @author  Hiroshi Takano
 */
@UtilityClass   // Lombokでインスタンスの生成をできないようにする
public final class PackageName {
    /**
     * 定数パッケージ.
     * <p>
     * 以下のパッケージ構成と同じ値を定義しなくてはならない。<br>
     * {@link com.plus_automation.constants}<br>
     * </p>
     */
    public static final String CONSTANTS           = "com.plus_automation.constants";
    /**
     * 設定クラスパッケージ.
     * <p>
     * 以下のパッケージ構成と同じ値を定義しなくてはならない。<br>
     * {@link com.plus_automation.api.configs}<br>
     * </p>
     */
    public static final String CONFIGS             = "com.plus_automation.api.configs";
    /**
     * コントローラパッケージ.
     * <p>
     * 以下のパッケージ構成と同じ値を定義しなくてはならない。<br>
     * {@link com.plus_automation.api.app.controllers}<br>
     * </p>
     */
    public static final String CONTROLLERS         = "com.plus_automation.api.app.controllers";
    /**
     * エンティティパッケージ.
     * <p>
     * 以下のパッケージ構成と同じ値を定義しなくてはならない。<br>
     * {@link com.plus_automation.api.domain.entities}<br>
     * </p>
     */
    public static final String ENTITIES            = "com.plus_automation.api.domain.entities";
    /**
     * サービスパッケージ.
     * <p>
     * 以下のパッケージ構成と同じ値を定義しなくてはならない。<br>
     * {@link com.plus_automation.api.domain.services}<br>
     * </p>
     */
    public static final String SERVICES            = "com.plus_automation.api.domain.services";
    /**
     * プライマリリポジトリパッケージ.
     * <p>
     * 以下のパッケージ構成と同じ値を定義しなくてはならない。<br>
     * {@link com.plus_automation.api.domain.repositories.db1}<br>
     * </p>
     */
    public static final String PRIMARY_REPOSITORES = "com.plus_automation.api.domain.repositories.db1";
    /**
     * セカンダリリポジトリパッケージ.
     * <p>
     * 以下のパッケージ構成と同じ値を定義しなくてはならない。<br>
     * {@link com.plus_automation.api.domain.repositories.db2}<br>
     * </p>
     */
    public static final String REPOSITORES2        = "com.plus_automation.api.domain.repositories.db2";
    /**
     * インバウンドサーバパッケージ.
     * <p>
     * 以下のパッケージ構成と同じ値を定義しなくてはならない。<br>
     * {@link com.plus_automation.io.inbound}<br>
     * </p>
     */
    public static final String INBOUND             = "com.plus_automation.io.inbound";
    /**
     * アウトバウンドクライアントパッケージ.
     * <p>
     * 以下のパッケージ構成と同じ値を定義しなくてはならない。<br>
     * {@link com.plus_automation.io.outbound}<br>
     * </p>
     */
    public static final String OUTBOUND            = "com.plus_automation.io.outbound";
}
