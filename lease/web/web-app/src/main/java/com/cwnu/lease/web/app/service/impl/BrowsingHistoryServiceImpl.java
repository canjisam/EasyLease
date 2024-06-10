package com.cwnu.lease.web.app.service.impl;

import com.cwnu.lease.model.entity.BrowsingHistory;
import com.cwnu.lease.web.app.mapper.BrowsingHistoryMapper;
import com.cwnu.lease.web.app.service.BrowsingHistoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author Jisam
 * @description 针对表【browsing_history(浏览历史)】的数据库操作Service实现
 * @createDate 2024-06-04 15:48:00
 */
@Service
public class BrowsingHistoryServiceImpl extends ServiceImpl<BrowsingHistoryMapper, BrowsingHistory>
        implements BrowsingHistoryService {
}