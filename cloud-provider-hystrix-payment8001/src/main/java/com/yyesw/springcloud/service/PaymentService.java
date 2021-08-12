package com.yyesw.springcloud.service;

import ch.qos.logback.core.util.TimeUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
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


    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties ={
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")  //3秒钟以内就是正常的业务逻辑
    } )
    public String paymentInfo_TimeOut(Integer id){

        int timeNumber=4;

        //暂停几秒钟
        int a=0/0;
       /* try {
            TimeUnit.SECONDS.sleep(timeNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        return "线程池： "+Thread.currentThread().getName()+
                "=== paymentInfo_TimeOut,id: "+id+"\t ！！w(ﾟДﾟ)w！！！耗时"+timeNumber+"秒钟";
    }


    public String paymentInfo_TimeOutHandler(Integer id){

        return "线程池： "+Thread.currentThread().getName()+
                "=== paymentInfo_TimeOutHandler,id: "+id+"\t <h1>系统繁忙或者运行报错 请稍后再试</h1>::>_<::~~~~(>_<)~~~~";
    }
}
