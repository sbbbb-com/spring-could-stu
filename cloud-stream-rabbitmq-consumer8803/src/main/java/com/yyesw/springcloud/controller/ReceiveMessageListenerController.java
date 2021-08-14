package com.yyesw.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @author hexinxiang
 * <br/>Date: 2021/8/14
 * <br/>Time: 21:35
 */

@Slf4j
@EnableBinding(Sink.class/*具有一个输入通道的可绑定接口。*/)
@Component
public class ReceiveMessageListenerController {

    @Value("${server.port}")
    private String serverPort;


    @StreamListener(Sink.INPUT)
    public void input(Message<String> message/*接收消息*/){

       log.info("消费者2号：------》接收到的消息【{}】,端口号：{}",message.getPayload(),serverPort);
    }
}
