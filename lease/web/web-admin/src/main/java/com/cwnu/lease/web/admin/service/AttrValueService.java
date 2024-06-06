package com.cwnu.lease.web.admin.service;

import com.cwnu.lease.model.entity.AttrValue;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cwnu.lease.web.admin.vo.attr.AttrKeyVo;

import java.util.List;

/**
* @author Jisam
* @description 针对表【attr_value(房间基本属性值表)】的数据库操作Service
* @createDate 2024-06-04 15:48:00
*/
public interface AttrValueService extends IService<AttrValue> {

    List<AttrKeyVo> listAttrInfo();
}
