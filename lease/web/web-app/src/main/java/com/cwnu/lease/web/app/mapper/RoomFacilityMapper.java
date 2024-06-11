package com.cwnu.lease.web.app.mapper;

import com.cwnu.lease.model.entity.RoomFacility;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author Jisam
* @description 针对表【room_facility(房间&配套关联表)】的数据库操作Mapper
* @createDate 2024-06-04 15:48:00
* @Entity com.cwnu.lease.model.entity.RoomFacility
*/
@Mapper
public interface RoomFacilityMapper extends BaseMapper<RoomFacility> {

}




