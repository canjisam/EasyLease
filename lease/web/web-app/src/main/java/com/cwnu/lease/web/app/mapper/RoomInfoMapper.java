package com.cwnu.lease.web.app.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cwnu.lease.model.entity.RoomInfo;
import com.cwnu.lease.web.app.vo.room.RoomItemVo;
import com.cwnu.lease.web.app.vo.room.RoomQueryVo;
import org.apache.ibatis.annotations.Mapper;

import java.math.BigDecimal;

/**
* @author Jisam
* @description 针对表【room_info(房间信息表)】的数据库操作Mapper
* @createDate 2024-06-04 15:48:00
* @Entity com.cwnu.lease.model.entity.RoomInfo
*/
@Mapper
public interface RoomInfoMapper extends BaseMapper<RoomInfo> {

    IPage<RoomItemVo> pageItem(Page<RoomItemVo> page, RoomQueryVo queryVo);

    BigDecimal selectMinRentByApartmentId(Long apartmentId);

    IPage<RoomItemVo> pageItemByApartmentId(Page<RoomItemVo> page, Long id);
}