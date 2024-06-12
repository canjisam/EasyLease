package com.cwnu.lease.web.admin.controller.user;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cwnu.lease.common.result.Result;
import com.cwnu.lease.model.entity.UserInfo;
import com.cwnu.lease.model.enums.BaseStatus;
import com.cwnu.lease.web.admin.service.UserInfoService;
import com.cwnu.lease.web.admin.vo.user.UserInfoQueryVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
/**
 * 用户信息控制器，用于管理员对用户信息进行管理。
 * 包含用户信息的分页查询和根据用户ID更新用户状态等功能。
 * @author Jisam
 */
@Tag(name = "用户信息管理")
@RestController
@RequestMapping("/admin/user")
public class UserInfoController {

    /**
     * 注入用户信息服务层，用于执行用户信息的相关操作。
     */
    @Autowired
    private UserInfoService service;

    /**
     * 分页查询用户信息。
     *
     * @param current 当前页码。
     * @param size 每页显示的数量。
     * @param queryVo 查询条件对象，包含电话和状态等条件。
     * @return 分页查询结果，包含用户信息列表。
     */
    @Operation(summary = "分页查询用户信息")
    @GetMapping("page")
    public Result<IPage<UserInfo>> pageUserInfo(@RequestParam long current, @RequestParam long size, UserInfoQueryVo queryVo) {
        IPage<UserInfo> page = new Page<>(current, size);
        LambdaQueryWrapper<UserInfo> queryWrapper = new LambdaQueryWrapper<>();
        // 根据查询条件对象构建查询条件，支持电话和状态的查询。
        queryWrapper.like(queryVo.getPhone() != null, UserInfo::getPhone, queryVo.getPhone());
        queryWrapper.eq(queryVo.getStatus() != null, UserInfo::getStatus, queryVo.getStatus());
        IPage<UserInfo> list = service.page(page, queryWrapper);
        return Result.ok(list);
    }

    /**
     * 根据用户ID更新用户状态。
     *
     * @param id 用户ID。
     * @param status 新的状态。
     * @return 更新结果，成功返回OK。
     */
    @Operation(summary = "根据用户id更新账号状态")
    @PostMapping("updateStatusById")
    public Result updateStatusById(@RequestParam Long id, @RequestParam BaseStatus status) {
        LambdaUpdateWrapper<UserInfo> updateWrapper = new LambdaUpdateWrapper<>();
        // 根据ID设置更新条件。
        updateWrapper.eq(UserInfo::getId, id);
        // 设置新的状态。
        updateWrapper.set(UserInfo::getStatus, status);
        service.update(updateWrapper);
        return Result.ok();
    }
}
