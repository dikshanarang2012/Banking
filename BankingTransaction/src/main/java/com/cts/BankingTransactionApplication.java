package com.cts;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
@EnableJpaAuditing
@EnableEurekaClient
public class BankingTransactionApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankingTransactionApplication.class, args);
	}
	
	@Bean
	public Docket swaggerConfiguration() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/*"))
				.apis(RequestHandlerSelectors.basePackage("com.cts"))
				.build()
				.apiInfo(apiDeatils());
	}
	
	private ApiInfo apiDeatils() {
		return new ApiInfo(
				"Transaction Control API",
				"Transation Done By User",
				"1.0",
				"Everyone Can Use",
				new springfox.documentation.service.Contact("Abhuday Pandey", "www.cognizant.com", "pandey26@gmail.com"),
				"API License",
				"https://cognizant.com",
				Collections.emptyList()
				);
	}

}
