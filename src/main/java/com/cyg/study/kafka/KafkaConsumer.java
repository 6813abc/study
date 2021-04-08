package com.cyg.study.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.PartitionOffset;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;

/**
 * @author cyg
 * @date 2021/4/6 20:58
 **/
@Component
public class KafkaConsumer {

    //消费监听
    @KafkaListener(groupId = "test-consumer-group", topics = "test")
    public void onMessage1(ConsumerRecord<?, ?> record) {
        // 消费的哪个topic、partition的消息,打印出消息内容
        System.out.println("onMessage1简单消费：" + record.topic() + "-" + record.partition() + "-" + record.key() + "-" + record.value());
    }

    //消费监听
    @KafkaListener(groupId = "test-consumer-group1", topicPartitions = {@TopicPartition(topic = "test1",
            partitionOffsets = @PartitionOffset(partition = "0", initialOffset = "-1"))})
    public void onMessage2(ConsumerRecord<?, ?> record) {
        // 消费的哪个topic、partition的消息,打印出消息内容
        System.out.println("onMessage2简单消费：" + record.topic() + "-" + record.partition() + "-" + record.key() + "-" + record.value());
    }
}
