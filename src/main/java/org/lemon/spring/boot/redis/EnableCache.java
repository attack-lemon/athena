package org.lemon.spring.boot.redis;

import java.lang.annotation.*;

/**
 * 缓存开关
 * @Author lemon
 * @Date 2020-05-01
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface EnableCache {
}
