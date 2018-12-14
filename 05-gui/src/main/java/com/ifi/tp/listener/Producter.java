package com.ifi.tp.listener;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Destination;

@Component
public class Producter {

    //确定消息发送到哪个地点
    Destination destination = new ActiveMQQueue("mytest.queue");

    //注入spirng帮我们封装好的JMS模板类
    @Autowired
    private JmsTemplate jmsTemplate;

    /**
     * 发送创建订单消息的方法
     * userId 哪个用户下的订单
     */
    public void sendMessage(String notification){
        //实用JMS模板类发送消息
        jmsTemplate.convertAndSend(destination,notification);
    }


}
