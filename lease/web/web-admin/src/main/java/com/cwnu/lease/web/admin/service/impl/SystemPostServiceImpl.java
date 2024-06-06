package com.cwnu.lease.web.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cwnu.lease.model.entity.SystemPost;
import com.cwnu.lease.web.admin.service.SystemPostService;
import com.cwnu.lease.web.admin.mapper.SystemPostMapper;
import org.springframework.stereotype.Service;

/**
* @author Jisam
* @description 针对表【system_post(岗位信息表)】的数据库操作Service实现
* @createDate 2024-06-04 15:48:00
*/
@Service
public class SystemPostServiceImpl extends ServiceImpl<SystemPostMapper, SystemPost>
    implements SystemPostService{

}




