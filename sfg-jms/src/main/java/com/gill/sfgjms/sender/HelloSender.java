package com.gill.sfgjms.sender;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gill.sfgjms.config.JmsConfig;
import com.gill.sfgjms.model.HelloWorldMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class HelloSender {

    private final JmsTemplate jmsTemplate;
    private final ObjectMapper objectMapper;

    @Scheduled(fixedRate = 2000)
    public void sendMessage() {
       // System.out.println("I'm Sending a message");
        HelloWorldMessage message = HelloWorldMessage
                .builder()
                .id(UUID.randomUUID())
                .message("Hello World!!")
                .build();
        jmsTemplate.convertAndSend(JmsConfig.MY_QUEUE, message);
       // System.out.println("message sent!");
    }

    @Scheduled(fixedRate = 2000)
    public void sendAndReceiveMessage() {
        //System.out.println("I'm Sending a message");
        HelloWorldMessage message = HelloWorldMessage
                .builder()
                .id(UUID.randomUUID())
                .message("Hello World!!")
                .build();
        jmsTemplate.sendAndReceive(JmsConfig.MY_SEND_RCVQUEUE, new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                Message helloMessage = null;
                try {
                    helloMessage = session.createTextMessage(objectMapper.writeValueAsString(message));
                    helloMessage.setStringProperty("_type","com.gill.sfgjms.model.HellpWorldMessage");
                    return helloMessage;
                } catch (JsonProcessingException e) {
                    throw new JMSException("boom");
                }

            }
        })
        //System.out.println("message sent!");
    }



}
