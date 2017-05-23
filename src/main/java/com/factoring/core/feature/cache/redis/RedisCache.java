package com.factoring.core.feature.cache.redis;

import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

/**
 * RedisCache : redis 缓存 插件
 *
 * @author 
 *  2015-03-20 11:12
 */
@Component(value = "redisCache")
public class RedisCache {
    private static int port = 6379;
    private static String host = "120.25.97.145";
    private static Jedis jedis = new Jedis(host, port);

    public static String cache(String key, String value, int seconds) {
        String result = jedis.set(key, value);
        jedis.expire(key, seconds);
        return result;
    }

    public static String get(String key) {
        return jedis.get(key);
    }
}
