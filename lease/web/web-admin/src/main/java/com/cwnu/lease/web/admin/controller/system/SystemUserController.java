package com.cwnu.lease.web.admin.controller.system;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cwnu.lease.common.result.Result;
import com.cwnu.lease.model.entity.SystemUser;
import com.cwnu.lease.model.enums.BaseStatus;
import com.cwnu.lease.web.admin.service.SystemUserService;
import com.cwnu.lease.web.admin.vo.system.user.SystemUserItemVo;
import com.cwnu.lease.web.admin.vo.system.user.SystemUserQueryVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

/**
 * 后台用户信息管理控制器。
 * 该控制器负责处理与后台用户信息相关的所有HTTP请求，包括查询、创建、更新和删除等操作。
 * @author Jisam
 */
@Tag(name = "后台用户信息管理")
@RestController
@RequestMapping("/admin/system/user")
public class SystemUserController {
    /**
     * 自动注入系统用户服务层，用于执行与用户相关的业务逻辑。
     */
    @Autowired
    SystemUserService service;

    /**
     * 根据条件分页查询后台用户列表。
     * @param current 当前页码。
     * @param size 每页显示的数量。
     * @param queryVo 查询条件对象，包含各种过滤条件。
     * @return 分页查询结果，包含后台用户信息。
     */
    @Operation(summary = "根据条件分页查询后台用户列表")
    @GetMapping("page")
    public Result<IPage<SystemUserItemVo>> page(@RequestParam long current, @RequestParam long size, SystemUserQueryVo queryVo) {
        Page<SystemUser> page = new Page<>(current, size);
        IPage<SystemUserItemVo> result = service.pageSystemUser(page, queryVo);
        return Result.ok(result);
    }

    /**
     * 根据ID查询后台用户信息。
     * @param id 后台用户ID。
     * @return 查询到的后台用户信息。
     */
    @Operation(summary = "根据ID查询后台用户信息")
    @GetMapping("getById")
    public Result<SystemUserItemVo> getById(@RequestParam Long id) {
        SystemUserItemVo result = service.getSystemUserById(id);
        return Result.ok(result);
    }

    /**
     * 保存或更新后台用户信息。
     * 如果用户密码不为空，则使用MD5加密。
     * @param systemUser 后台用户信息对象，包含待保存或更新的数据。
     * @return 保存或更新结果。
     */
    @Operation(summary = "保存或更新后台用户信息")
    @PostMapping("saveOrUpdate")
    public Result saveOrUpdate(@RequestBody SystemUser systemUser) {
        if (systemUser.getPassword() != null) {
            systemUser.setPassword(DigestUtils.md5DigestAsHex(systemUser.getPassword().getBytes()));
        }
        service.saveOrUpdate(systemUser);
        return Result.ok();
    }

    /**
     * 判断后台用户名是否可用。
     * 通过查询数据库中是否有相同用户名来判断用户名是否已存在。
     * @param username 待检查的用户名。
     * @return 如果用户名不存在返回true，否则返回false。
     */
    @Operation(summary = "判断后台用户名是否可用")
    @GetMapping("isUserNameAvailable")
    public Result<Boolean> isUsernameExists(@RequestParam String username) {
        LambdaQueryWrapper<SystemUser> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SystemUser::getUsername, username);
        long count = service.count(queryWrapper);
        return Result.ok(count == 0);
    }

    /**
     * 根据ID删除后台用户信息。
     * @param id 后台用户ID。
     * @return 删除结果。
     */
    @DeleteMapping("deleteById")
    @Operation(summary = "根据ID删除后台用户信息")
    public Result removeById(@RequestParam Long id) {
        service.removeById(id);
        return Result.ok();
    }

    /**
     * 根据ID修改后台用户状态。
     * @param id 后台用户ID。
     * @param status 新的状态。
     * @return 更新结果。
     */
    @Operation(summary = "根据ID修改后台用户状态")
    @PostMapping("updateStatusByUserId")
    public Result updateStatusByUserId(@RequestParam Long id, @RequestParam BaseStatus status) {
        LambdaUpdateWrapper<SystemUser> wrapper = new LambdaUpdateWrapper<>();
        wrapper.eq(SystemUser::getId, id);
        wrapper.set(SystemUser::getStatus, status);
        service.update(wrapper);
        return Result.ok();
    }
}
