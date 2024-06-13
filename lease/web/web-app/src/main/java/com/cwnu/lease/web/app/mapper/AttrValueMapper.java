package com.cwnu.lease.web.app.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cwnu.lease.model.entity.AttrValue;
import com.cwnu.lease.web.app.vo.attr.AttrValueVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author Jisam
* @description 针对表【attr_value(房间基本属性值表)】的数据库操作Mapper
* @createDate 2024-06-04 15:48:00
* @Entity com.cwnu.lease.model.entity.AttrValue
*/
@Mapper
public interface AttrValueMapper extends BaseMapper<AttrValue> {
    List<AttrValueVo> selectListByRoomId(Long id);
}




