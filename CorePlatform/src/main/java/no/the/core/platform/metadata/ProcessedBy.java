package no.the.core.platform.metadata;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
//ElementType.TYPE: Class, interface (including annotation type), or enum declaration
@Retention(RetentionPolicy.RUNTIME)
public @interface ProcessedBy {
    Class<?> value();
}
