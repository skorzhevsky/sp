package com.example.mqvaadin;

import com.example.mqvaadin.views.MainView;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
//works w/o EnableJms, don't know why
//@EnableJms
public class MqvaadinApplication {

	public static void main(String[] args) {

		SpringApplication.run(MqvaadinApplication.class, args);
		MainView view = new MainView();
		view.setVisible(true);
	}

}
