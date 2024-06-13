package com.cwnu.lease.web.app.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cwnu.lease.model.entity.LabelInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author Jisam
* @description 针对表【label_info(标签信息表)】的数据库操作Mapper
* @createDate 2024-06-04 15:48:00
* @Entity com.cwnu.lease.model.entity.LabelInfo
*/
@Mapper
public interface LabelInfoMapper extends BaseMapper<LabelInfo> {
    List<LabelInfo> selectListByRoomId(Long id);
}




