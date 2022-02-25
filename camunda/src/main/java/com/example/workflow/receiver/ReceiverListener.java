package com.example.workflow.receiver;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.JmsListener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;


//Disable @Configuration to switch listener off, to use Receive button in web instead
@Configuration
public class ReceiverListener {

    @Autowired
    RuntimeService runtimeService;


    @JmsListener(destination = "${qnameCommand}")
    public void receiveMessage(final Message message) throws JMSException {
        System.out.println("...Q Message Received...");
        String messageData = null;
        if(message instanceof TextMessage) {
            TextMessage textMessage = (TextMessage)message;
            messageData = textMessage.getText();
        }
        System.out.println(messageData);

        String[] input = messageData.split(",");
        String msg = input[0];
        String bKey = input[1];
        runtimeService.createMessageCorrelation(msg)
                .processInstanceBusinessKey(bKey)
                .setVariable("businessKey", bKey)
                .correlate();

    }
}
