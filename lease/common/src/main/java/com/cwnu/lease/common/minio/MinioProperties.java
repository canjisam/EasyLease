package com.cwnu.lease.common.minio;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * MinIO服务配置属性类。
 * 使用@ConfigurationProperties注解将此类绑定到配置文件中以minio为前缀的属性。
 * 通过这种方式，可以从配置文件中自动加载MinIO服务的相关配置，方便集成MinIO存储服务。
 * @author Jisam
 */
@ConfigurationProperties(prefix = "minio")
@Data
public class MinioProperties {

    /**
     * MinIO服务的Endpoint，即MinIO服务器的地址。
     * 此地址用于建立与MinIO服务器的连接，配置时应确保地址的正确性和可达性。
     */
    private String endpoint;

    /**
     * MinIO服务的访问密钥，用于身份验证。
     * 此密钥与secretKey配对使用，确保对MinIO服务的访问安全。
     */
    private String accessKey;

    /**
     * MinIO服务的密钥密钥，用于身份验证。
     * 此密钥与accessKey配对使用，确保对MinIO服务的访问安全。
     */
    private String secretKey;

    /**
     * MinIO服务的存储桶名称。
     * 存储桶是MinIO中对象（文件）的容器，此配置用于指定应用将使用的存储桶名称。
     */
    private String bucketName;
}
