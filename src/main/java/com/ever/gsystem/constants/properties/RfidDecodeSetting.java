package com.ever.gsystem.constants.properties;

import java.io.Serializable;
import java.util.List;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * RFIDデコード設定.
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
@Component                  // SpringのDIコンテナにbeanとして登録する
@ConfigurationProperties(prefix = ApplicationValue.RFID_DECODE_SETTING_STR)   // applicationプロパティから取得
public class RfidDecodeSetting implements Serializable {
    /** シリアルバージョンUID（このクラスに変化があったら値を変更する）. */
    private static final long serialVersionUID = -4813256208220667016L;

    /** チェックディジット補正有無. */
    private boolean checkDigitCorrection;

    /** 変換ルール. */
    private ConvertingRule convertingRule;

    /** RFIDデコードルールリスト. */
    private List<RfidDecodeRule> rules;

    /** 変換ルール. */
    public enum ConvertingRule {
        /**
         * RFID指定位置切り出し10進数変換.
         * <p>
         * 16進数RFID→2進数RFID→指定桁数切り出し→切り出した2進数を10進数へ変換。<br>
         * </p>
         */
        HEX_TO_BIN_TO_DEC,
        /**
         * RFID指定位置切り出し2進化10進数変換.
         * <p>
         * 16進数RFID→2進数RFID→指定桁数切り出し→切り出した2進数を10進数へ変換。<br>
         * </p>
         */
        HEX_TO_BIN_TO_BCD,
        /**
         * SGTIN-96ビット変換.
         * <p>
         * EPC Tag Data Standard v1.09（EPCデータ識別標準仕様）に基づいたデコードを行う。<br>
         * 上記デコード情報のうち、GS1 Company Prefix（GS1事業者コード）＋Item
         * Reference（商品アイテムコード）＋チェックディジットを組み合わせてスキャンコードとする。<br>
         * <br>
         * 【参考資料】<br>
         * </p>
         * <ul>
         * <li><a href=
         * "https://www.gs1.org/sites/default/files/docs/epc/TDS_1_9_Standard.pdf">EPC Tag
         * Data Standard（EPCデータ識別標準仕様） ※参考にした標準仕様</a></li>
         * <li><a href= "https://www.dsri.jp/standard/epc/about_epc.html">一般財団法人
         * 流通システム開発センターの日本語資料</a></li>
         * <li><a href=
         * "https://www.jaisa.or.jp/pdfs/170531/002.pdf?v=1.3">UHF帯RFID標準コード体系ガイドライン
         * v1.3（日本語）</a></li>
         * <li><a href= "https://www.gs1.org/epcglobal">GS1本部サイト（英語） EPC Global</a></li>
         * </ul>
         */
        SGTIN_96
    }
}
