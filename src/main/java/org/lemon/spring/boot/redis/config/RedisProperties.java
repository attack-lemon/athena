package org.lemon.spring.boot.redis.config;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.lemon.spring.boot.redis.annotation.ConditionalOnFile;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;


/**
 * redis配置
 * @Author lemon
 * @Date 2020/05/01
 */
@Configuration
@ConfigurationProperties(prefix = "redis")
@ConditionalOnFile(locations = {"file:${spring.config.location}/redis/athena-${spring.profiles.active}.yml", "classpath:redis/athena-${spring.profiles.active}.yml"})
public class RedisProperties {
    @Getter
    @Setter
    private Athena athena;

    @Data
    public static class Athena {
        private Instance instance;
        private Pool pool;
    }

    /**
     * 单实例配制
     */
    @Data
    public static class Instance {
        private String host;
        private Integer port;
        private String password;
        private Long timeout;
        private Integer database;
    }

    /**
     * 连接池配置
     */
    @Data
    public static class Pool {
        private Integer minIdle;
        private Integer maxIdle;
        private Integer maxWait;
        private Integer maxActive;
    }
}
