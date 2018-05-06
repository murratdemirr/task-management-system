package com.demir.tms;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * User: muratdemir
 * Date: 6.05.2018
 * Time: 18:59
 */

@Configuration
@EnableSwagger2
@ComponentScan("com.demir.tms")
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(Predicates.not(PathSelectors.regex("/error")))
                .build()
                .apiInfo(apiInfo());
    }


    private ApiInfo apiInfo() {
        String description = "Simple Task Management System";
        return new ApiInfoBuilder()
                .title("T.M.S.")
                .description(description)
                .termsOfServiceUrl("github")
                .license("Demir")
                .licenseUrl("")
                .version("1.0")
                .build();
    }

}
