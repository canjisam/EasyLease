package com.cwnu.lease.common.minio;


import lombok.Data;
import lombok.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;


@Data
@ConfigurationProperties(prefix = "minio")
public class MinioProperties {
//minio的四个参数的映射
    private String endpoint;

    private String accessKey;

    private String secretKey;

    private String bucketName;
}
