package com.cwnu.lease.web.app.service.impl;

import com.aliyun.dysmsapi20170525.Client;
import com.aliyun.dysmsapi20170525.models.*;
import com.cwnu.lease.web.app.service.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SmsServiceImpl implements SmsService {

    @Value("${aliyun.sms.access-key-id}")
    private String accessKeyId;

    @Value("${aliyun.sms.access-key-secret}")
    private String accessKeySecret;

    @Value("${aliyun.sms.endpoint}")
    private String endpoint;

    /**
     * 发送短信验证码到指定手机号。
     *
     * 本方法通过调用阿里云短信服务API，发送预定义模板中的验证码到指定手机号。
     * 需要提前在阿里云控制台配置好短信服务，并创建相应的模板。
     *
     * @param phone 手机号码，验证码将发送到这个号码。
     * @param code 验证码内容，将动态插入到短信模板中发送。
     * @throws RuntimeException 如果初始化客户端或发送短信过程中发生异常，则抛出此异常。
     */
    @Override
    public void sendCode(String phone, String code) {
        // 初始化阿里云短信服务的配置，包括访问密钥和终端节点。
        com.aliyun.teaopenapi.models.Config config = new com.aliyun.teaopenapi.models.Config()
                .setAccessKeyId(accessKeyId)
                .setAccessKeySecret(accessKeySecret)
                .setEndpoint(endpoint);

        Client client = null;
        try {
            // 创建阿里云短信服务的客户端。
            client = new Client(config);
        } catch (Exception e) {
            // 如果在创建客户端过程中发生异常，抛出RuntimeException。
            throw new RuntimeException(e);
        }

        // 创建发送短信的请求，设置手机号、签名和模板代码。
        // 签名和模板代码需要在阿里云控制台提前申请和配置。
        com.aliyun.dysmsapi20170525.models.SendSmsRequest request = new com.aliyun.dysmsapi20170525.models.SendSmsRequest()
                .setPhoneNumbers(phone)
                .setSignName("阿里云短信测试")
                .setTemplateCode("SMS_154950909")
                .setTemplateParam("{\"code\":\"" + code + "\"}");

        try {
            // 使用客户端发送短信。
            client.sendSms(request);
        } catch (Exception e) {
            // 如果发送短信过程中发生异常，抛出RuntimeException。
            throw new RuntimeException(e);
        }
    }

}
