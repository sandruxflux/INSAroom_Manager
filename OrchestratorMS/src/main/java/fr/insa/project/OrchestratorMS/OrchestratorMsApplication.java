package fr.insa.project.OrchestratorMS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

import fr.insa.project.OrchestratorMS.model.Room;
import jakarta.annotation.PostConstruct;

@SpringBootApplication
@EnableScheduling

public class OrchestratorMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrchestratorMsApplication.class, args);
	}
	
	@Bean
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}
	
}
