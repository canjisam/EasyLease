package com.cwnu.lease.web.app.service.impl;

import com.cwnu.lease.model.entity.RoomInfo;
import com.cwnu.lease.web.app.mapper.RoomInfoMapper;
import com.cwnu.lease.web.app.service.BrowsingHistoryService;
import com.cwnu.lease.web.app.service.RoomInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Jisam
 * @description 针对表【room_info(房间信息表)】的数据库操作Service实现
 * @createDate 2024-06-04 15:48:00
 */
@Service
@Slf4j
public class RoomInfoServiceImpl extends ServiceImpl<RoomInfoMapper, RoomInfo>
        implements RoomInfoService {
    @Autowired
    private BrowsingHistoryService browsingHistoryService;
      browsingHistoryService.saveHistory(LoginUserContext.getLoginUser().getUserId(), id);
}




