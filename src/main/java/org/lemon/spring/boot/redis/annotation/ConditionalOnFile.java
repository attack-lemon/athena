package org.lemon.spring.boot.redis.annotation;

import org.springframework.context.annotation.Conditional;

import java.lang.annotation.*;

/**
 * @Author lemon
 * @Date 2020/5/2
 */
@Target({ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Conditional(OnConditionalOnFile.class)
public @interface ConditionalOnFile {
    String[] locations() default {};
}
