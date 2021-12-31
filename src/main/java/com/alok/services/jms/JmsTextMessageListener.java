package com.alok.services.jms;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class JmsTextMessageListener {
    @JmsListener(destination = "text.messagequeue")
    public void onMessage(String msg){
        log.info("####  {}",msg+"  ###");
    }
}
