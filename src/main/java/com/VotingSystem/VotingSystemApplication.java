package com.VotingSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.HiddenHttpMethodFilter;

@SpringBootApplication
public class VotingSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(VotingSystemApplication.class, args);
	}
	
	 @Bean
	    public HiddenHttpMethodFilter hiddenHttpMethodFilter() {
	        return new HiddenHttpMethodFilter();
	    }
}


