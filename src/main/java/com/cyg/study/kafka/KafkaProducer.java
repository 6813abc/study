package com.cyg.study.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cyg
 * @date 2021/4/6 20:57
 **/
@RestController
public class KafkaProducer {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    @Autowired(required = false)
    public KafkaProducer(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }


    // 发送消息
    @GetMapping("/kafka/normal/{message}")
    public void sendMessage1(@PathVariable("message") String normalMessage) {
        kafkaTemplate.send("test", 0, "1", normalMessage);
        kafkaTemplate.send("test1", 0, "2", normalMessage);
    }
}
