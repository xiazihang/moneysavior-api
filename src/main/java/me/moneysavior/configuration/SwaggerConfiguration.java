package me.moneysavior.configuration;

import com.fasterxml.classmate.TypeResolver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static com.google.common.collect.ImmutableSortedMultiset.of;
import static com.google.common.collect.Sets.newHashSet;
import static springfox.documentation.builders.PathSelectors.any;
import static springfox.documentation.builders.RequestHandlerSelectors.basePackage;
import static springfox.documentation.spi.DocumentationType.SWAGGER_2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    @Value("${info.app.name}")
    private String name;

    @Value("${swagger.app.moneySaviorDescription}")
    private String description;

    @Value("${info.contact.email}")
    private String email;

    @Value("${info.app.base.url:https://}")
    private String protocol;

    @Bean
    public TypeResolver typeResolver() {
        return new TypeResolver();
    }

    @Bean
    public Docket createDocket() {
        return new Docket(SWAGGER_2)
                .select()
                .apis(basePackage("me.moneysavior.controller"))
                .paths(any())
                .build()
                .apiInfo(apiInfo())
                .protocols(newHashSet(protocol.split(":")[0]));
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(name, description, "", "", new Contact("", "", email), "", "", of());
    }

}
