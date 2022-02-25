package com.example.workflow.steps;

import com.example.workflow.receiver.Receiver;
import com.example.workflow.sender.Sender;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class CheckResults implements JavaDelegate {

    @Autowired
    private Receiver receiver;


    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {

        boolean success = false;
        long timeout = Duration.of(2, ChronoUnit.MINUTES).toMillis();;

        System.out.println("In CheckResults");

        while (!success && timeout > 0) {
            System.out.println(timeout);
            long start = System.currentTimeMillis();
            String s = receiver.receive();

            final Pattern pattern = Pattern.compile("<RATE_TRANSMISSION_ID>(.+?)</RATE_TRANSMISSION_ID>", Pattern.DOTALL);
            final Matcher matcher = pattern.matcher(s);
            if (matcher.find()) {
                //if we find our message then finish loop !
                success = true;
            }

            long finish = System.currentTimeMillis();
            timeout = timeout - (finish - start);
        }


    }
}
