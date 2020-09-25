package com.ever.gsystem.constants.properties;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * RFIDデコードルール.
 *
 * @since   0.0.1-SNAPSHOT
 * @since   2020/01/23
 * @version 0.0.1-SNAPSHOT
 * @author  Hiroshi Takano
 */
@Data                       // Lombokですべてのフィールドのgetter/setter/equals/canEqual/hashCode/toStringを自動生成する
@Accessors(chain = true)    // Lombokですべてのフィールドのsetterをメソッドチェーンにする
@NoArgsConstructor          // Lombokでデフォルトコンストラクタを自動生成する
@AllArgsConstructor         // Lombokですべてのフィールドの値をセットするための引数付きコンストラクタを自動生成する
@Builder(toBuilder = true)  // Lombokでbuilderパターンを自動生成する
public class RfidDecodeRule implements Serializable {
    /** シリアルバージョンUID（このクラスに変化があったら値を変更する）. */
    private static final long serialVersionUID = 365197527717368868L;

    /**
     * ルール名.
     * <p>
     * スキャンコードとして抽出するコード名等、ログ出力のために利用される名前。<br>
     * </p>
     */
    private String          ruleName;
    /**
     * 2進数RFIDの切り出し開始位置.
     * <p>
     * 0始まり。1桁目を「0」として数える。<br>
     * 例えば、3桁目を開始としたい場合は、「2」となる。<br>
     * </p>
     */
    private int             binRfidCutoutStartPos;
    /**
     * 2進数RFIDの切り出し長さ.
     * <p>
     * 開始位置から切り出すのか文字列の長さ。<br>
     * 例えば、5とすると開始位置から5文字分切り出す。<br>
     * 「0」の場合は何も行わない。<br>
     * </p>
     */
    private int             binRfidCutoutLen;
    /** 0埋めルール. */
    private ZeroPaddingRule zeroPaddingRule;
    /** 0埋め最大桁数. */
    private int             zeroPaddingMaxDigitNum;

    /** 0埋めルール. */
    public enum ZeroPaddingRule {
        /** 0埋めしない. */
        NONE,
        /** 0埋め最大桁数を左に0埋め（例：最大桁数=5、値=345、0埋め後=00345）. */
        LEFT,
        /** 0埋め最大桁数を右に0埋め（例：最大桁数=5、値=123、0埋め後=12300）. */
        RIGHT
    }
}
