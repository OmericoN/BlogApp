package io.github.omericon.blogapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class BlogappApplication {

	public static void main(String[] args) {

		ApplicationContext context =  SpringApplication.run(BlogappApplication.class, args);

	}
}
