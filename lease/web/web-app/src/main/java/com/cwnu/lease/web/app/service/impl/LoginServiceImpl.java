package com.cwnu.lease.web.app.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.cwnu.lease.common.constant.RedisConstant;
import com.cwnu.lease.common.exception.LeaseException;
import com.cwnu.lease.common.result.ResultCodeEnum;
import com.cwnu.lease.common.utils.CodeUtil;
import com.cwnu.lease.common.utils.JwtUtil;
import com.cwnu.lease.model.entity.UserInfo;
import com.cwnu.lease.model.enums.BaseStatus;
import com.cwnu.lease.web.app.mapper.UserInfoMapper;
import com.cwnu.lease.web.app.service.LoginService;
import com.cwnu.lease.web.app.service.SmsService;
import com.cwnu.lease.web.app.vo.user.LoginVo;
import com.cwnu.lease.web.app.vo.user.UserInfoVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private SmsService smsService;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private UserInfoMapper userInfoMapper;

    /**
     * 根据手机号获取验证码。
     * 该方法用于生成并发送验证码到指定的手机号，同时通过Redis存储验证码以限制发送频率。
     *
     * @param phone 用户的手机号，用于发送验证码。
     * @throws LeaseException 如果发送验证码过于频繁，则抛出异常。
     */
    @Override
    public void getCode(String phone) {
        // 生成6位随机验证码
        String code = CodeUtil.getRandomCode(6);
        // 构建Redis中验证码键的名称，以手机号为后缀
        String key = RedisConstant.APP_LOGIN_PREFIX + phone;

        // 检查Redis中是否存在该手机号对应的验证码键
        Boolean hasKey = redisTemplate.hasKey(key);
        if (hasKey) {
            // 如果键存在，获取该键的剩余过期时间（以秒为单位）
            Long ttl = redisTemplate.getExpire(key, TimeUnit.SECONDS);
            // 如果当前时间与上次发送验证码的时间间隔小于设定的最小发送间隔，则抛出异常
//            if (RedisConstant.APP_LOGIN_CODE_RESEND_TIME_SEC - ttl < RedisConstant.APP_LOGIN_CODE_RESEND_TIME_SEC) {
//                throw new LeaseException(ResultCodeEnum.APP_SEND_SMS_TOO_OFTEN);
//            }
        }

        // 调用短信服务发送验证码
        smsService.sendCode(phone, code);
        // 将验证码存储到Redis中，设置过期时间
        redisTemplate.opsForValue().set(key, code, RedisConstant.APP_LOGIN_CODE_TTL_SEC, TimeUnit.SECONDS);
    }

    @Override
    public UserInfoVo getUserInfoId(Long id) {
        return null;
    }

    /**
     * 用户登录方法。
     * 通过手机号和验证码进行登录验证。
     *
     * @param loginVo 登录视图对象，包含手机号和验证码信息。
     * @return 登录成功返回空字符串，目前代码实现中未使用返回值。
     * @throws LeaseException 如果手机号为空、验证码为空、验证码过期或验证码错误，则抛出租赁异常。
     */
    @Override
    public String login(LoginVo loginVo) {
        //1.判断手机号码和验证码是否为空
        if (loginVo.getPhone() == null) {
            throw new LeaseException(ResultCodeEnum.APP_LOGIN_PHONE_EMPTY);
        }

        // 验证验证码是否为空
        if (loginVo.getCode() == null) {
            throw new LeaseException(ResultCodeEnum.APP_LOGIN_CODE_EMPTY);
        }

        //2.校验验证码
        // 生成Redis中的键名，用于存储和查找验证码
        String key = RedisConstant.APP_LOGIN_PREFIX + loginVo.getPhone();
        // 从Redis中获取存储的验证码
        String code = redisTemplate.opsForValue().get(key);
        // 验证存储的验证码是否存在
        if (code == null) {
            throw new LeaseException(ResultCodeEnum.APP_LOGIN_CODE_EXPIRED);
        }

        // 验证输入的验证码与存储的验证码是否一致
        if (!code.equals(loginVo.getCode())) {
            throw new LeaseException(ResultCodeEnum.APP_LOGIN_CODE_ERROR);
        }


        //3.判断用户是否存在,不存在则注册（创建用户）
        LambdaQueryWrapper<UserInfo> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(UserInfo::getPhone, loginVo.getPhone());
        UserInfo userInfo = userInfoMapper.selectOne(queryWrapper);

        if (userInfo==null){
            //注册
            userInfo = new UserInfo();
            userInfo.setPhone(loginVo.getPhone());
            userInfo.setStatus(BaseStatus.ENABLE);
            userInfo.setNickname("用户-" + loginVo.getPhone().substring(7));
            userInfoMapper.insert(userInfo);
        }else {
            //禁用？
            if (userInfo.getStatus()==BaseStatus.DISABLE){
                throw new LeaseException(ResultCodeEnum.APP_ACCOUNT_DISABLED_ERROR);
            }
        }

        //4.判断用户是否被禁
        if (userInfo.getStatus().equals(BaseStatus.DISABLE)) {
            throw new LeaseException(ResultCodeEnum.APP_ACCOUNT_DISABLED_ERROR);
        }



        // 登录验证成功，返回空字符串
        return JwtUtil.createToken(userInfo.getId(), userInfo.getPhone());
    }

    @Override
    public UserInfoVo getLoginUserById(Long userId) {
        UserInfo userInfo = userInfoMapper.getLoginUserById(userId);
        UserInfoVo userInfoVo = new UserInfoVo();
        userInfoVo.setNickname(userInfo.getNickname());
        userInfoVo.setAvatarUrl(userInfo.getAvatarUrl());
        return userInfoVo;
    }

}
