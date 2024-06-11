package com.cwnu.lease.web.app.mapper;

import com.cwnu.lease.model.entity.RoomAttrValue;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author Jisam
* @description 针对表【room_attr_value(房间&基本属性值关联表)】的数据库操作Mapper
* @createDate 2024-06-04 15:48:00
* @Entity com.cwnu.lease.model.entity.RoomAttrValue
*/
@Mapper
public interface RoomAttrValueMapper extends BaseMapper<RoomAttrValue> {

}




