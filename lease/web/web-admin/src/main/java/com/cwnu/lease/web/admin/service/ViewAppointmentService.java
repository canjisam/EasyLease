package com.cwnu.lease.web.admin.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cwnu.lease.common.result.Result;
import com.cwnu.lease.model.entity.ViewAppointment;
import com.cwnu.lease.model.enums.AppointmentStatus;
import com.cwnu.lease.web.admin.vo.appointment.AppointmentQueryVo;
import com.cwnu.lease.web.admin.vo.appointment.AppointmentVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Update;

/**
* @author Jisam
* @description 针对表【view_appointment(预约看房信息表)】的数据库操作Service
* @createDate 2024-06-04 15:48:00
*/
public interface ViewAppointmentService extends IService<ViewAppointment> {

    IPage<AppointmentVo> pageAppointment(Page<AppointmentVo> page, AppointmentQueryVo queryVo);


    Result updateStatusById(Long id, AppointmentStatus status);
}
