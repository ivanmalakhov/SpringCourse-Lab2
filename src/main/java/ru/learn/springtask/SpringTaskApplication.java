package ru.learn.springtask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class SpringTaskApplication {
/*

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private LoginRepository loginRepository;
*/

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringTaskApplication.class,args);
		Worker worker = context.getBean("worker", Worker.class);
		worker.make();

	}

}
