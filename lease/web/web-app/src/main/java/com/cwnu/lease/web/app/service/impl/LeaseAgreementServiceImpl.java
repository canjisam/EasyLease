package com.cwnu.lease.web.app.service.impl;

import com.cwnu.lease.model.entity.LeaseAgreement;
import com.cwnu.lease.web.app.mapper.LeaseAgreementMapper;
import com.cwnu.lease.web.app.service.LeaseAgreementService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cwnu.lease.web.app.vo.agreement.AgreementItemVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Jisam
 * @description 针对表【lease_agreement(租约信息表)】的数据库操作Service实现
 * @createDate 2024-06-04 15:48:00
 */
@Service
public class LeaseAgreementServiceImpl extends ServiceImpl<LeaseAgreementMapper, LeaseAgreement>
        implements LeaseAgreementService {
    @Autowired
    private LeaseAgreementMapper leaseAgreementMapper;

    @Override
    public List<AgreementItemVo> listItemByPhone(String phone) {
        return leaseAgreementMapper.listItemByPhone(phone);
    }

}




