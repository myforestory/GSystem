package com.ever.gsystem.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Annotations not included in coverage.
 * <p>
 * By adding this annotation, it can be excluded from JaCoCo coverage. <br>
 * Attach to places that are not executed in unit tests, such as the main class. <br>
 * Do not attach to classes that can be unit tested! <br>
 * </p>
 *
 * @since   0.0.1-SNAPSHOT
 * @since   2020/09/23
 * @version 0.0.1-SNAPSHOT
 * @author  Zeng YanYun
 */
@Retention(RetentionPolicy.CLASS) // Range to hold annotations
@Documented                       // Have Javadoc output annotations
public @interface Generated {/* 空 */}
