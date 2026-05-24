package com.ajay.Introduction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IntroductionApplication implements CommandLineRunner {
	@Autowired
	PaymentService p1;

	@Autowired
	PaymentService p2;
	public static void main(String[] args) {
		SpringApplication.run(IntroductionApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(p1.hashCode());
		System.out.println(p2.hashCode());
		p1.pay();
	}
}
