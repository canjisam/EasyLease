package com.cwnu.lease.web.app.service;

import com.cwnu.lease.model.entity.ViewAppointment;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cwnu.lease.web.app.vo.appointment.AppointmentDetailVo;
import com.cwnu.lease.web.app.vo.appointment.AppointmentItemVo;

import java.util.List;

/**
* @author Jisam
* @description 针对表【view_appointment(预约看房信息表)】的数据库操作Service
* @createDate 2024-06-04 15:48:00
*/
public interface ViewAppointmentService extends IService<ViewAppointment> {

    List<AppointmentItemVo> listItemByUserId(Long userId);

    AppointmentDetailVo getDetailById(Long id);
}
