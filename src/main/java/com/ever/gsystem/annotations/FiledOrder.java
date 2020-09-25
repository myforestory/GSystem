package com.ever.gsystem.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import com.ever.gsystem.api.domain.repositories.fieldinfo.FiledControllable;

/**
 * メンバ変数順序アノテーション.
 * <p>
 * {@link Class#getDeclaredFields()}で{@link Field}配列を取得し、<br>
 * その後、{@link FiledControllable#sort(Field[]) sort()}内で順序を決めるためのアノテーション。<br>
 * メンバ変数に対して{@link FiledOrder}をアノテーションとして付け、{@link #value()}に数値を指定することで順序を管理できる。<br>
 * 下記はコードはエンティティ内で自クラスのメンバ変数を取得するコードのサンプルである。
 * </p>
 *
 * <pre class="code">
 * &#64;{@link FiledOrder}(2)
 * private {@link String} fieldA;
 *
 * &#64;{@link FiledOrder}(1)
 * private {@link String} fieldB;
 *
 * private {@link String} fieldC;
 *
 * // このクラスのメンバ変数情報をすべて取得
 * final {@link Field}[] fields = EntityA.{@link Class class}.{@link Class#getDeclaredFields() getDeclaredFields()};
 *
 * // メンバ変数順序アノテーションに基づいてソート
 * {@link FiledControllable#sort}(fields);
 * </pre>
 * <p>
 * 上記の{@link FiledControllable#sort}()を実行した後のfieldsの順序は、[fieldB, fieldA, fieldC]となる。<br>
 * fieldBは1と指定したので、1番目になっていることが分かる。<br>
 * アノテーションの指定がなかったfieldCは最後になる。<br>
 * </p>
 *
 * @since   0.0.1-SNAPSHOT
 * @since   2019/10/04
 * @version 0.0.1-SNAPSHOT
 * @author  Hiroshi Takano
 */
@Retention(RetentionPolicy.RUNTIME) // アノテーションを保持する範囲
@Target(ElementType.FIELD)          // どこにアノテーションを付けられるかの指定
@Documented                         // Javadocでアノテーションを出力してもらう
public @interface FiledOrder {
    /**
     * メンバ変数順序.
     * <p>
     * 1から始めること。
     * </p>
     */
    int value() default 1;
}
