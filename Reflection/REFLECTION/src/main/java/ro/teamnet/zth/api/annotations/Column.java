package ro.teamnet.zth.api.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by Adrian.Calancea on 7/7/16.
 */
@Target(FIELD)
@Retention(RUNTIME)

public @interface Column {
    String name() default "";
        }
