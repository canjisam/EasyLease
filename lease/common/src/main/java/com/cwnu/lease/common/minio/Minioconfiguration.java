package com.cwnu.lease.common.minio;

import io.minio.MinioClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * MinIO配置类。
 * 该类配置了MinIO客户端的bean，并基于MinIO服务端的属性进行初始化。
 * @author Administrator
 */
@Configuration
//报错解决方法的注解方法一
@EnableConfigurationProperties(MinioProperties.class)
//方法二:
//@ConfigurationPropertiesScan（"com.cwnu.lease.common.minio"）
public class Minioconfiguration {

    //用刚映射好的参数
    @Autowired
    private MinioProperties properties;


    @Bean
    public MinioClient minioClient() {
        return  MinioClient.builder().endpoint(properties.getEndpoint()).credentials(properties.getAccessKey(), properties.getSecretKey()).build();
    }
}
