package com.cwnu.lease.web.app.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cwnu.lease.model.entity.RoomFacility;
import com.cwnu.lease.web.app.service.RoomFacilityService;
import com.cwnu.lease.web.app.mapper.RoomFacilityMapper;
import org.springframework.stereotype.Service;

/**
* @author Jisam
* @description 针对表【room_facility(房间&配套关联表)】的数据库操作Service实现
* @createDate 2024-06-04 15:48:00
*/
@Service
public class RoomFacilityServiceImpl extends ServiceImpl<RoomFacilityMapper, RoomFacility>
    implements RoomFacilityService{

}




