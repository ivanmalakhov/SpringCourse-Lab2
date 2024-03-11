package ru.learn.springtask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
public class SpringTaskApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringTaskApplication.class,args);
		Worker worker = context.getBean("worker", Worker.class);
		worker.make();

	}

}
