package com.cwnu.lease.web.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cwnu.lease.model.entity.AttrValue;
import org.apache.ibatis.annotations.Mapper;

/**
* @author Jisam
* @description 针对表【attr_value(房间基本属性值表)】的数据库操作Mapper
* @createDate 2024-06-04 15:48:00
* @Entity com.cwnu.lease.model.AttrValue
*/
@Mapper
public interface AttrValueMapper extends BaseMapper<AttrValue> {

    List<AttrValueVo> selectListByRoomId(Long id);

}




