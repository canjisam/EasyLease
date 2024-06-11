package com.cwnu.lease.web.app.service.impl;

import com.cwnu.lease.model.entity.LeaseTerm;
import com.cwnu.lease.web.app.mapper.LeaseTermMapper;
import com.cwnu.lease.web.app.service.LeaseTermService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author Jisam
 * @description 针对表【lease_term(租期)】的数据库操作Service实现
 * @createDate 2024-06-04 15:48:00
 */
@Service
public class LeaseTermServiceImpl extends ServiceImpl<LeaseTermMapper, LeaseTerm>
        implements LeaseTermService {

}




