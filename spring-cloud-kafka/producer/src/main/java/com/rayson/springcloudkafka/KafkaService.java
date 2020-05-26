package com.rayson.springcloudkafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

/**
 * @author: lirui
 * @date: 2020-05-25 20:13
 */
@EnableBinding(Source.class)
public class KafkaService {

    @Autowired
    private Source source;

    public void send(String msg) {
        source.output().send(MessageBuilder.withPayload(msg).build());
    }
}
