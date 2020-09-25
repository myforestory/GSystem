package com.ever.gsystem.constants.properties;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * メッセージタイプ設定.
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
public class MessageType implements Serializable {
    /** シリアルバージョンUID（このクラスに変化があったら値を変更する）. */
    private static final long serialVersionUID = -5362834057892004024L;

    /** ハートビートメッセージ（WCS→中間システム）. */
    private String wcsToWesHertBeat;
    /** ソートリクエストメッセージ. */
    private String sortRequest;
    /** ダイバートコンファーム（完了通知）メッセージ. */
    private String DivertConfirm;
    /** システムインフォメーションメッセージ. */
    private String systemInformation;

    /** ハートビートメッセージ（中間システム→WCS）. */
    private String wesToWcsHertbeat;
    /** ソートレスポンスメッセージ. */
    private String sortResponse;
}
