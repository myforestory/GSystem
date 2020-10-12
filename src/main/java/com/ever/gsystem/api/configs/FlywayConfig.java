package com.ever.gsystem.api.configs;

import com.ever.gsystem.constants.conf.ApplicationProfileName;
import com.ever.gsystem.constants.properties.ApplicationValue;
import lombok.experimental.FieldNameConstants;
import lombok.extern.slf4j.Slf4j;
import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Objects;

/**
 * Flyway設定.
 * <p>
 * DBマイグレーション用の設定
 * </p>
 *
 * @since   0.0.1-SNAPSHOT
 * @since   2019/10/10
 * @version 0.0.1-SNAPSHOT
 * @author  Hiroshi Takano
 */
@Configuration      // SpringでXMLの代わりにクラスで設定を行う
@FieldNameConstants // Lombokでフィールドの変数名を定数化する。[クラス].Fields.[変数名]でフィールド名をstaticアクセスできる。例）MstItem.Fields.productNoで"productNo"が取り出せる。
@Slf4j              // Lombokでロガーを定義するコードを自動生成する。このアノテーションが付いているクラスでは「log」という変数でロガーにアクセスできる
public class FlywayConfig {
    /** アクティブプロファイル名. */
    @Value(ApplicationValue.PROFILES_ACTIVE_SWITCH)
    private String  PROFILE_NAME;
    /** データベース名. */
    private String  DB_NAME = "local";
    /** FlywayによるDB全削除（DBクリーン）を無効にするフラグ（true=無効、false=有効）. */
    @Value(ApplicationValue.FLAYWAY_CLEAN_DISABLED)
    private boolean FLAYWAY_CLEAN_DISABLED;

    /**
     * Flywayストラテジ設定.
     * <p>
     * Flywayマイグレーションの初期化に使用されるストラテジを設定する。 <br>
     * デフォルトのマイグレーション動作をオーバーライドするために、カスタム実装を{@literal @}{@link Bean}として登録できる。
     * </p>
     *
     * @return Flywayマイグレーションの初期化に使用されるストラテジ設定
     */
    @Bean
    public FlywayMigrationStrategy strategy() {
        return flyway -> { flywayFunction(this, flyway); };
    }

    /**
     * flyway関数.
     *
     * @param config このクラス
     * @param flyway 設定前flyway
     */
    public static void flywayFunction(final FlywayConfig config,
                                      final Flyway flyway) {
        log.info("★アクティブプロファイル名={}、接続DB名={}", config.PROFILE_NAME,
                 config.DB_NAME);

        // DBクリーン無効以外のときにcleanを実行する
        if (!config.FLAYWAY_CLEAN_DISABLED) {
            // 開発環境のときのみ初期化する
            if (!Objects.equals(config.PROFILE_NAME,
                                ApplicationProfileName.PRODUCT)) {
                // 念には念を入れ、本番環境でDBをcleanすることがないようにする
                if (!Objects.equals(config.DB_NAME, "prod")) {
                    // ★★開発環境の場合はデータベースを「すべて」初期化をする（手動で作成したテーブルも含め）
                    flyway.clean();
                    log.info("FlywayによりDBのテーブルを一度初期化しました。={}", flyway.info());
                } else {
                    log.error("「{}」プロファイルで本番用のDB「{}」にアクセスしようとしました。プロファイルを見直してください。",
                              config.PROFILE_NAME, config.DB_NAME);
                    return;
                }
            }
        }

        // マイグレーション実行
        flyway.migrate();
    }
}
