package com.springboilerplate;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import jakarta.annotation.PreDestroy;

@SpringBootApplication
@ComponentScan("com.springboilerplate.*")
@EntityScan("com.springboilerplate.core.infra.database.models")
@EnableJpaRepositories("com.springboilerplate.core.infra.database.repositories")
@EnableKafka
public class BoilerplateApp implements ApplicationRunner {
	private final Environment environment;
	private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(BoilerplateApp.class);

	public BoilerplateApp(Environment environment) {
		this.environment = environment;
	}

	public static void main(String[] args) {
		try {
			SpringApplication.run(BoilerplateApp.class, args);
		} catch (Error error) {
			System.out.println("BoilerplateApp.Error → " + error.getMessage());
			error.printStackTrace();
			System.exit(0);
		} catch (Exception exception) {
			System.out.println("BoilerplateApp.Exception → " + exception.getMessage());
			exception.printStackTrace();
			System.exit(1);
		}
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		// Application startup logic
		logger.info("Starting application");

		// Register shutdown hooks
		Runtime.getRuntime().addShutdownHook(new Thread(() -> {
			logger.warn("Application is shutting down...");
			closeApplication();
		}));

		String appPort = environment.getProperty("application.appPort", "3000");
		String appEnvironment = environment.getProperty("application.environment", "dev");

		logger.info("Application started successfully on port:" + appPort + " and environment:" + appEnvironment);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			@SuppressWarnings("null")
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
						.allowedOrigins("*")
						.allowedHeaders("*")
						.allowedMethods("GET", "POST", "PUT", "DELETE", "PATCH", "OPTIONS");
			}
		};
	}

	@PreDestroy
	public void closeApplication() {
		logger.info("Cleaning up before shutdown...");
		// Close resources, connections, etc.
	}
}

// Better Comments:
// normal
// // hidden
// * document
// ? topic
// ! alert
// todo
/**
 * @brief
 * @param param
 * @return
 **/

// Comment Anchors:
// TODO - ...
// FIXME - ...
// ANCHOR - ...
// LINK - ...
// NOTE - ...
// REVIEW - ...
// SECTION - ...
// STUB - ...
