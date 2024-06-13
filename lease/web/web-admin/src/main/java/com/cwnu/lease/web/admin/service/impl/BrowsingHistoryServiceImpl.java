package com.cwnu.lease.web.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cwnu.lease.model.entity.BrowsingHistory;
import com.cwnu.lease.web.admin.mapper.BrowsingHistoryMapper;
import com.cwnu.lease.web.admin.service.BrowsingHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
* @author Jisam
* @description 针对表【browsing_history(浏览历史)】的数据库操作Service实现
* @createDate 2024-06-04 15:48:00
*/
@Service
public class BrowsingHistoryServiceImpl extends ServiceImpl<BrowsingHistoryMapper, BrowsingHistory>
    implements BrowsingHistoryService{

    @Autowired
    private BrowsingHistoryMapper browsingHistoryMapper;
    @Override
    @Async
    public void saveHistory(Long userId, Long roomId) {
        LambdaQueryWrapper<BrowsingHistory> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(BrowsingHistory::getUserId, userId);
        queryWrapper.eq(BrowsingHistory::getRoomId, roomId);
        BrowsingHistory browsingHistory = browsingHistoryMapper.selectOne(queryWrapper);

        if (browsingHistory != null) {
            browsingHistory.setBrowseTime(new Date());
            browsingHistoryMapper.updateById(browsingHistory);
        } else {
            BrowsingHistory newBrowsingHistory = new BrowsingHistory();
            newBrowsingHistory.setUserId(userId);
            newBrowsingHistory.setRoomId(roomId);
            newBrowsingHistory.setBrowseTime(new Date());
            browsingHistoryMapper.insert(newBrowsingHistory);
        }
    }
}




