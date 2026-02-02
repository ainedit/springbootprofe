package es.cursojava.springbootprofe.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI apiInfo() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de Alumnos")
                        .description("Ejemplo: CRUD con documentación Swagger/OpenAPI")
                        .version("1.0.0"));
    }
}
