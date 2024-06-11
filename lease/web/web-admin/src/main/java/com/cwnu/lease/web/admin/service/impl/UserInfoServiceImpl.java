package com.cwnu.lease.web.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cwnu.lease.model.entity.UserInfo;
import com.cwnu.lease.web.admin.service.UserInfoService;
import com.cwnu.lease.web.admin.mapper.UserInfoMapper;
import org.springframework.stereotype.Service;

/**
* @author Jisam
* @description 针对表【user_info(用户信息表)】的数据库操作Service实现
* @createDate 2024-06-04 15:48:00
*/
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo>
    implements UserInfoService{

}




