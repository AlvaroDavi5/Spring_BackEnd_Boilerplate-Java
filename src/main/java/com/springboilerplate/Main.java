package com.springboilerplate;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.kafka.annotation.EnableKafka;

import com.springboilerplate.app.KafkaApp;
import com.springboilerplate.app.services.FlightManagerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;

@SpringBootApplication
@EnableKafka
@EnableJpaRepositories("com.springboilerplate.*")
@ComponentScan("com.springboilerplate.*")
@EntityScan("com.springboilerplate.*")
public class Main implements ApplicationRunner {
	@Autowired
	KafkaApp kafkaApp;
	@Autowired
	FlightManagerService flightManagerService;

	public static void main(String[] args) {
		try {
			if (args.length < 3)
				throw new Error("Invalid number of arguments (expected 3 arguments)", null);
			SpringApplication.run(Main.class, args);
		} catch (Error error) {
			System.out.println("Main.Error → " + error.getMessage());
			error.printStackTrace();
			System.exit(0);
		} catch (Exception exception) {
			System.out.println("Main.Exception → " + exception.getMessage());
			exception.printStackTrace();
			System.exit(1);
		}
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		this.kafkaApp.start();
		this.flightManagerService.start(args.getSourceArgs());
	}
}
