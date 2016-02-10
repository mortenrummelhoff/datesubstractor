package dk.mhr.config;

import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.inject.Named;

import static springfox.documentation.builders.PathSelectors.regex;

/**
 * Created by Morten on 05-12-2015.
 */
@Named
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(regex("/dates/.*"))
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        ApiInfo apiInfo = new ApiInfo(
                "Date Substractor REST API",
                "<html>API for calculating total days between 2 dates<br>Author: Morten Rummelhoff</html>",
                "1.0",
                "",
                "morten@mhr.dk",
                "Free Licence",
                "http://www.gnu.org/philosophy/free-sw.html"
        );
        return apiInfo;
    }
}
