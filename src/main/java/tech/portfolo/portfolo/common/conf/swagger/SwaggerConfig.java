package tech.portfolo.portfolo.common.conf.swagger;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.*;

@RequiredArgsConstructor
@Configuration
@EnableSwagger2
@EnableWebMvc
public class SwaggerConfig {

    @Value("${app.url}")
    String CURRENT_URL;

    private ApiInfo swaggerInfo(){
        return new ApiInfoBuilder().title("KIM-KI-HYUN Portfolio REST API ver.0.0.1")
                .description(
                        "<br> SpringBoot를 이용한 REST API를 Swagger로 문서화한 포트폴리오"
                ).build();

    }

    private List<SecurityReference> defaltAuth(){
        final AuthorizationScope[] authorizationScopes = new AuthorizationScope[] {
                new AuthorizationScope("read","read all"),
                new AuthorizationScope("write","write all")
        };

        return Collections.singletonList(new SecurityReference("oauth2", authorizationScopes));
    }

    private Set<String> getConsumeContentTypes() {
        Set<String> consumes = new HashSet<>();
        consumes.add("application/json;charset=UTF-8");
        consumes.add("application/x-www-form-urlencoded");
        return consumes;
    }

    private Set<String> getProduceContentTypes() {
        Set<String> produces = new HashSet<>();
        produces.add("application/json;charset=UTF-8");
        return produces;
    }

    @Bean
    public Docket swaggerApiUser() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("01.User")
                .consumes(getConsumeContentTypes())
                .produces(getProduceContentTypes())
                .apiInfo(swaggerInfo()).select()
                .apis(RequestHandlerSelectors.basePackage("tech.portfolo.portfolo.api.user"))
                .paths(PathSelectors.any())
                .build()
                .useDefaultResponseMessages(false);
    }

    @Bean
    public Docket swaggerApiSurvey() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("02.Survey")
                .consumes(getConsumeContentTypes())
                .produces(getProduceContentTypes())
                .apiInfo(swaggerInfo()).select()
                .apis(RequestHandlerSelectors.basePackage("tech.portfolo.portfolo.api.survey"))
                .paths(PathSelectors.any())
                .build()
                .useDefaultResponseMessages(false);
    }

    @Bean
    public Docket swaggerApiChallenge() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("03.Challenge")
                .consumes(getConsumeContentTypes())
                .produces(getProduceContentTypes())
                .apiInfo(swaggerInfo()).select()
                .apis(RequestHandlerSelectors.basePackage("tech.portfolo.portfolo.api.challenge"))
                .paths(PathSelectors.any())
                .build()
                .useDefaultResponseMessages(false);
    }

    @Bean
    public Docket swaggerApiCsv() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("04.CSV")
                .consumes(getConsumeContentTypes())
                .produces(getProduceContentTypes())
                .apiInfo(swaggerInfo()).select()
                .apis(RequestHandlerSelectors.basePackage("tech.portfolo.portfolo.api.csv"))
                .paths(PathSelectors.any())
                .build()
                .useDefaultResponseMessages(false);
    }

    @Bean
    public Docket swaggerApiCommon() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("05.Common")
                .consumes(getConsumeContentTypes())
                .produces(getProduceContentTypes())
                .apiInfo(swaggerInfo()).select()
                .apis(RequestHandlerSelectors.basePackage("tech.portfolo.portfolo.api.common"))
                .paths(PathSelectors.any())
                .build()
                .useDefaultResponseMessages(false);
    }

    @Bean
    public Docket swaggerApiEquipment() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("06.Equipment")
                .consumes(getConsumeContentTypes())
                .produces(getProduceContentTypes())
                .apiInfo(swaggerInfo()).select()
                .apis(RequestHandlerSelectors.basePackage("tech.portfolo.portfolo.api.equipment"))
                .paths(PathSelectors.any())
                .build()
                .useDefaultResponseMessages(false);
    }

    @Bean
    public Docket swaggerApiTask() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("07.Task")
                .consumes(getConsumeContentTypes())
                .produces(getProduceContentTypes())
                .apiInfo(swaggerInfo()).select()
                .apis(RequestHandlerSelectors.basePackage("tech.portfolo.portfolo.api.task"))
                .paths(PathSelectors.any())
                .build()
                .useDefaultResponseMessages(false);
    }

    @Bean
    public Docket swaggerApiMeasurement() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("08.Measurement")
                .consumes(getConsumeContentTypes())
                .produces(getProduceContentTypes())
                .apiInfo(swaggerInfo()).select()
                .apis(RequestHandlerSelectors.basePackage("tech.portfolo.portfolo.api.Measurement"))
                .paths(PathSelectors.any())
                .build()
                .useDefaultResponseMessages(false);
    }
}
