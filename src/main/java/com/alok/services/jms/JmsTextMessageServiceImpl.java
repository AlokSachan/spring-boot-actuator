package com.alok.services.jms;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Queue;

@Service
@RequiredArgsConstructor(onConstructor = @__ (@Autowired))
public class JmsTextMessageServiceImpl implements JmsTextMessageService{

    private final Queue textMessageQueue;
    private final JmsTemplate jmsTemplate;

    @Override
    public void sendTextMessage(String msg) {
        this.jmsTemplate.convertAndSend(this.textMessageQueue, msg);
    }
}
