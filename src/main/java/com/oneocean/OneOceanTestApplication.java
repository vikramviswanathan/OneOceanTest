package com.oneocean;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.oneocean")
public class OneOceanTestApplication {
	
	/**
	 * @param args
	 */

	public static void main(String[] args) {
		SpringApplication.run(OneOceanTestApplication.class, args);
	}

}
