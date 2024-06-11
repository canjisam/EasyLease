package com.cwnu.lease.web.app.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cwnu.lease.model.entity.FacilityInfo;
import org.apache.ibatis.annotations.Mapper;

/**
* @author Jisam
* @description 针对表【facility_info(配套信息表)】的数据库操作Mapper
* @createDate 2024-06-04 15:48:00
* @Entity com.cwnu.lease.model.entity.FacilityInfo
*/
@Mapper
public interface FacilityInfoMapper extends BaseMapper<FacilityInfo> {

}




