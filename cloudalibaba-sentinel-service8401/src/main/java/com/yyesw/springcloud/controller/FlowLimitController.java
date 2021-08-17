package com.yyesw.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author hexinxiang
 * <br/>Date: 2021/8/16
 * <br/>Time: 14:21
 */

@Slf4j
@RestController
public class FlowLimitController {

    @GetMapping("/testA")
    public String testA() {
        log.info(".FlowLimitController testA");
        return "------testA";
    }

    @GetMapping("/testB")
    public String testB() {

        log.info(".FlowLimitController testB,地址{}",Thread.currentThread().getName());
        return "------testB";
    }

    @GetMapping("/testD")
    public String testD()
    {
        //暂停一秒线程
        /*try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
        log.info("testD 测试RT");*/

        log.info("test===异常比例");
        int a=0/0;
        return "------testD";
    }

    @GetMapping("/testE")
    public String testE()
    {
        log.info("testE 测试异常数");
        int age = 10/0;
        return "------testE 测试异常数";
    }

    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey"/*此名称只要唯一即可*/
            , blockHandler = "deal_testHotKey" /*如果有访问违背了控制台的配置热点规则而调用的兜底方法*/)
    public String testHotkey(@RequestParam(value = "p1",required = false)String p1,
                             @RequestParam(value = "p2",required = false)String p2){

        return "---------------testHotkeyO(∩_∩)O~";
    }

    public String deal_testHotKey(String p1, String p2, BlockException exception){

        exception.printStackTrace();
        return "---------------deal_testHotKey！！::>_<::！！";
        ///l / sentinel系统默认的提示:BLocked by sentinel (flow limiting)
    }
}
