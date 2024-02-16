package org.jpa.ExpenseTracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class ExpenseTrackerApplication {

	public static void main(String[] args) {
		ApplicationContext ac = SpringApplication.run(ExpenseTrackerApplication.class, args);
		ETService et = ac.getBean(ETService.class);

//		int id = et.register("sri", "sri@mail.com", "123");
//		System.out.println(id);
//		et.displayAll();

		int res = et.login("sri@mail.com", "123");
		System.out.println(res);

	}

}
