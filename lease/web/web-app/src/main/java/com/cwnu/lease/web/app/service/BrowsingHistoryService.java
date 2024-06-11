package com.cwnu.lease.web.app.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cwnu.lease.model.entity.BrowsingHistory;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cwnu.lease.web.app.vo.history.HistoryItemVo;

/**
* @author Jisam
* @description 针对表【browsing_history(浏览历史)】的数据库操作Service
* @createDate 2024-06-04 15:48:00
*/
public interface BrowsingHistoryService extends IService<BrowsingHistory> {
    IPage<HistoryItemVo> pageHistoryItemByUserId(Page<HistoryItemVo> page, Long userId);
}
