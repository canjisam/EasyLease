package com.cwnu.lease.web.app.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cwnu.lease.model.entity.CityInfo;
import com.cwnu.lease.web.app.service.CityInfoService;
import com.cwnu.lease.web.app.mapper.CityInfoMapper;
import org.springframework.stereotype.Service;

/**
* @author Jisam
* @description 针对表【city_info】的数据库操作Service实现
* @createDate 2024-06-04 15:48:00
*/
@Service
public class CityInfoServiceImpl extends ServiceImpl<CityInfoMapper, CityInfo>
    implements CityInfoService{

}




