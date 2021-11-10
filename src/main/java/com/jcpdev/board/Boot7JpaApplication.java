package com.jcpdev.board;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Boot7JpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(Boot7JpaApplication.class, args);
	}

}
