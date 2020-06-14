package com.learn.shiro;

import com.learn.shiro.util.BaseUtil;
import com.learn.shiro.util.PropertiesUtil;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.junit.Test;

/**
 * @author SuanCaiYv
 * @time 2020/6/14 下午3:06
 */
public class ShiroTest {

    @Test
    public void contextTest() {

        System.out.println(PropertiesUtil.getProperties("jdbc.url"));
    }
}
