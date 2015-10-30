package com.liuwill.testng.demo;

import com.liuwill.demo.util.RedisUtil;
import org.testng.annotations.Test;

/**
 * Created by Administrator on 2015/10/27.
 */
public class JRedisTest {

    @Test(groups = {"redis","util","data"})
    public void testRedisPool() {
        RedisUtil.getJedis().set("newname", "中文测试");
        System.out.println(RedisUtil.getJedis().get("newname"));
    }
}
