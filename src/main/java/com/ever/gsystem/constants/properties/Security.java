package com.ever.gsystem.constants.properties;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * セキュリティ設定.
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
public class Security implements Serializable {
    /** シリアルバージョンUID（このクラスに変化があったら値を変更する）. */
    private static final long serialVersionUID = -8679943440053106418L;

    /** 予期せぬ例外が発生したときに、発生時刻以外に例外内容を出すかどうか. */
    private UnexpectedErrType unexpectedErrMsg;

    /** 例外発生時のメッセージ種類. */
    public enum UnexpectedErrType {
        /** 出力しない. */
        NONE,
        /** 一部だけ内容を出力. */
        PARTIAL,
        /** 例外をすべて出力. */
        FULL
    }
}
