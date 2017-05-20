package com.test.bean;

import javax.annotation.Resource;

import org.junit.Test;

import com.factoring.core.feature.test.TestSupport;

/**
 * SpiderTest : 爬虫测试类
 *
 * @author 
 *  2014-10-27 22:44
 */
public class SpiderTest extends TestSupport {

    @Resource
    private Spider spider;

    @Test
    public void testInjectSpider() throws Exception {
        System.out.println(spider);
    }
}
