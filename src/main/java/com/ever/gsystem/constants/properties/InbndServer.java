package com.ever.gsystem.constants.properties;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * インバウンドサーバ（WCSクライアント→中間システムサーバ）設定.
 *
 * @since   0.0.1-SNAPSHOT
 * @since   2020/02/01
 * @version 0.0.1-SNAPSHOT
 * @author  Hiroshi Takano
 */
@Data                       // Lombokですべてのフィールドのgetter/setter/equals/canEqual/hashCode/toStringを自動生成する
@Accessors(chain = true)    // Lombokですべてのフィールドのsetterをメソッドチェーンにする
@NoArgsConstructor          // Lombokでデフォルトコンストラクタを自動生成する
@AllArgsConstructor         // Lombokですべてのフィールドの値をセットするための引数付きコンストラクタを自動生成する
@Builder(toBuilder = true)  // Lombokでbuilderパターンを自動生成する
public class InbndServer implements Serializable {
    /** シリアルバージョンUID（このクラスに変化があったら値を変更する）. */
    private static final long serialVersionUID = -7218589585766944341L;

    /** インバウンドサーバのIPアドレス. */
    private String host;

    /** インバウンドサーバのポート . */
    private int port;

    /**
     * 最小受信バッファサイズ.
     * <p>
     * このサイズ受信するまでバッファに溜めておくバイト数。<br>
     * </p>
     */
    private int minReceiveBufSize;

    /**
     * 最大受信バッファサイズ.
     * <p>
     * 受信バッファに溜めておける最大バイト数。<br>
     * </p>
     */
    private int maxReceiveBufSize;

    /** サーバの起動遅延時間（ミリ秒）. */
    private long startDelaytime;

    /** バインドエラー時の次に接続（bind()）するまでのスリープ時間（ミリ秒）. */
    private long bindErrorSleeptime;

    /**
     * read()タイムアウト時間（ミリ秒）.
     * <p>
     * クライアントがwrite()しない場合、タイムアウトする時間（ミリ秒）。<br>
     * WCSから定期的にハートビートが送られてくるため、ハートビートが途絶えたときのタイムアウト時間となる。<br>
     * </p>
     */
    private long readTimeouttime;
}
