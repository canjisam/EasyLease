package com.cwnu.lease.web.app.controller.agreement;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.cwnu.lease.common.login.LoginUserHolder;
import com.cwnu.lease.common.result.Result;
import com.cwnu.lease.model.entity.LeaseAgreement;
import com.cwnu.lease.model.entity.UserInfo;
import com.cwnu.lease.model.enums.LeaseStatus;
import com.cwnu.lease.web.app.service.LeaseAgreementService;
import com.cwnu.lease.web.app.service.UserInfoService;
import com.cwnu.lease.web.app.vo.agreement.AgreementDetailVo;
import com.cwnu.lease.web.app.vo.agreement.AgreementItemVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/app/agreement")
@Tag(name = "租约信息")
public class LeaseAgreementController {

    @Autowired
    private LeaseAgreementService service;

    @Autowired
    public UserInfoService userInfoService;



    @Operation(summary = "获取个人租约基本信息列表")
    @GetMapping("listItem")
    public Result<List<AgreementItemVo>> listItem() {
        String id = String.valueOf(LoginUserHolder.get().getUserId());
        UserInfo userInfo = userInfoService.getById(id);
        String phone = userInfo.getPhone();
        List<AgreementItemVo> list = service.listItemByPhone(phone);
        return Result.ok(list);
    }
    @Operation(summary = "根据id获取租约详细信息")
    @GetMapping("getDetailById")
    public Result<AgreementDetailVo> getDetailById(@RequestParam Long id) {
        return service.getDetailById(id);
    }

    @Operation(summary = "根据id更新租约状态", description = "用于确认租约和提前退租")
    @PostMapping("updateStatusById")
    public Result updateStatusById(@RequestParam Long id, @RequestParam String leaseStatus) {
        LambdaUpdateWrapper<LeaseAgreement> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(LeaseAgreement::getId, id);
        updateWrapper.set(LeaseAgreement::getStatus, leaseStatus);
        service.update(updateWrapper);
        return Result.ok();
    }

    @Operation(summary = "保存租约", description = "用于续约")
    @PostMapping("save")
    public Result save1(@RequestBody LeaseAgreement leaseAgreement) {
        service.save(leaseAgreement);
        return Result.ok();
    }

    @Operation(summary = "更新租约", description = "用于续约")
    @PostMapping("Update")
    public Result Update1(@RequestBody LeaseAgreement leaseAgreement) {
        service.updateById(leaseAgreement);
        return Result.ok();
    }
}
