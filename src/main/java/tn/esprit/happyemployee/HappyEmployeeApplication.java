package tn.esprit.happyemployee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class HappyEmployeeApplication {

	public static void main(String[] args) {
		SpringApplication.run(HappyEmployeeApplication.class, args);
	}

}
