package com.cwnu.lease.web.admin.service;

import com.cwnu.lease.model.entity.FeeKey;
import com.cwnu.lease.web.admin.vo.fee.FeeKeyVo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author Jisam
* @description 针对表【fee_key(杂项费用名称表)】的数据库操作Service
* @createDate 2024-06-04 15:48:00
*/
public interface FeeKeyService extends IService<FeeKey> {

    List<FeeKeyVo> feeInfoList();
}
