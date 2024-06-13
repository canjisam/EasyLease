package com.cwnu.lease.web.app.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cwnu.lease.model.entity.RoomInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cwnu.lease.web.app.vo.room.RoomDetailVo;
import com.cwnu.lease.web.app.vo.room.RoomItemVo;
import com.cwnu.lease.web.app.vo.room.RoomQueryVo;

/**
* @author Jisam
* @description 针对表【room_info(房间信息表)】的数据库操作Service
* @createDate 2024-06-04 15:48:00
*/
public interface RoomInfoService extends IService<RoomInfo> {
    IPage<RoomItemVo> pageItem(Page<RoomItemVo> page, RoomQueryVo queryVo);

    RoomDetailVo getDetailById(Long id);

    IPage<RoomItemVo> pageItemByApartmentId(Page<RoomItemVo> page, Long id);
}
