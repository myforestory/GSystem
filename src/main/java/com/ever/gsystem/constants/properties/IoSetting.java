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
 * インバウンドサーバ/アウトバウンドクライアント設定.
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
@Component                  // SpringのDIコンテナにbeanとして登録する
@ConfigurationProperties(prefix = ApplicationValue.IO_SETTING_STR)   // applicationプロパティから取得
public class IoSetting implements Serializable {
    /** シリアルバージョンUID（このクラスに変化があったら値を変更する）. */
    private static final long serialVersionUID = -3496538122003156786L;

    /**
     * 中間システムのシステム名（英数字10桁まで）.
     * <p>
     * WCSへ送信するメッセージのSourceに設定される。<br>
     * </p>
     */
    private String systemname;

    /** インバウンドサーバ（WCSクライアント→中間システムサーバ）設定. */
    private InbndServer inbndServer;

    /** WCSサーバ（中間システムクライアント→WCSサーバ）設定. */
    private WcsServer wcsServer;

    /** アウトバウンドクライアント設定. */
    private OutbndClient outbndClient;

    /** インバウンドサーバ/アウトバウンドクライアントのメッセージ設定. */
    private IoMessage ioMessage;
}
