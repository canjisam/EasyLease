package com.cwnu.lease.web.admin.mapper;

import com.cwnu.lease.model.entity.LeaseAgreement;
import com.cwnu.lease.web.admin.vo.agreement.AgreementQueryVo;
import com.cwnu.lease.web.admin.vo.agreement.AgreementVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
* @author Jisam
* @description 针对表【lease_agreement(租约信息表)】的数据库操作Mapper
* @createDate 2024-06-04 15:48:00
* @Entity com.cwnu.lease.model.LeaseAgreement
*/
public interface LeaseAgreementMapper extends BaseMapper<LeaseAgreement> {

    IPage<AgreementVo> pageAgreement(IPage<AgreementVo> page, AgreementQueryVo queryVo);
}




