package com.cwnu.lease.web.admin.service;

import com.cwnu.lease.model.entity.LeaseAgreement;
import com.cwnu.lease.web.admin.vo.agreement.AgreementQueryVo;
import com.cwnu.lease.web.admin.vo.agreement.AgreementVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author Jisam
* @description 针对表【lease_agreement(租约信息表)】的数据库操作Service
* @createDate 2024-06-04 15:48:00
*/
public interface LeaseAgreementService extends IService<LeaseAgreement> {

    IPage<AgreementVo> pageAgreement(IPage<AgreementVo> page, AgreementQueryVo queryVo);

    AgreementVo getAgreementById(Long id);
}
