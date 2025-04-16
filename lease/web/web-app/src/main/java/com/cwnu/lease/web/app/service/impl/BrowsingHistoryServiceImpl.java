package com.cwnu.lease.web.app.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cwnu.lease.model.entity.BrowsingHistory;
import com.cwnu.lease.web.app.mapper.BrowsingHistoryMapper;
import com.cwnu.lease.web.app.service.BrowsingHistoryService;
import com.cwnu.lease.web.app.vo.history.HistoryItemVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Objects;

/**
 * @author Jisam
 * @description 针对表【browsing_history(浏览历史)】的数据库操作Service实现
 * @createDate 2024-06-04 15:48:00
 *
 * 浏览历史服务实现类，基于ServiceImpl进行扩展，实现BrowsingHistoryService接口。
 */
@Service
public class BrowsingHistoryServiceImpl extends ServiceImpl<BrowsingHistoryMapper, BrowsingHistory>
        implements BrowsingHistoryService {
    /**
     * 注入浏览历史Mapper，用于数据访问和操作。
     */
    @Autowired
    private BrowsingHistoryMapper browsingHistoryMapper;

    /**
     * 根据用户ID分页查询浏览历史项。
     *
     * @param page 分页对象，包含当前页和每页大小。
     * @param userId 用户ID，用于查询指定用户的浏览历史。
     * @return 返回分页后的浏览历史项。
     */
    @Override
    public IPage<HistoryItemVo> pageHistoryItemByUserId(Page<HistoryItemVo> page, Long userId) {
        return browsingHistoryMapper.pageHistoryItemByUserId(page, userId);
    }

    /**
     * 异步保存浏览历史。
     *
     * @param userId 用户ID，记录浏览历史的用户。
     * @param roomId 房间ID，用户浏览的房间。
     *
     * 此方法首先尝试更新已存在的浏览记录，如果不存在，则插入新的浏览记录。
     * 使用异步处理是为了提高响应性能，避免保存浏览历史的操作阻塞用户请求。
     */
    @Override
    @Async
    public void saveHistory(Long userId, Long roomId) {

        System.out.println("保存浏览历史-" + Thread.currentThread().getName());
        // 构建查询条件，检查是否已存在相同的浏览记录
        LambdaQueryWrapper<BrowsingHistory> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(BrowsingHistory::getUserId, userId);
        queryWrapper.eq(BrowsingHistory::getRoomId, roomId);
        BrowsingHistory browsingHistory = browsingHistoryMapper.selectOne(queryWrapper);

        // 如果浏览记录已存在，则更新浏览时间
        if (Objects.nonNull(browsingHistory)) {
            browsingHistory.setBrowseTime(new Date());
            browsingHistoryMapper.updateById(browsingHistory);
        } else {
            // 如果不存在，则创建新的浏览记录并插入
            BrowsingHistory newBrowsingHistory = new BrowsingHistory();
            newBrowsingHistory.setUserId(userId);
            newBrowsingHistory.setRoomId(roomId);
            newBrowsingHistory.setBrowseTime(new Date());
            browsingHistoryMapper.insert(newBrowsingHistory);
        }
    }
}
