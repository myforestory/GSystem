package com.ever.gsystem.annotations;

import com.ever.gsystem.api.domain.repositories.fieldinfo.FiledControllable;

import java.lang.annotation.*;
import java.lang.reflect.Field;

/**
 * Member variable order annotation.
 * <p>
 * Get the {@link Field} array with {@link Class # getDeclaredFields ()} and <br>
 * After that, annotation to determine the order in {@link FiledControllable # sort (Field []) sort ()}. <br>
 * You can manage the order by annotating the member variable with {@link FiledOrder} and specifying a numerical value in {@link #value ()}. <br>
 * The code below is a sample code to get the member variable of own class in the entity.
 * </ p>
 *
 * <pre class = "code">
 * & # 64; {@link FiledOrder} (2)
 * private {@link String} fieldA;
 *
 * & # 64; {@link FiledOrder} (1)
 * private {@link String} fieldB;
 *
 * private {@link String} fieldC;
 *
 * // Get all member variable information for this class
 * final {@link Field} [] fields = EntityA. {@link Class class}. {@Link Class # getDeclaredFields () getDeclaredFields ()};
 *
 * // Sort based on member variable order annotation
 * {@link FiledControllable # sort} (fields);
 * </ pre>
 * <p>
 * The order of fields after executing {@link FiledControllable # sort} () above is [fieldB, fieldA, fieldC]. <br>
 * Since fieldB is specified as 1, you can see that it is the first. <br>
 * FieldC for which no annotation is specified is the last. <br>
 * </ p>
 *
 * @since   0.0.1-SNAPSHOT
 * @since   2020/09/23
 * @version 0.0.1-SNAPSHOT
 * @author  Zeng YanYun
 */
@Retention(RetentionPolicy.RUNTIME) // Range to hold annotations
@Target(ElementType.FIELD)          // Specify where to annotate
@Documented                         // Get the annotation output in Javadoc
public @interface FiledOrder {
    /**
     * Member variable order.
     * <p>
     * Start from 1。
     * </p>
     */
    int value() default 1;
}
