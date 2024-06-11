package com.cwnu.lease.web.app.mapper;

import com.cwnu.lease.model.entity.RoomPaymentType;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author Jisam
* @description 针对表【room_payment_type(房间&支付方式关联表)】的数据库操作Mapper
* @createDate 2024-06-04 15:48:00
* @Entity com.cwnu.lease.model.entity.RoomPaymentType
*/
@Mapper
public interface RoomPaymentTypeMapper extends BaseMapper<RoomPaymentType> {

}




