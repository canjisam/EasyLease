package com.cwnu.lease.web.admin.controller.system;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cwnu.lease.common.result.Result;
import com.cwnu.lease.model.entity.SystemPost;
import com.cwnu.lease.model.enums.BaseStatus;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.cwnu.lease.web.admin.service.SystemPostService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 岗位管理控制器，负责处理与系统岗位相关的HTTP请求。
 * @author Jisam
 */
@RestController
@RequestMapping("/admin/system/post")
public class SystemPostController {

    /**
     * 注入岗位服务层，用于执行岗位相关的业务操作。
     */
    @Autowired
    private SystemPostService service;

    /**
     * 分页查询岗位信息。
     *
     * @param current 当前页码
     * @param size 每页记录数
     * @return 分页查询结果
     */
    @Operation(summary = "分页获取岗位信息")
    @GetMapping("page")
    private Result<IPage<SystemPost>> page(@RequestParam long current, @RequestParam long size) {
        Page<SystemPost> page = new Page<>(current, size);
        Page<SystemPost> result = service.page(page);
        return Result.ok(result);
    }

    /**
     * 保存或更新岗位信息。
     *
     * @param systemPost 岗位实体
     * @return 保存或更新结果
     */
    @Operation(summary = "保存或更新岗位信息")
    @PostMapping("saveOrUpdate")
    public Result saveOrUpdate(@RequestBody SystemPost systemPost) {
        service.saveOrUpdate(systemPost);
        return Result.ok();
    }

    /**
     * 根据ID删除岗位。
     *
     * @param id 岗位ID
     * @return 删除结果
     */
    @DeleteMapping("deleteById")
    @Operation(summary = "根据id删除岗位")
    public Result removeById(@RequestParam Long id) {
        service.removeById(id);
        return Result.ok();
    }

    /**
     * 根据ID查询岗位信息。
     *
     * @param id 岗位ID
     * @return 岗位信息
     */
    @GetMapping("getById")
    @Operation(summary = "根据id获取岗位信息")
    public Result<SystemPost> getById(@RequestParam Long id) {
        SystemPost systemPost = service.getById(id);
        return Result.ok(systemPost);
    }

    /**
     * 查询所有岗位列表。
     *
     * @return 岗位列表
     */
    @Operation(summary = "获取全部岗位列表")
    @GetMapping("list")
    public Result<List<SystemPost>> list() {
        List<SystemPost> list = service.list();
        return Result.ok(list);
    }

    /**
     * 根据岗位ID修改岗位状态。
     *
     * @param id 岗位ID
     * @param status 岗位状态
     * @return 修改结果
     */
    @Operation(summary = "根据岗位id修改状态")
    @PostMapping("updateStatusByPostId")
    public Result updateStatusByPostId(@RequestParam Long id, @RequestParam BaseStatus status) {
        LambdaUpdateWrapper<SystemPost> wrapper = new LambdaUpdateWrapper<>();
        wrapper.eq(SystemPost::getId, id);
        wrapper.set(SystemPost::getStatus, status);
        service.update(wrapper);
        return Result.ok();
    }
}

