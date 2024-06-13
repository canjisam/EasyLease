package com.cwnu.lease.web.app.service.impl;

import com.cwnu.lease.model.entity.ApartmentInfo;
import com.cwnu.lease.model.entity.FacilityInfo;
import com.cwnu.lease.model.entity.LabelInfo;
import com.cwnu.lease.model.enums.ItemType;
import com.cwnu.lease.web.app.mapper.*;
import com.cwnu.lease.web.app.service.ApartmentInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cwnu.lease.web.app.vo.apartment.ApartmentDetailVo;
import com.cwnu.lease.web.app.vo.apartment.ApartmentItemVo;
import com.cwnu.lease.web.app.vo.graph.GraphVo;
import org.apache.ibatis.annotations.Mapper;
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
    @Override
    public ApartmentItemVo selectApartmentItemVoById(Long apartmentId) {
        return null;
    }

//    @Override
//    public ApartmentDetailVo getDetailById(Long id) {
//        return null;
//    }

    @Autowired
    private ApartmentInfoMapper apartmentInfoMapper;
    @Autowired
    private GraphInfoMapper graphInfoMapper;
    @Autowired
    private FacilityInfoMapper facilityInfoMapper;
    @Autowired
    private LabelInfoMapper labelInfoMapper;
    @Autowired
    private RoomInfoMapper roomInfoMapper;

    @Override
    public ApartmentDetailVo getDetailById(Long apartmentid) {
        //1.查询公寓信息
        ApartmentInfo apartmentInfo = apartmentInfoMapper.selectById(apartmentid);
        //2.查询图片信息
        List<GraphVo> graphVoList = graphInfoMapper.selectListByItemTypeAndId(ItemType.APARTMENT, apartmentid);
        //3.查询标签信息
        List<LabelInfo> labelInfoList = labelInfoMapper.selectListByApartmentId(apartmentid);
        //4.查询配套信息
        List<FacilityInfo> facilityInfoList = facilityInfoMapper.selectListByApartmentId(apartmentid);
        //5.查询最小租金
        BigDecimal minRent = roomInfoMapper.selectMinRentByApartmentId(apartmentid);

        ApartmentDetailVo apartmentDetailVo = new ApartmentDetailVo();

        BeanUtils.copyProperties(apartmentInfo, apartmentDetailVo);
        apartmentDetailVo.setGraphVoList(graphVoList);
        apartmentDetailVo.setLabelInfoList(labelInfoList);
        apartmentDetailVo.setFacilityInfoList(facilityInfoList);
        apartmentDetailVo.setMinRent(minRent);
        return apartmentDetailVo;
    }
}




