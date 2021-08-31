package io.codebyexample.springbootjpa;

import io.codebyexample.springbootjpa.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

/**
 * @author huypva
 * */
@SpringBootApplication
public class SpringBootJpaApplication {

	@Autowired
	UserRepository userRepository;

	@EventListener(ApplicationReadyEvent.class)
	protected void readyProcess() {
		userRepository.findAll().forEach(System.out::println);
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpaApplication.class, args);

	}

}
