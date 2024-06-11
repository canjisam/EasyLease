package com.cwnu.lease.web.app.controller.history;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cwnu.lease.common.login.LoginUserHolder;
import com.cwnu.lease.common.result.Result;
import com.cwnu.lease.web.app.service.BrowsingHistoryService;
import com.cwnu.lease.web.app.vo.history.HistoryItemVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 浏览历史控制器，用于处理与浏览历史相关的请求。
 * 标签为“浏览历史管理”，@RequestMapping 注解指定了该控制器处理的请求路径为 /app/history。
 * @author Jisam
 */
@RestController
@Tag(name = "浏览历史管理")
@RequestMapping("/app/history")
public class BrowsingHistoryController {

    /**
     * 注入浏览历史服务，用于执行浏览历史相关的业务逻辑。
     */
    @Autowired
    private BrowsingHistoryService service;

    /**
     * 分页获取用户浏览历史。
     * @Operation 注解用于文档化该操作，summary 属性简要描述了操作的功能。
     * @GetMapping 注解指定了该方法处理 GET 请求，并指定了请求路径为 /pageItem。
     * @param current 当前页码，用于分页。
     * @param size 每页的项数，用于分页。
     * @return 返回一个 Result 对象，其中包含分页后的浏览历史项。Result 对象由服务层返回，表示操作的结果状态和数据。
     */
    @Operation(summary = "获取浏览历史")
    @GetMapping("pageItem")
    private Result<IPage<HistoryItemVo>> page(@RequestParam long current, @RequestParam long size) {
        Page<HistoryItemVo> page = new Page<>(current, size);
        IPage<HistoryItemVo> result = service.pageHistoryItemByUserId(page, LoginUserHolder.get().getUserId());
        return Result.ok(result);
    }
}

