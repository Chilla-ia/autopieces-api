package com.autopieces.autopieces.configuration;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("com.autopieces.autopieces")).paths(PathSelectors.any())
                .build().apiInfo(getApiInfo());
    }


    private ApiInfo getApiInfo() {
        return new ApiInfo("API REST AUTOPIECES",
                "Voici un microservice permettant l'accès aux données concernant les articles de pieces détachées automobiles, ainsi qu'aux différents comptes clients et aux contrats",
                "MVP", "TERMS OF SERVICE URL",
                new Contact("Manon Touchard", "https://www.epsi.fr/", "manon.touchard@epsi.fr"), "LICENSE",
                "LICENSE URL", Collections.emptyList());
    }

}