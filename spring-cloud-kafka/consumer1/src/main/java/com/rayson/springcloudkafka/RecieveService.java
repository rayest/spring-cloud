package com.rayson.springcloudkafka;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

/**
 * @author: lirui
 * @date: 2020-05-25 20:21
 */
@EnableBinding(Sink.class)
public class RecieveService {
    @StreamListener(Sink.INPUT)
    public void recieve(Object payload){
        System.out.println(payload);
    }
}
