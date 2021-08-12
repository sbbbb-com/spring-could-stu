package com.yyesw.springcloud.service;

import ch.qos.logback.core.util.TimeUtil;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author hexinxiang
 * <br/>Date: 2021/8/12
 * <br/>Time: 10:06
 */

@Service
public class PaymentService {

    /**
     * 正常访问 必定成功的方法
     * @param id
     * @return
     */
    public String paymentInfo_OK(Integer id){

        return "线程池： "+Thread.currentThread().getName()+
                "=== paymentInfo_Ok,id: "+id+"\t O(∩_∩)O~";
    }

    public String paymentInfo_TimeOut(Integer id){

        int timeNumber=3;

        //暂停几秒钟
        try {
            TimeUnit.SECONDS.sleep(timeNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池： "+Thread.currentThread().getName()+
                "=== paymentInfo_TimeOut,id: "+id+"\t ！！w(ﾟДﾟ)w！！！耗时"+timeNumber+"秒钟";
    }
}
