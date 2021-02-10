package edu.fdzc.hotel.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * swagger配置
 *
 * @author yezj
 * @date 2021/2/10 18:59
 */
@EnableSwagger2
@Configuration
public class Swagger2Configuration {

    public static final String SWAGGER_SCAN_BASE_PACKAGE = "edu.fdzc.hotel.controller";

    public static final String VERSION = "1.0.0";

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(SWAGGER_SCAN_BASE_PACKAGE))
                .paths(PathSelectors.any()) // 可以根据url路径设置哪些请求加入文档，忽略哪些请求
                .build();
    }

    private ApiInfo apiInfo() {
        Contact contact = new Contact("Yifelix","https://www.yifelix.cn","1016445037@qq.com");
        return new ApiInfoBuilder()
                .title("酒店管理系统") //设置文档的标题
                .description("酒店管理系统 API 接口文档") // 设置文档的描述
                .version(VERSION)
                .termsOfServiceUrl("https://www.yifelix.cn")
                .contact(contact)       //作者
                .build();
    }
}
