package com.isaachome.springdocker;

import com.isaachome.springdocker.model.Post;
import com.isaachome.springdocker.repository.PostRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringDockerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDockerApplication.class, args);
	}
	@Bean
	CommandLineRunner commandLineRunner(PostRepo repository) {
		return args -> repository.save(new Post("Hello World!","My first blog post!"));
	}

}
