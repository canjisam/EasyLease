package com.cwnu.lease.web.admin.service.impl;

import com.cwnu.lease.common.exception.LeaseException;
import com.cwnu.lease.common.result.ResultCodeEnum;
import com.cwnu.lease.common.utils.JwtUtil;
import com.cwnu.lease.model.entity.SystemUser;
import com.cwnu.lease.web.admin.mapper.SystemUserMapper;
import com.cwnu.lease.web.admin.service.LoginService;
import com.cwnu.lease.web.admin.vo.login.CaptchaVo;
import com.cwnu.lease.web.admin.vo.login.LoginVo;
import com.cwnu.lease.web.admin.vo.system.user.SystemUserInfoVo;
import com.wf.captcha.SpecCaptcha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

import static com.cwnu.lease.model.enums.BaseStatus.DISABLE;


@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private SystemUserMapper systemUserMapper;


    @Override
    public CaptchaVo getCaptcha() {
        SpecCaptcha specCaptcha = new SpecCaptcha(130, 48, 5);
        String code = specCaptcha.text().toLowerCase();
        String key = "admin:login" + UUID.randomUUID();
        redisTemplate.opsForValue().set(key, code, 60, TimeUnit.SECONDS);
        return new CaptchaVo(specCaptcha.toBase64(), key);
    }

    @Override
    public String login(LoginVo loginVo) {
        if (loginVo.getCaptchaCode() == null) {
            throw new LeaseException(ResultCodeEnum.ADMIN_CAPTCHA_CODE_NOT_FOUND);
        }
        String code = redisTemplate.opsForValue().get(loginVo.getCaptchaKey());
        if (code == null) {
            throw new LeaseException(ResultCodeEnum.ADMIN_CAPTCHA_CODE_EXPIRED);
        }

        if (!code.equals(loginVo.getCaptchaCode().toLowerCase())) {
            throw new LeaseException(ResultCodeEnum.ADMIN_CAPTCHA_CODE_ERROR);
        }
/**
 *         LambdaQueryWrapper<SystemUser> queryWrapper = new LambdaQueryWrapper<>();
 *         queryWrapper.eq(SystemUser::getUsername, loginVo.getUsername());
 *         SystemUser systemUser = systemUserMapper.selectOne(queryWrapper);
 * */

        SystemUser systemUser = systemUserMapper.selectOneByUsername(loginVo.getUsername());

        System.out.println(systemUser);
        if (systemUser == null){
            throw new LeaseException(ResultCodeEnum.ADMIN_ACCOUNT_NOT_EXIST_ERROR);
        }
        if (systemUser.getStatus() == DISABLE){
            throw new LeaseException(ResultCodeEnum.ADMIN_ACCOUNT_DISABLED_ERROR);
        }
        ;

        if  (!systemUser.getPassword().equals(DigestUtils.md5DigestAsHex(loginVo.getPassword().getBytes()))){
            throw new LeaseException(ResultCodeEnum.ADMIN_ACCOUNT_ERROR);
        }

        return JwtUtil.createToken(systemUser.getId(),systemUser.getUsername());
    }

    @Override
    public SystemUserInfoVo getLoginUserInfoById(Long userId) {
        SystemUser systemUser = systemUserMapper.selectById(userId);
        SystemUserInfoVo systemUserInfoVo = new SystemUserInfoVo();
        systemUserInfoVo.setName(systemUser.getName());
        systemUserInfoVo.setAvatarUrl(systemUser.getAvatarUrl());
        return systemUserInfoVo;

    }
}
