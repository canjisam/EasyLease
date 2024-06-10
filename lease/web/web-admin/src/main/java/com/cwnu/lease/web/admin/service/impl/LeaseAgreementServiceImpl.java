package com.cwnu.lease.web.admin.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cwnu.lease.model.entity.*;
import com.cwnu.lease.web.admin.mapper.*;
import com.cwnu.lease.web.admin.service.LeaseAgreementService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cwnu.lease.web.admin.vo.agreement.AgreementQueryVo;
import com.cwnu.lease.web.admin.vo.agreement.AgreementVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Autowired
    private ApartmentInfoMapper apartmentInfoMapper;

    @Autowired
    private RoomInfoMapper roomInfoMapper;

    @Autowired
    private PaymentTypeMapper paymentTypeMapper;

    @Autowired
    private LeaseTermMapper leaseTermMapper;

    @Override
    public IPage<AgreementVo> pageAgreement(IPage<AgreementVo> page, AgreementQueryVo queryVo) {
        return leaseAgreementMapper.pageAgreement(page,queryVo);
    }

    @Override
    public AgreementVo getAgreementById(Long id) {

        LeaseAgreement leaseAgreemnet = leaseAgreementMapper.selectById(id);

        ApartmentInfo apartmentInfo = apartmentInfoMapper.selectById(leaseAgreemnet.getApartmentId());

        RoomInfo roomInfo = roomInfoMapper.selectById(leaseAgreemnet.getRoomId());

        PaymentType paymentType = paymentTypeMapper.selectById(leaseAgreemnet.getPaymentTypeId());

        LeaseTerm leaseTerm = leaseTermMapper.selectById(leaseAgreemnet.getLeaseTermId());

        AgreementVo agreementVo = new AgreementVo();
        BeanUtils.copyProperties(leaseAgreemnet,agreementVo);
        agreementVo.setApartmentInfo(apartmentInfo);
        agreementVo.setRoomInfo(roomInfo);
        agreementVo.setLeaseTerm(leaseTerm);
        agreementVo.setPaymentType(paymentType);


        return null;
    }
}




