package com.cwnu.lease.common.mybatisplus;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author jisam xqs
 * MybatisPlus配置类，用于配置MybatisPlus的相关组件。
 * 通过@MapperScan注解指定扫描的Mapper接口包路径。
 */
@Configuration
@MapperScan(value = "com.cwnu.lease.web.*.mapper")
public class MybatisPlusConfiguration {

    /**
     * 创建并配置MybatisPlus拦截器。
     * 该拦截器用于添加MybatisPlus的内置拦截器，例如分页拦截器。
     *
     * @return 配置好的MybatisPlusInterceptor实例
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        // 创建MybatisPlusInterceptor实例
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();

        // 添加分页拦截器，并指定数据库类型为MySQL
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));

        return interceptor;
    }

}
