package com.dmxiaoshen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringCloudDateServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudDateServiceApplication.class, args);
	}
}
