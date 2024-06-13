package com.cwnu.lease.web.app.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cwnu.lease.model.entity.PaymentType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author Jisam
* @description 针对表【payment_type(支付方式表)】的数据库操作Mapper
* @createDate 2024-06-04 15:48:00
* @Entity com.cwnu.lease.model.entity.PaymentType
*/
@Mapper
public interface PaymentTypeMapper extends BaseMapper<PaymentType> {
    List<PaymentType> selectListByRoomId(Long id);
}




