package com.yyesw.springcloud.service;

import ch.qos.logback.core.util.TimeUtil;
import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

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
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000")  //3秒钟以内就是正常的业务逻辑
    } )
    public String paymentInfo_TimeOut(Integer id){

        int timeNumber=3;
        //暂停几秒钟
        //int a=0/0;
        try {
            TimeUnit.SECONDS.sleep(timeNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "线程池： "+Thread.currentThread().getName()+
                "=== paymentInfo_TimeOut,id: "+id+"\t ！！w(ﾟДﾟ)w！！！耗时"+timeNumber+"秒钟";
    }


    public String paymentInfo_TimeOutHandler(Integer id){

        return "线程池： "+Thread.currentThread().getName()+
                "=== paymentInfo_TimeOutHandler,id: "+id+"\t <h1>8001 系统繁忙或者运行报错 请稍后再试</h1>::>_<::~~~~(>_<)~~~~";
    }

    //服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),  //是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),   //请求次数 至少有十个请求才会开启统计
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),  //恢复时间范围 在这个时间范围内不允许服务
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"), //失败率达到多少后跳闸
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        if (id < 0){
            throw new RuntimeException("*****id 不能负数");
        }
        String serialNumber = IdUtil.simpleUUID();

        return Thread.currentThread().getName()+"\t"+"调用成功,流水号："+serialNumber;
    }
    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id){
        return "id 不能负数，请稍候再试,(┬＿┬)/~~     id: " +id;
    }

}
