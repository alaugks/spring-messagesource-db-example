package dev.alaugks.spring.messagesource.db;

@SuppressWarnings("java:S125")
@org.springframework.boot.autoconfigure.SpringBootApplication(
		scanBasePackages = {"dev.alaugks.spring.messagesource.*"}
)
public class SpringBootApplication {

	public static void main(String[] args) {
		org.springframework.boot.SpringApplication.run(SpringBootApplication.class, args);
	}

}
