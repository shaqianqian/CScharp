package com.ifi.tp;

import org.apache.activemq.ActiveMQConnectionFactory;

import org.apache.activemq.ActiveMQSession;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.jms.*;

@SpringBootApplication
public class TrainerWebApp {

    @Bean
    public ActiveMQQueue queue() {
        return new ActiveMQQueue("shop.queue.createOrderInfo");
    }
    public static void main(String... args) throws JMSException {
        SpringApplication.run(TrainerWebApp.class, args);

        MessageProducer producer = null;
        Connection connection = null;
        ConnectionFactory factory = new ActiveMQConnectionFactory("tcp://localhost:61616");
        connection = factory.createConnection();
        ActiveMQSession session = (ActiveMQSession) connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Queue queue = session.createQueue("myQueue2");
        producer = session.createProducer(queue);
        // Topic topic = session.createTopic("myTopic2");
        // producer = session.createProducer(topic);
        TextMessage textMessage = session.createTextMessage();
        textMessage.setText("Hello AMQ2");
        producer.send(textMessage);
        producer.close();
        connection.close();
    }

    }


