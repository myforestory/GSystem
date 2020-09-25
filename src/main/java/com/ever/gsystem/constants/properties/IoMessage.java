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
 * インバウンドサーバ/アウトバウンドクライアントのメッセージ設定.
 *
 * @since   0.0.1-SNAPSHOT
 * @since   2020/03/18
 * @version 0.0.1-SNAPSHOT
 * @author  Hiroshi Takano
 */
@Data                       // Lombokですべてのフィールドのgetter/setter/equals/canEqual/hashCode/toStringを自動生成する
@Accessors(chain = true)    // Lombokですべてのフィールドのsetterをメソッドチェーンにする
@NoArgsConstructor          // Lombokでデフォルトコンストラクタを自動生成する
@AllArgsConstructor         // Lombokですべてのフィールドの値をセットするための引数付きコンストラクタを自動生成する
@Builder(toBuilder = true)  // Lombokでbuilderパターンを自動生成する
@Component                  // SpringのDIコンテナにbeanとして登録する
@ConfigurationProperties(prefix = ApplicationValue.IO_MESSAGE_STR)   // applicationプロパティから取得
public class IoMessage implements Serializable {
    /** シリアルバージョンUID（このクラスに変化があったら値を変更する）. */
    private static final long serialVersionUID = -4823897032285216928L;

    /** メッセージタイプ. */
    private MessageType messageType;
}
