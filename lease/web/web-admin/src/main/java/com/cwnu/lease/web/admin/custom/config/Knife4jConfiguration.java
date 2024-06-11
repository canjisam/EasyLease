package com.cwnu.lease.web.admin.custom.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
 * Knife4j配置类，用于配置Swagger的OpenAPI文档。
 * 通过此类，可以定义不同的API分组，以便更好地组织和管理API文档。
 * @author jisam
 */
@Configuration
public class Knife4jConfiguration {

    /**
     * 配置自定义的OpenAPI信息。
     * @return OpenAPI实例，包含API的标题、版本和描述。
     * 此方法用于定义基本的OpenAPI信息，为整个后台管理系统提供API文档的元数据。
     */
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI().info(
                new Info()
                        .title("后台管理系统API")
                        .version("1.0")
                        .description("后台管理系统API"));
    }

    /**
     * 配置“系统信息管理”分组的API。
     * @return GroupedOpenApi实例，定义了属于“系统信息管理”分组的API路径。
     * 此方法用于将与系统信息管理相关的API路径分组，方便用户在文档中快速定位和查看。
     */
    @Bean
    public GroupedOpenApi systemAPI() {
        return GroupedOpenApi.builder().group("系统信息管理").
                pathsToMatch(
                        "/admin/system/**"
                ).
                build();
    }

    /**
     * 配置“后台登录管理”分组的API。
     * @return GroupedOpenApi实例，定义了属于“后台登录管理”分组的API路径。
     * 此方法用于将与后台登录相关的API路径分组，方便用户在文档中快速定位和查看登录相关功能。
     */
    @Bean
    public GroupedOpenApi loginAPI() {
        return GroupedOpenApi.builder().group("后台登录管理").
                pathsToMatch(
                        "/admin/login/**",
                        "/admin/info"
                ).
                build();
    }

    /**
     * 配置“公寓信息管理”分组的API。
     * @return GroupedOpenApi实例，定义了属于“公寓信息管理”分组的API路径。
     * 此方法用于将与公寓信息管理相关的API路径分组，包括公寓、房间、标签、设施、费用等信息的管理。
     */
    @Bean
    public GroupedOpenApi apartmentAPI() {
        return GroupedOpenApi.builder().group("公寓信息管理").
                pathsToMatch(
                        "/admin/apartment/**",
                        "/admin/room/**",
                        "/admin/label/**",
                        "/admin/facility/**",
                        "/admin/fee/**",
                        "/admin/attr/**",
                        "/admin/payment/**",
                        "/admin/region/**",
                        "/admin/term/**",
                        "/admin/file/**"
                ).build();
    }

    /**
     * 配置“租赁信息管理”分组的API。
     * @return GroupedOpenApi实例，定义了属于“租赁信息管理”分组的API路径。
     * 此方法用于将与租赁信息相关的API路径分组，包括预约和协议的管理。
     */
    @Bean
    public GroupedOpenApi leaseAPI() {
        return GroupedOpenApi.builder().group("租赁信息管理").
                pathsToMatch(
                        "/admin/appointment/**",
                        "/admin/agreement/**"
                ).build();
    }

    /**
     * 配置“平台用户管理”分组的API。
     * @return GroupedOpenApi实例，定义了属于“平台用户管理”分组的API路径。
     * 此方法用于将与平台用户相关的API路径分组，方便用户在文档中快速定位和查看用户管理功能。
     */
    @Bean
    public GroupedOpenApi userAPI() {
        return GroupedOpenApi.builder().group("平台用户管理").
                pathsToMatch(
                        "/admin/user/**"
                ).build();
    }
}
