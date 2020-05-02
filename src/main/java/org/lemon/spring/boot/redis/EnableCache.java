package org.lemon.spring.boot.redis;

import org.lemon.spring.boot.redis.config.RedisConfiguration;
import org.springframework.context.annotation.Import;

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
@Import(RedisConfiguration.class)
public @interface EnableCache {
}
