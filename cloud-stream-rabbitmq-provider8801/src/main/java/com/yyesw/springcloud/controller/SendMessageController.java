package com.yyesw.springcloud.controller;

import com.yyesw.springcloud.service.IMessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author hexinxiang
 * <br/>Date: 2021/8/14
 * <br/>Time: 17:55
 */

@RestController
public class SendMessageController {

    @Resource
    private IMessageProvider messageProvider;

    @GetMapping("/sendMessage")
    public String sendMessage(){

        return messageProvider.send();
    }
}
