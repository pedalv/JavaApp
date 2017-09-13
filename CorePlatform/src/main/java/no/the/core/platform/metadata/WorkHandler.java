package no.the.core.platform.metadata;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
//ElementType.TYPE: Class, interface (including annotation type), or enum declaration
@Retention(RetentionPolicy.RUNTIME)
public @interface WorkHandler {

    boolean useThreadPool();

}

/*
    - boolean useThreadPool() default true;

    @WorkHandler <=> @WorkHandler(useThreadPool = true)
    @WorkHandler(useThreadPool = false)



    - boolean value() default true;

    @WorkHandler <=> @WorkHandler(true)
    @WorkHandler(false)

    - Valid Annottaion Element types
    1. Primitive type
    2. String
    3. Enum
    4. Annottaion
    5. Class<?>


 */