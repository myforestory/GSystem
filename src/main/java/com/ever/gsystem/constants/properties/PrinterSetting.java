package com.ever.gsystem.constants.properties;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * プリンタの独自設定.
 *
 * @since   0.0.1-SNAPSHOT
 * @since   2020/03/06
 * @version 0.0.1-SNAPSHOT
 * @author  Hiroshi Takano
 */
@Data                       // Lombokですべてのフィールドのgetter/setter/equals/canEqual/hashCode/toStringを自動生成する
@Accessors(chain = true)    // Lombokですべてのフィールドのsetterをメソッドチェーンにする
@NoArgsConstructor          // Lombokでデフォルトコンストラクタを自動生成する
@AllArgsConstructor         // Lombokですべてのフィールドの値をセットするための引数付きコンストラクタを自動生成する
@Builder(toBuilder = true)  // Lombokでbuilderパターンを自動生成する
@Component                  // SpringのDIコンテナにbeanとして登録する
@ConfigurationProperties(prefix = ApplicationValue.PRINTER_SETTING_STR)   // applicationプロパティから取得
public class PrinterSetting implements Serializable {
    /** シリアルバージョンUID（このクラスに変化があったら値を変更する）. */
    private static final long serialVersionUID = -4313919766777852557L;

    /**
     * 印刷日時フォーマット.
     * <p>
     * キー：プレースフォルダの囲み文字無し文字列。<br>
     * 値：{@link SimpleDateFormat}の指定形式。<br>
     * <br>
     * 例）「2019年1月2日 3時4分5秒6ミリ秒」を例にします。<br>
     * yyyyMMdd_HHmmss_SSS：20190102_030405_006<br>
     * yyMd_Hms_S：1912_345_6（一桁系は0埋めしなくなる。また、年の場合は2桁「yy」までとなる）<br>
     * </p>
     */
    private String printingDateFormat;

    /**
     * 印刷日時タイムゾーン.
     * <p>
     * タイムゾーンを指定する。<br>
     * </p>
     */
    private String printingDateTimeZone;
}
