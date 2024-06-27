package com.cwnu.lease.web.app.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cwnu.lease.model.entity.LeaseAgreement;
import com.cwnu.lease.web.app.vo.agreement.AgreementDetailVo;
import com.cwnu.lease.web.app.vo.agreement.AgreementItemVo;

import java.util.List;

/**
* @author Jisam
* @description 针对表【lease_agreement(租约信息表)】的数据库操作Service
* @createDate 2024-06-04 15:48:00
*/
public interface LeaseAgreementService extends IService<LeaseAgreement> {
    List<AgreementItemVo> listItemByPhone(String phone);

    AgreementDetailVo getDetailById(Long id);
}
