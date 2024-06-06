package com.cwnu.lease.web.admin.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cwnu.lease.model.entity.SystemPost;
import com.cwnu.lease.model.entity.SystemUser;
import com.cwnu.lease.web.admin.mapper.SystemPostMapper;
import com.cwnu.lease.web.admin.mapper.SystemUserMapper;
import com.cwnu.lease.web.admin.service.SystemPostService;
import com.cwnu.lease.web.admin.service.SystemUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cwnu.lease.web.admin.vo.system.user.SystemUserItemVo;
import com.cwnu.lease.web.admin.vo.system.user.SystemUserQueryVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Jisam
 * @description 针对表【system_user(员工信息表)】的数据库操作Service实现
 * @createDate 2024-06-04 15:48:00
 */
@Service
public class SystemUserServiceImpl extends ServiceImpl<SystemUserMapper, SystemUser>
        implements SystemUserService {

    /**
     * 自动注入SystemUserMapper，用于数据库操作相关功能。
     */
    @Autowired
    private SystemUserMapper sysUserMapper;

    /**
     * 自动注入SystemPostMapper，用于职位信息的数据库操作相关功能。
     */
    @Autowired
    private SystemPostMapper sysPostMapper;

    /**
     * 分页查询系统用户信息。
     *
     * @param page    分页对象，包含当前页码和每页条数等信息。
     * @param queryVo 查询条件对象，封装了用户查询时的条件。
     * @return 返回分页结果，包含当前页的系统用户信息。
     */
    @Override
    public IPage<SystemUserItemVo> pageSystemUser(Page<SystemUser> page, SystemUserQueryVo queryVo) {
        // 调用SystemUserMapper的pageSystemUser方法进行分页查询
        return sysUserMapper.pageSystemUser(page, queryVo);
    }


    @Override
    public SystemUserItemVo getSystemUserById(Long id) {

        SystemUser systemUser = sysUserMapper.selectById(id);

        SystemPost sysPost = sysPostMapper.selectById(systemUser.getPostId());

        SystemUserItemVo systemUserItemVo = new SystemUserItemVo();

        BeanUtils.copyProperties(systemUser, systemUserItemVo);
        systemUserItemVo.setPostName(sysPost.getName());

        return systemUserItemVo;
    }
}




