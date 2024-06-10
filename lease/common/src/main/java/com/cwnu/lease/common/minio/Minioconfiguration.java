package com.cwnu.lease.common.minio;

import io.minio.MinioClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//报错解决方法的注解方法一
@EnableConfigurationProperties(MinioProperties.class)
//方法二:
//@ConfigurationPropertiesScan（"com.cwnu.lease.common.minio"）
public class MinioConfiguration {

    //用刚映射好的参数
    @Autowired
    private MinioProperties properties;


    @Bean
    public MinioClient minioClient() {
        return  MinioClient.builder().endpoint(properties.getEndpoint()).credentials(properties.getAccessKey(), properties.getSecretKey()).build();
    }
}
