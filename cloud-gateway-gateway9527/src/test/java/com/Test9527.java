package com;

import org.junit.jupiter.api.Test;

import java.time.ZonedDateTime;

/**
 * @author hexinxiang
 * <br/>Date: 2021/8/13
 * <br/>Time: 16:21
 */

public class Test9527 {

    @Test
    public void testTime(){

        ZonedDateTime now = ZonedDateTime.now();
        System.out.println(now);
        /*
        2021-08-13T16:23:38.549+08:00[Asia/Shanghai]
         */
    }
}
