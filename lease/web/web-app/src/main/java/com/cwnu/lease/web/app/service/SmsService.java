package com.cwnu.lease.web.app.service;

import org.apache.ibatis.annotations.Mapper;

public interface SmsService {
    void sendCode(String phone, String code) ;
}
