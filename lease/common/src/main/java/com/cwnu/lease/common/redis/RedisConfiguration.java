package com.cwnu.lease.common.redis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

/**
 * Redis配置类，用于配置RedisTemplate的序列化方式等。
 *
 * @author jisam
 * @version 1.0
 * @contact "jisamchan@outlook.com"
 * @date 16/04/2025
 */
@Configuration
public class RedisConfiguration {

    /**
     * 创建并配置一个RedisTemplate实例，用于操作Redis中的字符串和对象。
     *
     * @param redisConnectionFactory Redis连接工厂
     * @return 配置好的RedisTemplate实例
     */
    @Bean
    public RedisTemplate<String, Object> stringObjectRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);
        template.setKeySerializer(RedisSerializer.string());
        template.setValueSerializer(RedisSerializer.java());

        return template;
    }
}
