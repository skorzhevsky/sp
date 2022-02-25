package com.example.mqvaadin.sender;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;


@Component
//@EnableJms
@NoArgsConstructor
@AllArgsConstructor
public class Sender implements ISender {

    @Autowired
    private ApplicationContext context;


    @Value("${qnameCommand}")
    private String qName;

    public void send(String msg) {

        System.out.println("Sending " + msg);

        // Create the JMS Template object to control connections and sessions.
        JmsTemplate jmsTemplate = context.getBean(JmsTemplate.class);

        // The default SimpleMessageConverter class will be called and turn a String
        // into a JMS TextMessage
        jmsTemplate.convertAndSend(qName, msg);

    }
}
