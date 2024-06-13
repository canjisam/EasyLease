package com.cwnu.lease.web.app.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cwnu.lease.model.entity.GraphInfo;
import com.cwnu.lease.model.enums.ItemType;
import com.cwnu.lease.web.app.vo.graph.GraphVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author Jisam
* @description 针对表【graph_info(图片信息表)】的数据库操作Mapper
* @createDate 2024-06-04 15:48:00
* @Entity com.cwnu.lease.model.entity.GraphInfo
*/
@Mapper
public interface GraphInfoMapper extends BaseMapper<GraphInfo> {
    List<GraphVo> selectListByItemTypeAndId(ItemType itemType, Long id);
}




