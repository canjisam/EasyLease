package com.cwnu.lease.web.admin.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cwnu.lease.common.result.Result;
import com.cwnu.lease.model.entity.ViewAppointment;
import com.cwnu.lease.model.enums.AppointmentStatus;
import com.cwnu.lease.web.admin.mapper.ViewAppointmentMapper;
import com.cwnu.lease.web.admin.service.ViewAppointmentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cwnu.lease.web.admin.vo.appointment.AppointmentQueryVo;
import com.cwnu.lease.web.admin.vo.appointment.AppointmentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Jisam
 * @description 针对表【view_appointment(预约看房信息表)】的数据库操作Service实现
 * @createDate 2024-06-04 15:48:00
 */
@Service
public class ViewAppointmentServiceImpl extends ServiceImpl<ViewAppointmentMapper, ViewAppointment>
        implements ViewAppointmentService {

    @Autowired
    private ViewAppointmentMapper viewAppointmentMapper;

    @Override
    public IPage<AppointmentVo> pageAppointment(Page<AppointmentVo> page, AppointmentQueryVo queryVo) {
        return viewAppointmentMapper.pageAppointment(page,queryVo);
    }

    @Override
    public Result updateStatusById(Long id, AppointmentStatus status) {
        viewAppointmentMapper.updateStatusById(id,status);
        return Result.ok();
    }
}




