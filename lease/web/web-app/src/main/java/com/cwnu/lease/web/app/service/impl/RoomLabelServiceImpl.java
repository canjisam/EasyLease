package com.cwnu.lease.web.app.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cwnu.lease.model.entity.RoomLabel;
import com.cwnu.lease.web.app.service.RoomLabelService;
import com.cwnu.lease.web.app.mapper.RoomLabelMapper;
import org.springframework.stereotype.Service;

/**
* @author Jisam
* @description 针对表【room_label(房间&标签关联表)】的数据库操作Service实现
* @createDate 2024-06-04 15:48:00
*/
@Service
public class RoomLabelServiceImpl extends ServiceImpl<RoomLabelMapper, RoomLabel>
    implements RoomLabelService{

}




