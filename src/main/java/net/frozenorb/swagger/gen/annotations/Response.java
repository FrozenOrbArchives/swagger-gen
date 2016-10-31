package net.frozenorb.swagger.gen.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface Response {
    int responseCode();
    String desc();
}
