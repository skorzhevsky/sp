package com.example.workflow.receiver;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
//@EnableJms
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Receiver {

    @Autowired
    private ApplicationContext context;

    @Value("${qnameData}")
    private String qName;
//    static final String qName = "DEV.QUEUE.1"; // A queue from the default MQ Developer container config

    public String receive() {

        // Create the JMS Template object to control connections and sessions.
        JmsTemplate jmsTemplate = context.getBean(JmsTemplate.class);

        return (String) jmsTemplate.receiveAndConvert(qName);

    }





}
