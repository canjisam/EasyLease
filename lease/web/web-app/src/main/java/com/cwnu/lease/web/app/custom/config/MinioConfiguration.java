package com.cwnu.lease.web.app.custom.config;

import com.cwnu.lease.common.minio.MinioProperties;
import io.minio.MinioClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Minio配置类。
 * 该类用于配置Minio客户端，只有在属性文件中指定了"minio.endpoint"时才会生效。
 * 它利用MinioProperties类中的属性来创建MinioClient实例。
 * @author Jisam
 */
@Configuration
@EnableConfigurationProperties(MinioProperties.class)
@ConditionalOnProperty(name = "minio.endpoint")
public class MinioConfiguration {

    /**
     * Minio配置属性类的实例。
     * 用于存储Minio服务器的endpoint、access key和secret key等配置信息。
     */
    @Autowired
    private MinioProperties properties;

    /**
     * 创建Minio客户端 bean。
     * 该方法使用MinioProperties中的配置信息（endpoint、accessKey和secretKey）来构建MinioClient实例。
     * MinioClient是用于与Minio服务器通信的客户端对象。
     *
     * @return MinioClient实例，用于与Minio服务器交互。
     */
    @Bean
    public MinioClient minioClient() {
        return MinioClient.builder().endpoint(properties.getEndpoint()).credentials(properties.getAccessKey(), properties.getSecretKey()).build();
    }
}
