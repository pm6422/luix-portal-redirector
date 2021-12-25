package org.infinity.luix.portalredirector.config;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Date;

/**
 * Springfox Swagger configuration.
 * <p>
 * Warning! When having a lot of REST endpoints, Springfox can become a
 * performance issue. In that case, you can use a specific Spring profile for
 * this class, so that only front-end developers have access to the Swagger
 * view.
 * <p>
 * https://blog.csdn.net/qq_21948951/article/details/90443723
 */
@Configuration
@EnableSwagger2
@Slf4j
public class SwaggerConfiguration {
    private static final String GROUP_NAME = "api-group";

    @Bean
    public Docket apiDocket() {
        log.debug("Building Swagger API docket with group [{}]", GROUP_NAME);
        Docket docket = new Docket(DocumentationType.SWAGGER_2).groupName(GROUP_NAME)
                .forCodeGeneration(true);

        docket.genericModelSubstitutes(ResponseEntity.class)
                .ignoredParameterTypes(java.sql.Date.class)
                .directModelSubstitute(java.time.LocalDate.class, java.sql.Date.class)
                .directModelSubstitute(java.time.ZonedDateTime.class, Date.class)
                .directModelSubstitute(java.time.LocalDateTime.class, Date.class)
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .build();
        log.debug("Built Swagger API docket with group [{}]", GROUP_NAME);
        return docket;
    }
}
