package com.cwnu.lease.web.admin.service;

import com.cwnu.lease.model.entity.BrowsingHistory;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author Jisam
* @description 针对表【browsing_history(浏览历史)】的数据库操作Service
* @createDate 2024-06-04 15:48:00
*/
public interface BrowsingHistoryService extends IService<BrowsingHistory> {
    void saveHistory(Long userId, Long roomId);
}
