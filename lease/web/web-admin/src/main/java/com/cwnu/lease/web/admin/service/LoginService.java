package com.cwnu.lease.web.admin.service;

import com.cwnu.lease.web.admin.vo.login.CaptchaVo;
import com.cwnu.lease.web.admin.vo.login.LoginVo;
import com.cwnu.lease.web.admin.vo.system.user.SystemUserInfoVo;

public interface LoginService {

    CaptchaVo getCaptcha();

    String login(LoginVo loginVo);

    SystemUserInfoVo getLoginUserInfoById(Long userId);
}
