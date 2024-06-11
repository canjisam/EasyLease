package com.cwnu.lease.web.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cwnu.lease.model.entity.LeaseTerm;
import com.cwnu.lease.web.admin.service.LeaseTermService;
import com.cwnu.lease.web.admin.mapper.LeaseTermMapper;
import org.springframework.stereotype.Service;

/**
* @author Jisam
* @description 针对表【lease_term(租期)】的数据库操作Service实现
* @createDate 2024-06-04 15:48:00
*/
@Service
public class LeaseTermServiceImpl extends ServiceImpl<LeaseTermMapper, LeaseTerm>
    implements LeaseTermService{

}




