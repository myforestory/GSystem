package com.ever.gsystem.constants.properties;

import java.io.Serializable;
import com.ever.gsystem.constants.properties.RfidDecodeRule.ZeroPaddingRule;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * Item Code切り出しルール.
 *
 * @since   1.0.0
 * @since   2020/05/16
 * @version 1.0.0
 * @author  Hiroshi Takano
 */
@Data                       // Lombokですべてのフィールドのgetter/setter/equals/canEqual/hashCode/toStringを自動生成する
@Accessors(chain = true)    // Lombokですべてのフィールドのsetterをメソッドチェーンにする
@NoArgsConstructor          // Lombokでデフォルトコンストラクタを自動生成する
@AllArgsConstructor         // Lombokですべてのフィールドの値をセットするための引数付きコンストラクタを自動生成する
@Builder(toBuilder = true)  // Lombokでbuilderパターンを自動生成する
public class ItemCodeeMidRule implements Serializable {
    /** シリアルバージョンUID（このクラスに変化があったら値を変更する）. */
    private static final long serialVersionUID = -1090797947300730586L;

    /** ルールキー. */
    private String ruleKey;

    /**
     * 切り出し開始位置.
     * <p>
     * 0始まり。1桁目を「0」として数える。<br>
     * 例えば、3桁目を開始としたい場合は、「2」となる。<br>
     * </p>
     */
    private int cutoutStartPos;

    /**
     * 切り出し長さ.
     * <p>
     * 開始位置から切り出すのか文字列の長さ。<br>
     * 例えば、5とすると開始位置から5文字分切り出す。<br>
     * 「0」の場合は何も行わない。<br>
     * </p>
     */
    private int cutoutLen;

    /** 0埋めルール. */
    private ZeroPaddingRule zeroPaddingRule;

    /** 0埋め最大桁数. */
    private int zeroPaddingMaxDigitNum;
}
