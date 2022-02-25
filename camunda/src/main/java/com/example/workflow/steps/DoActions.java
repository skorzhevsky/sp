package com.example.workflow.steps;

import com.example.workflow.sender.Sender;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DoActions implements JavaDelegate {

    @Autowired
    private Sender sender;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {

        System.out.println("In DO ACTIONS");

        String messageD_2 ="hello"; //TODO SPECIFY MESSAGE FORMAT HERE
        String messageD_1 ="Vadim"; //TODO SPECIFY MESSAGE FORMAT HERE
        String messageD ="<RATE_TRANSMISSION_ID>666</RATE_TRANSMISSION_ID>"; //TODO SPECIFY MESSAGE FORMAT HERE



        try {
            sender.send(messageD);
            Thread.sleep(5);

        } catch (InterruptedException e) {
            log.error("Error: ", e);
        }


    }
}
