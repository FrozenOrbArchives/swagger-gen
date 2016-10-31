package net.frozenorb.swagger.gen.annotations;

import net.frozenorb.swagger.gen.ParameterLoc;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
@Repeatable(Parameters.class)
public @interface Parameter {
    String name();

    String desc() default "Some parameter";

    String type() default "string";

    ParameterLoc in() default ParameterLoc.QUERY;

    boolean required() default false;
}
