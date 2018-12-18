package com.ifi.tp.service;

import com.ifi.tp.bo.Pokemon;
import com.ifi.tp.bo.Trainer;

import javax.jms.JMSException;

public interface NotificationService {

    void sendNotification(String message);

    void sendOneHPRecoveredNotification(Trainer trainer, Pokemon pokemon);

    void sendFullHPRecoveredNotification(Trainer trainer, Pokemon pokemon);
    void test() throws JMSException;
}
