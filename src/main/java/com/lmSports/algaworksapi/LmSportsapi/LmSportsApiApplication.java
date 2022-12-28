package com.lmSports.algaworksapi.LmSportsapi;

import com.lmSports.algaworksapi.LmSportsapi.Config.Property.LmSportsApiProperty;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(LmSportsApiProperty.class)
public class LmSportsApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(LmSportsApiApplication.class, args);
	}

}
