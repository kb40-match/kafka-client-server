package com.matching.kb40.chatting.kafkaserver.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig  {
	@Bean
	public Docket api() {
            return new Docket(DocumentationType.SWAGGER_2)
	            .apiInfo(apiInfo())
	            .select()
	            .apis(RequestHandlerSelectors.basePackage("com.matching.kb40.chatting.kafkaserver.controller"))
	            .paths(PathSelectors.any())
	            .build();
	}
	 
	private ApiInfo apiInfo() {
	    return new ApiInfoBuilder()
	            .title("KB40기 연애조작단의 연애와 결혼의 고리")
	            .description("KB40기 연애조작단의 '연결고리' Kafka 서버 REST API 입니다. ")
	            .build();
	 
	}
}