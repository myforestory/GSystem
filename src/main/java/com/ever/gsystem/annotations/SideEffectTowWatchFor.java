package com.ever.gsystem.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 副作用有り注意の注釈.
 * <p>
 * このアノテーションを付けたパラメータ（引数）が、<br>
 * メソッド内部でそのパラメータの値を変更すること（副作用のあるパラメータであること）を示す。<br>
 * ただのマーカのため、このアノテーション自体に機能を持たない。<br>
 * JavaDocで確認するためなどに使う。<br>
 * </p>
 *
 * @since   1.0.0
 * @since   2020/05/16
 * @version 1.0.0
 * @author  Hiroshi Takano
 */
@Retention(RetentionPolicy.CLASS) // アノテーションを保持する範囲
@Target(ElementType.PARAMETER)    // どこにアノテーションを付けられるかの指定
@Documented                       // Javadocでアノテーションを出力してもらう
public @interface SideEffectTowWatchFor {
    /** 副作用説明. */
    String value() default "";
}
