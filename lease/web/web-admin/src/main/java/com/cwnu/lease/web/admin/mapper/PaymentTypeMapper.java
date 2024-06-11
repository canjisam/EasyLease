package com.cwnu.lease.web.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cwnu.lease.model.entity.PaymentType;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Jisam
 * @description 针对表【payment_type(支付方式表)】的数据库操作Mapper
 * @createDate 2024-06-04 15:48:00
 * @Entity com.cwnu.lease.model.PaymentType
 */
@Mapper
public interface PaymentTypeMapper extends BaseMapper<PaymentType> {

}




