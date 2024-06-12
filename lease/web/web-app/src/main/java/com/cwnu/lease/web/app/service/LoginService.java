package com.cwnu.lease.web.app.service;

import com.cwnu.lease.web.app.vo.user.LoginVo;
import com.cwnu.lease.web.app.vo.user.UserInfoVo;
import org.apache.ibatis.annotations.Mapper;

public interface LoginService {
    void getCode(String phone);

    String login(LoginVo loginVo);

    UserInfoVo getLoginUserById(Long userId);
}
