package com.yyesw.springcloud.service.impl;

import com.yyesw.springcloud.service.IMessageProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author hexinxiang
 * <br/>Date: 2021/8/14
 * <br/>Time: 17:44
 */

@Slf4j
@EnableBinding(Source.class)  //[定义消息的推送管道]
public class MessageProviderImpl implements IMessageProvider {

    @Resource
    private MessageChannel output; //定义消息发送管道

    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());

        log.info("serial===={}",serial);
        return null;
    }
}
