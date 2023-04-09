package com.rentalapp;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
/* SwaggerUiで表示されるタイトル */
@OpenAPIDefinition(
        info = @Info(
                title = "Rental APP",
                version = "1.0.0",
                description = "書籍レンタルサービス"))
public class RentalAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(RentalAppApplication.class, args);
    }

}
