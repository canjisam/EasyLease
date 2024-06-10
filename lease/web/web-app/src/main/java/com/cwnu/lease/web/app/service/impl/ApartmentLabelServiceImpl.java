package com.cwnu.lease.web.app.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cwnu.lease.model.entity.ApartmentLabel;
import com.cwnu.lease.web.app.service.ApartmentLabelService;
import com.cwnu.lease.web.app.mapper.ApartmentLabelMapper;
import org.springframework.stereotype.Service;

/**
* @author Jisam
* @description 针对表【apartment_label(公寓标签关联表)】的数据库操作Service实现
* @createDate 2024-06-04 15:48:00
*/
@Service
public class ApartmentLabelServiceImpl extends ServiceImpl<ApartmentLabelMapper, ApartmentLabel>
    implements ApartmentLabelService{
}
