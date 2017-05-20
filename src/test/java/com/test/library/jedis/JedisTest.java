package com.test.library.jedis;

import javax.annotation.Resource;

import org.junit.Test;

import com.factoring.core.feature.cache.redis.RedisCache;
import com.factoring.core.feature.test.TestSupport;

/**
 * JedisTest : 测试 jedis 功能
 *
 * @author 
 *  2015-03-20 10:32
 */
public class JedisTest extends TestSupport {


    @Resource
    private RedisCache redisCache;


    @Test
    public void testSet() {
        redisCache.cache("anchor", "", 1 * 60 * 24);
    }

    @Test
    public void testGet() {
        System.out.printf(redisCache.get("anchor"));
    }
}
