package com.ifi.tp.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Destination;

@Component
public class CreateOrderInfoProducer {
    Destination destination = new ActiveMQQueue("notification");

    //注入spirng帮我们封装好的JMS模板类
    @Autowired
    private JmsTemplate jmsTemplate;

    public void sendMessage(Long userId){
        //实用JMS模板类发送消息
        jmsTemplate.convertAndSend(destination,"hello");
    }



}
