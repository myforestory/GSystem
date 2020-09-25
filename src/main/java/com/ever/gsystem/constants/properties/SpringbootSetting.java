package com.ever.gsystem.constants.properties;

import java.io.Serializable;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * Spring Boot独自設定.
 *
 * @since   0.0.1-SNAPSHOT
 * @since   2020/01/31
 * @version 0.0.1-SNAPSHOT
 * @author  Hiroshi Takano
 */
@Data                       // Lombokですべてのフィールドのgetter/setter/equals/canEqual/hashCode/toStringを自動生成する
@Accessors(chain = true)    // Lombokですべてのフィールドのsetterをメソッドチェーンにする
@NoArgsConstructor          // Lombokでデフォルトコンストラクタを自動生成する
@AllArgsConstructor         // Lombokですべてのフィールドの値をセットするための引数付きコンストラクタを自動生成する
@Builder(toBuilder = true)  // Lombokでbuilderパターンを自動生成する
@Component                  // SpringのDIコンテナにbeanとして登録する
@ConfigurationProperties(prefix = ApplicationValue.SPRINGBOOT_SETTING_STR)   // applicationプロパティから取得
public class SpringbootSetting implements Serializable {
    /** シリアルバージョンUID（このクラスに変化があったら値を変更する）. */
    private static final long serialVersionUID = 152418818006082556L;

    /** APIサーバの再起動設定（true:APIリクエストで再起動できるようにする、false:APIリクエストで再起動できないようにする）. */
    private boolean canRestarted;

    /** APIサーバの再起動にGETリクエストも使えるようにする（true:GETで再起動できるようにする、false:GETで再起動できないようにする）. */
    private boolean canGetRestarted;

    /** GETリクエストのバリデーション（true:行う、false:行わない）. */
    private boolean getValidator;

    /** セキュリティ設定. */
    private Security security;

    /** cronスケジュール設定. */
    private Cron cron;
}
