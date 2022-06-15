package be.technifutur.programmation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EntityScan(basePackages = {"be.technifutur.sharedclass.programmation.models.entities"})
public class ProgrammationApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProgrammationApplication.class, args);
	}

}
