package com.cwnu.lease.web.app.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cwnu.lease.model.entity.AttrKey;
import com.cwnu.lease.web.app.service.AttrKeyService;
import com.cwnu.lease.web.app.mapper.AttrKeyMapper;
import org.springframework.stereotype.Service;

/**
* @author Jisam
* @description 针对表【attr_key(房间基本属性表)】的数据库操作Service实现
* @createDate 2024-06-04 15:48:00
*/
@Service
public class AttrKeyServiceImpl extends ServiceImpl<AttrKeyMapper, AttrKey>
    implements AttrKeyService{

}




