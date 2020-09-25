package com.ever.gsystem.constants.properties;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * WCSサーバ（中間システムクライアント→WCSサーバ）設定.
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
public class WcsServer implements Serializable {
    /** シリアルバージョンUID（このクラスに変化があったら値を変更する）. */
    private static final long serialVersionUID = -6306420035725051472L;

    /** WCSサーバのIPアドレス. */
    private String host;

    /** WCSサーバのポート . */
    private int port;

    /**
     * 接続エラー時の再接続待機時間.
     * <p>
     * WCSサーバとの接続時に接続できなかった場合、次に接続を試みるまでの待機時間。
     * </p>
     */
    private long connectErrorSleeptime;

    /**
     * システム情報サービス機能ON/OFF.
     * <p>
     * WCSサーバ起動時にシステム情報を受け取り、中間システムのDBを更新するかどうかのフラグ。<br>
     * </p>
     */
    private boolean receiveSystemInformationAtWakeup;

    /**
     * 送信されたシュート情報がDB側に存在しない場合登録するフラグ.
     * <p>
     * WCSサーバ起動時にシステム情報が送られてきたときに、中間システムのDB側に該当のシュートがない場合、それを登録するかどうかのフラグ。<br>
     * </p>
     */
    private boolean sendChuteIsDbSideDoseNotExistIfRegister;
}
