package com.rayson.springcloudkafka;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author: lirui
 * @date: 2020-05-25 20:10
 */
@RestController
public class KafkaController {

    @Resource
    private KafkaService kafkaService;

    @GetMapping("/producer")
    public void send(@RequestParam("msg") String msg){
        kafkaService.send(msg);
    }
}
