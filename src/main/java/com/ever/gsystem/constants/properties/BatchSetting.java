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
 * バッチ管理画面設定.
 *
 * @since   1.0.1-SNAPSHOT
 * @since   2020/06/25
 * @version 1.0.1-SNAPSHOT
 * @author  Yuri Narasawa
 */
@Data                       // Lombokですべてのフィールドのgetter/setter/equals/canEqual/hashCode/toStringを自動生成する
@Accessors(chain = true)    // Lombokですべてのフィールドのsetterをメソッドチェーンにする
@NoArgsConstructor          // Lombokでデフォルトコンストラクタを自動生成する
@AllArgsConstructor         // Lombokですべてのフィールドの値をセットするための引数付きコンストラクタを自動生成する
@Builder(toBuilder = true)  // Lombokでbuilderパターンを自動生成する
@Component                  // SpringのDIコンテナにbeanとして登録する
@ConfigurationProperties(prefix = ApplicationValue.BATCH_SETTING_STR)   // applicationプロパティから取得
public class BatchSetting implements Serializable {
	/** シリアルバージョンUID（このクラスに変化があったら値を変更する）. */
	private static final long serialVersionUID = -974308659831886364L;
	
    /**
     * 一時保留ボタン表示 .
     * <p>
     * バッチ管理画面の一時保留ボタンの表示設定を行う。<br>
     * </p>
     */
    private String showTemporaryHolding;

}
