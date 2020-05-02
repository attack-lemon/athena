package org.lemon.spring.boot.redis.Serializer;

import java.io.IOException;

/**
 * @Author lemon
 * @Date 2020/5/2
 */
public interface Serializer {
    /**
     * 元素序列化
     * @param object
     * @return
     */
    byte[] enSerialize(Object object);

    /**
     * 元素反序列化
     * @param bytes
     * @param type
     * @param <T>
     * @return
     * @throws IOException
     */
    <T> T deSerialize(byte[] bytes, Class<T> type) throws IOException;
}
