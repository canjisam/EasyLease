package com.cwnu.lease.web.app.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cwnu.lease.model.entity.GraphInfo;
import com.cwnu.lease.web.app.service.GraphInfoService;
import com.cwnu.lease.web.app.mapper.GraphInfoMapper;
import org.springframework.stereotype.Service;

/**
* @author Jisam
* @description 针对表【graph_info(图片信息表)】的数据库操作Service实现
* @createDate 2024-06-04 15:48:00
*/
@Service
public class GraphInfoServiceImpl extends ServiceImpl<GraphInfoMapper, GraphInfo>
    implements GraphInfoService{

}




