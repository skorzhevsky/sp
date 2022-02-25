package com.example.mqvaadin.views;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route("about")
@PageTitle("Login | Vaadin CRM")
public class AboutView extends VerticalLayout {

    private final LoginForm login = new LoginForm();

    public AboutView(){
        addClassName("login-view");
        setSizeFull();
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);

        login.setAction("login");

        add(new H1("Vaadin CRM"), login);
    }

//    @Override
//    public void beforeEnter(BeforeEnterEvent beforeEnterEvent) {
//        // inform the user about an authentication error
//        if(beforeEnterEvent.getLocation()
//                .getQueryParameters()
//                .getParameters()
//                .containsKey("error")) {
//            login.setError(true);
//        }
//    }
}