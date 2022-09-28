package com.itstep.itlibrary.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiDocConfig {

    protected Info apiInfo() {
        return  new Info().title("It books API")
                .description("Api for tutorial project")
                .version("0.0.1")
                .contact(new Contact().name("Taras Halynskyi").email("off.bk@gmail.com"));
    }

    @Bean
    public OpenAPI openApiConfig() {
        return new OpenAPI()
                .info(apiInfo());
    }

}
