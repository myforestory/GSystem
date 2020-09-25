package com.ever.gsystem.constants.properties;

import java.io.Serializable;
import java.nio.charset.Charset;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 中間システムアウトバウンドクライアント設定.
 *
 * @since   0.0.1-SNAPSHOT
 * @since   2020/01/26
 * @version 0.0.1-SNAPSHOT
 * @author  Hiroshi Takano
 */
@Data                       // Lombokですべてのフィールドのgetter/setter/equals/canEqual/hashCode/toStringを自動生成する
@Accessors(chain = true)    // Lombokですべてのフィールドのsetterをメソッドチェーンにする
@NoArgsConstructor          // Lombokでデフォルトコンストラクタを自動生成する
@AllArgsConstructor         // Lombokですべてのフィールドの値をセットするための引数付きコンストラクタを自動生成する
@Builder(toBuilder = true)  // Lombokでbuilderパターンを自動生成する
@Component                  // SpringのDIコンテナにbeanとして登録する
@ConfigurationProperties(prefix = ApplicationValue.OUTBND_CLIENT_STR)   // applicationプロパティから取得
public class OutbndClient implements Serializable {
    /** シリアルバージョンUID（このクラスに変化があったら値を変更する）. */
    private static final long serialVersionUID = 1721635818877069073L;

    /** クライアントの起動遅延時間（ミリ秒）. */
    private String startDelaytime;

    /** イベント発生間隔（ミリ秒）. */
    private int updatetime;

    /* ハートビート間隔（ミリ秒）. **/
    private int heartbeattime;

    /** ボディのエンコード. */
    private Charset bodyEncode;
}
