package com.gray.base.activeMQ.service.impl;

import com.gray.base.activeMQ.service.RemindService;
import com.gray.user.entity.User;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Created by lenovo on 2017/3/11.
 */
@Component
public class RemindServiceImpl implements RemindService {
    @Autowired
    JmsTemplate jmsTemplate;
    @Autowired
    Destination queue;
    @Override
    public void sendRegisterRemind(final User user) {
        jmsTemplate.send(queue, new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createObjectMessage(user);
            }
        });
    }
}
