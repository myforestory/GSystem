package com.ever.gsystem.constants.conf;

import lombok.experimental.UtilityClass;

/**
 * プロファイル名定数クラス.
 * <p>
 * application.ymlもしくはapplication.xmlのプロファイル名。<br>
 * {@link com.plus_automation.api.configs}配下で使用。
 * </p>
 *
 * @since   0.0.1-SNAPSHOT
 * @since   2019/11/22
 * @version 0.0.1-SNAPSHOT
 * @author  Hiroshi Takano
 */
@UtilityClass   // Lombokでインスタンスの生成をできないようにする
public final class ApplicationProfileName {
    /** ローカル開発用プロファイル名 */
    public static final String LOCAL_DEV  = "local";
    /** 開発用プロファイル名 */
    public static final String REMOTE_DEV = "dev";
    /** テスト用プロファイル名 */
    public static final String TEST_DEV   = "test";
    /** ローカル開発用プロファイル名 */
    public static final String PRODUCT    = "prod";
}
