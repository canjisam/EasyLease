package com.cwnu.lease.web.app.controller.custom.config;

import com.cwnu.lease.web.app.controller.custom.interceptor.AuthenticationInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 配置WebMvc的自定义设置。
 * 通过实现WebMvcConfigurer接口，可以定制Spring MVC的行为，而不必继承WebMvcConfigurerAdapter。
 * @author Jisam
 */
@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {


    @Autowired
    private AuthenticationInterceptor authenticationInterceptor;

    /**
     * 注册拦截器以实现权限验证。
     * 此方法添加了一个认证拦截器，用于拦截所有以"/app/"开头的URL请求，以确保请求者具有相应的访问权限。
     * 特别地，它排除了"/app/login/**"路径，以允许未认证的用户访问登录页面。
     *
     * @param registry InterceptorRegistry，用于注册拦截器。
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(this.authenticationInterceptor)
                .addPathPatterns("/app/**")
                .excludePathPatterns("/app/login/**");
    }
}