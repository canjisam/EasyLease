package com.cwnu.lease.web.app.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cwnu.lease.model.entity.FeeValue;
import com.cwnu.lease.web.app.vo.fee.FeeValueVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author Jisam
* @description 针对表【fee_value(杂项费用值表)】的数据库操作Mapper
* @createDate 2024-06-04 15:48:00
* @Entity com.cwnu.lease.model.entity.FeeValue
*/
@Mapper
public interface FeeValueMapper extends BaseMapper<FeeValue> {
    List<FeeValueVo> selectListByApartmentId(Long id);
}




