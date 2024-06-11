package com.cwnu.lease.web.admin.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cwnu.lease.model.entity.SystemUser;
import com.cwnu.lease.web.admin.vo.system.user.SystemUserItemVo;
import com.cwnu.lease.web.admin.vo.system.user.SystemUserQueryVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Mapper;

/**
* @author Jisam
* @description 针对表【system_user(员工信息表)】的数据库操作Mapper
* @createDate 2024-06-04 15:48:00
* @Entity com.cwnu.lease.model.SystemUser
*/
@Mapper
public interface SystemUserMapper extends BaseMapper<SystemUser> {

    /**
     * 分页查询系统用户信息。
     *
     * 通过分页参数和查询条件，获取系统用户的分页数据。此方法用于支持前端页面的分页查询，
     * 提供了灵活的查询条件，以便根据不同的需求获取系统用户的数据。
     *
     * @param page 分页参数，包含当前页码和每页条数等信息。
     * @param queryVo 查询条件对象，封装了所有的查询条件。
     * @return 返回分页结果，其中包含了查询到的系统用户信息。
     */
    IPage<SystemUserItemVo> pageSystemUser(Page<SystemUser> page, SystemUserQueryVo queryVo);

    /**
     * 根据用户名查询单个系统用户信息。
     *
     * 通过用户名作为唯一标识，查询并返回对应的系统用户信息。此方法主要用于用户登录验证
     * 和其他需要根据用户名获取用户详细信息的场景。
     *
     * @param username 用户名，作为查询条件。
     * @return 返回匹配用户名的系统用户信息。如果没有找到匹配的用户，返回null。
     */
    SystemUser selectOneByUsername(String username);
}




