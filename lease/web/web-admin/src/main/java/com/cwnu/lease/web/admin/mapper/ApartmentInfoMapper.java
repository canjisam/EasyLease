package com.cwnu.lease.web.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cwnu.lease.model.entity.ApartmentInfo;
import org.apache.ibatis.annotations.Mapper;

/**
* @author Jisam
* @description 针对表【apartment_info(公寓信息表)】的数据库操作Mapper
* @createDate 2024-06-04 15:48:00
* @Entity com.cwnu.lease.model.ApartmentInfo
*/
@Mapper
public interface ApartmentInfoMapper extends BaseMapper<ApartmentInfo> {

    IPage<ApartmentItemVo> pageItem(Page<ApartmentItemVo> page, ApartmentQueryVo queryVo);
}






