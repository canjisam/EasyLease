package com.cwnu.lease.web.admin.custom.config;

import com.cwnu.lease.web.admin.custom.converter.StringToBaseEnumConverterFactory;
import com.cwnu.lease.web.admin.custom.interceptor.AuthenticationInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 配置WebMvc的自定义设置。
 * 通过实现WebMvcConfigurer接口，可以定制Spring MVC的行为，而不必继承WebMvcConfigurerAdapter。
 * @author Administrator
 */
@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {


    @Autowired
    private StringToBaseEnumConverterFactory stringToBaseEnumConverterFactory;

    @Autowired
    private AuthenticationInterceptor authenticationInterceptor;

    /**
     * 注册转换器工厂以支持将字符串转换为基类枚举。
     * 此方法覆盖了Spring Boot默认的转换器注册行为，专门用于处理字符串到枚举的转换。
     * 通过这种方式，我们可以确保所有继承自BaseEnum的枚举类型都能从字符串正确反序列化。
     *
     * @param registry FormatterRegistry，用于注册转换器工厂。
     */
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverterFactory(this.stringToBaseEnumConverterFactory);
    }

    /**
     * 注册拦截器以实现权限验证。
     * 此方法添加了一个认证拦截器，用于拦截所有以"/admin/"开头的URL请求，以确保请求者具有相应的访问权限。
     * 特别地，它排除了"/admin/login/**"路径，以允许未认证的用户访问登录页面。
     *
     * @param registry InterceptorRegistry，用于注册拦截器。
     */
//    暂时关闭认证拦截器方便调试
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(this.authenticationInterceptor)
//                .addPathPatterns("/admin/**")
//                .excludePathPatterns("/admin/login/**");
//    }

}