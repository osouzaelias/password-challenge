package tech.elegal.challenge.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig
{
    @Bean
    public Docket api()
    {
        return new Docket( DocumentationType.SWAGGER_2 )
                .select()
                .apis( RequestHandlerSelectors.basePackage( "tech.elegal.challenge.application" ) )
                .paths( PathSelectors.any() )
                .build()
                .apiInfo( apiInfo() );
    }

    private ApiInfo apiInfo()
    {
        return new ApiInfoBuilder()
                .title( "Password Challenge" )
                .description( "Aplicação que expõe uma api web para valida se uma senha é válida." )
                .version( "0.0.1" )
                .contact( new Contact( "Elias Souza",
                                       "https://www.linkedin.com/in/elias-souza-7572a224/",
                                       "osouzaelias@gmail.com" ) )
                .build();
    }
}