package com.jolmos.ticarum.sport.competitions;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class TicarumSportCompetitionsApplication {

	public static void main(String[] args) {
		SpringApplication.run(TicarumSportCompetitionsApplication.class, args);
	}

}
