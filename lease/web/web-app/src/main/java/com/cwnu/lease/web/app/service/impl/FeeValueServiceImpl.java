package com.cwnu.lease.web.app.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cwnu.lease.model.entity.FeeValue;
import com.cwnu.lease.web.app.service.FeeValueService;
import com.cwnu.lease.web.app.mapper.FeeValueMapper;
import org.springframework.stereotype.Service;

/**
* @author Jisam
* @description 针对表【fee_value(杂项费用值表)】的数据库操作Service实现
* @createDate 2024-06-04 15:48:00
*/
@Service
public class FeeValueServiceImpl extends ServiceImpl<FeeValueMapper, FeeValue>
    implements FeeValueService{

}




