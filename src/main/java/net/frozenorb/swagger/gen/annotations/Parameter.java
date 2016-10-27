package net.frozenorb.swagger.gen.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
@Repeatable(Parameters.class)
public @interface Parameter {
    /**
     * The name of the parameter
     */
    String name();

    /**
     * The description of the parameter
     * @return
     */
    String desc() default "Some parameter";

    String type() default "String";
}
