package com.cwnu.lease.web.app.service.impl;

import com.cwnu.lease.model.entity.ApartmentInfo;
import com.cwnu.lease.web.app.mapper.ApartmentInfoMapper;
import com.cwnu.lease.web.app.service.ApartmentInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cwnu.lease.web.app.vo.apartment.ApartmentItemVo;
import org.springframework.stereotype.Service;

/**
 * @author Jisam
 * @description 针对表【apartment_info(公寓信息表)】的数据库操作Service实现
 * @createDate 2024-06-04 15:48:00
 */
@Service
public class ApartmentInfoServiceImpl extends ServiceImpl<ApartmentInfoMapper, ApartmentInfo>
        implements ApartmentInfoService {
    @Override
    public ApartmentItemVo selectApartmentItemVoById(Long apartmentId) {
        return null;
    }
}




