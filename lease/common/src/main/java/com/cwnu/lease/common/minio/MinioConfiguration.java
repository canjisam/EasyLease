package com.cwnu.lease.common.minio;

import io.minio.MinioClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * MinIO配置类。
 * 该类配置了MinIO客户端的bean，并基于MinIO服务端的属性进行初始化。
 * @author Jisam
 */

@Configuration
@EnableConfigurationProperties(MinioProperties.class)
@ConditionalOnProperty(name = "minio.endpoint")
public class MinioConfiguration {

    /**
     * MinIO服务端的属性对象。
     * 用于存储MinIO服务端的配置信息，如endpoint、accessKey和secretKey。
     */
    @Autowired
    private MinioProperties minioProperties;

    /**
     * 创建并配置MinIO客户端的bean。
     *
     * @return MinioClient 一个配置好的MinIO客户端实例。
     *
     * 该方法使用MinioProperties中的配置信息（endpoint、accessKey和secretKey）
     * 来构建一个MinioClient实例，用于后续的MinIO操作。
     */
    @Bean
    public MinioClient minioClient(){
        return MinioClient.builder().endpoint(minioProperties.getEndpoint()).credentials(minioProperties.getAccessKey(), minioProperties.getSecretKey()).build();
    }
}
