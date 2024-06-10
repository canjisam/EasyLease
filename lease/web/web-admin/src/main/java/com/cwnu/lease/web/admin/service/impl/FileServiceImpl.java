package com.cwnu.lease.web.admin.service.impl;

import com.cwnu.lease.common.minio.MinioProperties;
import com.cwnu.lease.web.admin.service.FileService;
import io.minio.*;
import io.minio.errors.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.resource.ResourceUrlProvider;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Service
public class FileServiceImpl implements FileService {

    @Autowired
    private MinioClient minioClient;

    @Autowired
    private MinioProperties properties;
    @Autowired
    private ResourceUrlProvider mvcResourceUrlProvider;

    @Override
    public String upload(MultipartFile file) throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {

            /*判断桶是否存在*/
            boolean bucketExists = minioClient.bucketExists(BucketExistsArgs.builder().bucket(properties.getBucketName()).build());

            if (!bucketExists){

                /*创建桶*/
                minioClient.makeBucket(MakeBucketArgs.builder().bucket(properties.getBucketName()).build());
                /*设置桶的访问权限*/
                minioClient.setBucketPolicy(SetBucketPolicyArgs.builder().bucket(properties.getBucketName()).config(createBucketPolicyConfig(properties.getBucketName())).build());
            }
            /*上传文件  */
            /*对象的完整名称*/
            String filename = new SimpleDateFormat("yyyyMMdd").format(new Date()) +
                    /*斜杠前面的内容当作一级路径处理*/
                    "/" + UUID.randomUUID() + "-" + file.getOriginalFilename();
            minioClient.putObject(PutObjectArgs.builder().bucket(properties.getBucketName()).object(filename).stream(file.getInputStream(), file.getSize(),-1).contentType(file.getContentType()).build());


        /*返回这个对象在minio的url*/
        /*  minio的服务的地址/桶的名称/对象完整名称  */
            String url = String.join("/",properties.getEndpoint(),properties.getBucketName(),filename);
            return url;
        }



    private String createBucketPolicyConfig(String bucketName) {

        return """
                  {
                    "Statement" : [ {
                      "Action" : "s3:GetObject",
                      "Effect" : "Allow",
                      "Principal" : "*",
                      "Resource" : "arn:aws:s3:::%s/*"
                    } ],
                    "Version" : "2012-10-17"
                  }
                  """.formatted(bucketName);
    }
}
