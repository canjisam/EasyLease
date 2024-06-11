package com.cwnu.lease.web.app.custom.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Knife4j配置类，用于配置Swagger的OpenAPI文档。
 * 该类定义了如何构建OpenAPI实例以及分组API的配置。
 *
 * @author jisam
 */
@Configuration
public class Knife4jConfiguration {

    /**
     * 配置自定义的OpenAPI信息。
     *
     * @return OpenAPI实例，包含了API的元信息，如标题、版本和描述。
     * 该方法用于构建Swagger文档的基本信息。
     */
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("APP接口")
                        .version("1.0")
                        .description("用户端APP接口"));
    }

    /**
     * 配置“登录信息”分组的API。
     *
     * @return GroupedOpenApi实例，定义了属于“登录信息”分组的API路径。
     * 该方法用于将特定路径的API归入“登录信息”分组，在Swagger文档中进行分组展示。
     */
    @Bean
    public GroupedOpenApi loginAPI() {
        return GroupedOpenApi.builder().group("登录信息")
                .pathsToMatch(
                        "/app/login/**"
                        , "/app/info"
                )
                .build();
    }

    /**
     * 配置“个人信息”分组的API。
     *
     * @return GroupedOpenApi实例，定义了属于“个人信息”分组的API路径。
     * 该方法用于将特定路径的API归入“个人信息”分组，在Swagger文档中进行分组展示。
     */
    @Bean
    public GroupedOpenApi personAPI() {
        return GroupedOpenApi.builder()
                .group("个人信息")
                .pathsToMatch(
                        "/app/history/**",
                        "/app/appointment/**",
                        "/app/agreement/**"
                )
                .build();
    }

    /**
     * 配置“找房信息”分组的API。
     *
     * @return GroupedOpenApi实例，定义了属于“找房信息”分组的API路径。
     * 该方法用于将特定路径的API归入“找房信息”分组，在Swagger文档中进行分组展示。
     */
    @Bean
    public GroupedOpenApi lookForRoomAPI() {
        return GroupedOpenApi.builder().group("找房信息")
                .pathsToMatch(
                        "/app/apartment/**",
                        "/app/room/**",
                        "/app/payment/**",
                        "/app/region/**",
                        "/app/term/**"
                )
                .build();
    }
}

