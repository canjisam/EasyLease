package com.cwnu.lease.web.app.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cwnu.lease.model.entity.LeaseAgreement;
import com.cwnu.lease.web.app.vo.agreement.AgreementItemVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author Jisam
* @description 针对表【lease_agreement(租约信息表)】的数据库操作Mapper
* @createDate 2024-06-04 15:48:00
* @Entity com.cwnu.lease.model.entity.LeaseAgreement
*/
@Mapper
public interface LeaseAgreementMapper extends BaseMapper<LeaseAgreement> {

    List<AgreementItemVo> listItemByPhone(String phone);
}




