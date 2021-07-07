package org.lemon.spring.boot.redis.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.redis.connection.lettuce.DefaultLettucePool;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettucePool;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import javax.annotation.Resource;

/**
 * @Author lemon
 * @Date 2020/5/2
 */
@Configuration
@AutoConfigureAfter(RedisAutoConfiguration.class)
@Import(RedisAutoConfiguration.class)
public class RedisConfiguration {
    @Resource
    private RedisProperties redisProperties;

    @Bean
    public LettuceConnectionFactory lettuceConnectionFactory() {
        GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
        poolConfig.setMaxIdle(redisProperties.getAthena().getPool().getMaxIdle());
        poolConfig.setMinIdle(redisProperties.getAthena().getPool().getMinIdle());
        poolConfig.setMaxWaitMillis(redisProperties.getAthena().getPool().getMaxWait());
        poolConfig.setMaxTotal(redisProperties.getAthena().getPool().getMaxActive());

        LettucePool lettucePool = new DefaultLettucePool(redisProperties.getAthena().getInstance().getHost(), redisProperties.getAthena().getInstance().getPort(), poolConfig);

        LettuceConnectionFactory factory = new LettuceConnectionFactory(lettucePool);
        factory.setPassword(redisProperties.getAthena().getInstance().getPassword());
        factory.setTimeout(redisProperties.getAthena().getInstance().getTimeout());
        factory.setDatabase(redisProperties.getAthena().getInstance().getDatabase());
        factory.afterPropertiesSet();
        return factory;
    }

    @Bean
    public RedisTemplate<String, Object> redisCacheTemplate(LettuceConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        setSerializer(template);
        template.setConnectionFactory(redisConnectionFactory);
        return template;
    }

    private void setSerializer(RedisTemplate<String, Object> template) {
        Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<>(Object.class);
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(om);
        RedisSerializer<String> stringSerializer = new StringRedisSerializer();
        template.setKeySerializer(stringSerializer );
        template.setValueSerializer(stringSerializer );
        template.setHashKeySerializer(stringSerializer );
        template.setHashValueSerializer(stringSerializer );
    }

}
