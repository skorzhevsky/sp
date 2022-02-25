package com.example.mqvaadin.views;

import com.example.mqvaadin.Events;
//import com.example.mqvaadin.receiver.Receiver;
import com.example.mqvaadin.sender.Sender;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.annotation.security.PermitAll;

@Route
@PermitAll
public class MainView extends VerticalLayout {

    @Autowired
    private Sender sender;

//    @Autowired
//    private Receiver receiver;

    public MainView() {


        String userName = "Anonymous";

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            userName = auth.getName();
        }

        VerticalLayout todosList = new VerticalLayout();

//        TextField textUserName = new TextField();
//        textUserName.setValue(userName);
//        Button sendButton = new Button("Send");
//
//        TextField messageToReceived = new TextField();
//        Button receiveButton = new Button("Receive");



        Button a0 = new Button(String.valueOf(Events.START));
        Button a1 = new Button(String.valueOf(Events.DO_ACTIONS));
        Button a2 = new Button(String.valueOf(Events.PREPARE_TEST_VARIABLES));
        Button a3 = new Button(String.valueOf(Events.CHECK_RESULT));
        Button a4 = new Button(String.valueOf(Events.OK));

        String finalUserName = userName;
        a0.addClickListener(event -> {
            sender.send(Events.START + "," + finalUserName);
        });

        a1.addClickListener(event -> {
            sender.send(String.valueOf(Events.DO_ACTIONS) + "," + finalUserName);
        });

        a2.addClickListener(event -> {
            sender.send(String.valueOf(Events.PREPARE_TEST_VARIABLES) + "," + finalUserName);
        });

        a3.addClickListener(event -> {
            sender.send(String.valueOf(Events.CHECK_RESULT) + "," + finalUserName);
        });

        a4.addClickListener(event -> {
            sender.send(String.valueOf(Events.OK) + "," + finalUserName);
        });

        Button next = new Button("next page");
        next.addClickListener(event -> {
            next.getUI().ifPresent(ui -> ui.navigate(
                    AboutView.class));
//                    new RouteParameters("userID", "123")));
        });




//        sendButton.addClickListener(event -> {
//            System.out.println("Sending..." + messageToSend.getValue());
//            sender.send(messageToSend.getValue());
//            messageToSend.clear();
//        });
//
//        receiveButton.addClickListener(event -> {
//            String rec = receiver.receive();
//            System.out.println("Received... " + rec);
//            messageToReceived.setValue(rec);
//        });



        add(
                new H1("Send messages to Camunda, dear " + userName),
                todosList,
                new HorizontalLayout(
//                        messageToSend,
//                        sendButton,
//                        messageToReceived,
//                        receiveButton,
//                        textUserName,
                        a0,
                        a1,
                        a2,
                        a3,
                        a4,
                        next
                )
        );
    }
}