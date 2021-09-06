package com.sql.ehremail.controller;

import com.alibaba.fastjson.JSON;
import com.sql.ehremail.Tools.MailTool;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

@RestController
public class HolisticController {

    @Autowired(required=false)
    private KafkaTemplate<String,Object> kafkaTemplate;


    @GetMapping("/sendEmail")
    public void sendEmail(@RequestParam HashMap<String,Object> map){
        ConcurrentHashMap currentMap=new ConcurrentHashMap(map);
        System.out.println("currentMap:"+currentMap.toString());
        System.out.println("JSON.toJSON(currentMap).toString():"+JSON.toJSON(currentMap).toString());
        kafkaTemplate.send("test", JSON.toJSON(currentMap).toString()).addCallback(success -> {
            // 消息发送到的topic
            String topic = success.getRecordMetadata().topic();
            // 消息发送到的分区
            int partition = success.getRecordMetadata().partition();
            // 消息在分区内的offset
            long offset = success.getRecordMetadata().offset();
            System.out.println("发送消息成功:" + topic + "-" + partition + "-" + offset);
        }, failure -> {
            System.out.println("发送消息失败:" + failure.getMessage());
        });
        System.out.printf("调用sendEmail方法");
    }
    @Autowired
    MailTool mailTool;
    @Value("${spring.mail.username}")
    String fromMail;
    // 消费监听
    @KafkaListener(topics = {"test"})
    public void onMessage1(ConsumerRecord<?, ?> record){
        System.out.println("调用KafkaListener方法");
        // 消费的哪个topic、partition的消息,打印出消息内容1
        System.out.println("简单消费："+record.topic()+"-"+record.partition()+"-"+record.value());
        ConcurrentHashMap map=JSON.parseObject(record.value().toString(), ConcurrentHashMap.class);
        System.out.println("ConcurrentHashMap:"+map);
        System.out.println("fromMail:"+fromMail);
        mailTool.sendSimpleMail("ehr系统注册码","您的注册码已生产，请完成激活："+map.get("registerCode").toString(),fromMail ,map.get("eemail").toString());
    }
}
