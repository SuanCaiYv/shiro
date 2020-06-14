package com.learn.shiro.util;

import java.util.Random;

/**
 * @author SuanCaiYv
 * @time 2020/6/10 下午9:57
 */
public class BaseUtil {

    private static final Random random = new Random();

    public static String getSalt() {

        int val = random.nextInt() % 999999;
        val = Math.abs(val);
        String salt = String.format("%06d", val);
        val = random.nextInt()%99999999;
        val = Math.abs(val);
        int sum = 0;
        for (int i = 0; i < 4; ++ i) {
            int a = val%10;
            val /= 10;
            int b = val%10;
            val /= 10;
            sum += a*b;
        }
        salt += String.format("%04d", sum);
        return salt;
    }
}
