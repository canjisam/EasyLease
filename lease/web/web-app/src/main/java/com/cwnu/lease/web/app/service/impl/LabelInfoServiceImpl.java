package com.cwnu.lease.web.app.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cwnu.lease.model.entity.LabelInfo;
import com.cwnu.lease.web.app.service.LabelInfoService;
import com.cwnu.lease.web.app.mapper.LabelInfoMapper;
import org.springframework.stereotype.Service;

/**
* @author Jisam
* @description 针对表【label_info(标签信息表)】的数据库操作Service实现
* @createDate 2024-06-04 15:48:00
*/
@Service
public class LabelInfoServiceImpl extends ServiceImpl<LabelInfoMapper, LabelInfo>
    implements LabelInfoService{

}




