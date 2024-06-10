package com.cwnu.lease.web.admin.schedule;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cwnu.lease.model.entity.LeaseAgreement;
import com.cwnu.lease.model.enums.LeaseStatus;
import com.cwnu.lease.web.admin.service.LeaseAgreementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component

public class ScheduleTasks {
//    @Scheduled(cron = "* * * * * *")
//    public void test() {
//        System.out.println(new Date());
//    }

}
