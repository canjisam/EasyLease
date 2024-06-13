package com.cwnu.lease.web.app.service.impl;

import com.cwnu.lease.model.entity.ApartmentInfo;
import com.cwnu.lease.model.entity.LabelInfo;
import com.cwnu.lease.model.enums.ItemType;
import com.cwnu.lease.web.app.mapper.ApartmentInfoMapper;
import com.cwnu.lease.web.app.mapper.GraphInfoMapper;
import com.cwnu.lease.web.app.mapper.LabelInfoMapper;
import com.cwnu.lease.web.app.mapper.RoomInfoMapper;
import com.cwnu.lease.web.app.service.ApartmentInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cwnu.lease.web.app.vo.apartment.ApartmentItemVo;
import com.cwnu.lease.web.app.vo.graph.GraphVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Jisam
 * @description 针对表【apartment_info(公寓信息表)】的数据库操作Service实现
 * @createDate 2024-06-04 15:48:00
 */
@Service
public class ApartmentInfoServiceImpl extends ServiceImpl<ApartmentInfoMapper, ApartmentInfo>
        implements ApartmentInfoService {

    @Autowired
    private ApartmentInfoMapper apartmentInfoMapper;

    @Autowired
    private LabelInfoMapper labelInfoMapper;

    @Autowired
    private GraphInfoMapper graphInfoMapper;

    @Autowired
    private RoomInfoMapper roomInfoMapper;
    @Override
    public ApartmentItemVo selectApartmentItemVoById(Long apartmentId) {
        ApartmentInfo apartmentInfo = apartmentInfoMapper.selectById(apartmentId);

        List<LabelInfo> labelInfoList = labelInfoMapper.selectListByRoomId(apartmentId);

        List<GraphVo> graphVoList = graphInfoMapper.selectListByItemTypeAndId(ItemType.APARTMENT, apartmentId);

        BigDecimal minRent = roomInfoMapper.selectMinRentByApartmentId(apartmentId);

        ApartmentItemVo apartmentItemVo = new ApartmentItemVo();
        BeanUtils.copyProperties(apartmentInfo, apartmentItemVo);

        apartmentItemVo.setGraphVoList(graphVoList);
        apartmentItemVo.setLabelInfoList(labelInfoList);
        apartmentItemVo.setMinRent(minRent);
        return apartmentItemVo;
    }
}





