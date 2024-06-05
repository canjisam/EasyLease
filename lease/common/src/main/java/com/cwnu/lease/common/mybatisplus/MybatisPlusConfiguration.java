package com.cwnu.lease.common.mybatisplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.cwnu.lease.web.*.mapper")
public class MybatisPlusConfiguration {

}