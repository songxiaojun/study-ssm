package com.hfuu.ssm.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
@EnableWebMvc
public class SwaggerConfig{
	@Bean  
    public Docket createRestApi() {  
        return new Docket(DocumentationType.SWAGGER_2)  
                .apiInfo(apiInfo())  
                .select()  
                .paths(PathSelectors.any())  
                .build();  
    }  
  
    private ApiInfo apiInfo() {  
        return new ApiInfoBuilder()  
                .title("测试APIs")  
                .termsOfServiceUrl("")  
                .contact("")  
                .version("1.1")  
                .build();  
    }  
}