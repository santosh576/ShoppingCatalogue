package com.ShoppingCatalogue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableEurekaClient
@EnableSwagger2
public class ShoppingCatalogApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoppingCatalogApplication.class, args);
	}

	@Bean
	@LoadBalanced
	public WebClient.Builder getWebclient()
	{
		return  WebClient.builder();
		
	}
}
