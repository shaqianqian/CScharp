package com.ifi.tp.service;

import com.ifi.tp.bo.HPNotification;
import com.ifi.tp.bo.Pokemon;
import com.ifi.tp.bo.Trainer;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.ActiveMQSession;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.jms.*;

@Service
public class NotificationServiceImpl implements NotificationService {

    private JmsTemplate jmsTemplate;
    Destination destination = new ActiveMQQueue("notification");

    @Autowired
    public NotificationServiceImpl(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    @Override
    public void sendNotification(String message) {

        this.jmsTemplate.convertAndSend(destination, message);
    }


    @Override
    public void sendOneHPRecoveredNotification(Trainer trainer, Pokemon pokemon) {
        var hpNotification = new HPNotification();
        hpNotification.setTrainer(trainer);
        hpNotification.setPokemon(pokemon);
        hpNotification.setFullHP(false);

        this.jmsTemplate.convertAndSend(destination, hpNotification);
    }

    @Override
    public void sendFullHPRecoveredNotification(Trainer trainer, Pokemon pokemon) {
        var hpNotification = new HPNotification();
        hpNotification.setTrainer(trainer);
        hpNotification.setPokemon(pokemon);
        hpNotification.setFullHP(true);

        this.jmsTemplate.convertAndSend(destination, hpNotification);
    }


    @Override
    public void test() throws JMSException {
//        Destination destination = new ActiveMQQueue("notification");
//        MessageProducer producer = null;
//        Connection connection = null;
//        ConnectionFactory factory = new ActiveMQConnectionFactory("tcp://localhost:61616");
//        connection = factory.createConnection();
//        ActiveMQSession session = (ActiveMQSession) connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
//        Queue queue = session.createQueue("notification");
//        producer = session.createProducer(queue);
//        // Topic topic = session.createTopic("myTopic2");
//        // producer = session.createProducer(topic);
//        TextMessage textMessage = session.createTextMessage();
//        textMessage.setText("Coucou les amis, coucou les copains");
//        producer.send(textMessage);
//        producer.close();
//        connection.close();

      this.jmsTemplate.convertAndSend(destination, "hello");

    }
}
