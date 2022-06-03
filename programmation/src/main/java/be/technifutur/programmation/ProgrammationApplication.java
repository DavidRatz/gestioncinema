package be.technifutur.programmation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ProgrammationApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProgrammationApplication.class, args);
	}

}
