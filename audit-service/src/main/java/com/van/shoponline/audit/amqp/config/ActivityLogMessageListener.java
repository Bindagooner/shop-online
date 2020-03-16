package com.van.shoponline.audit.amqp.config;

import com.van.shoponline.audit.dto.ActivityLogData;
import com.van.shoponline.audit.service.IActivityLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ActivityLogMessageListener {

    @Autowired
    private IActivityLogService activityLogService;

    @RabbitListener(queues = RabbitConfig.QUEUE_AUDIT)
    public void processAudit(ActivityLogData logData) {
        activityLogService.save(logData);
        log.info("Activity Log Request processed, timeStamp: {}", logData.getTimeStamp());
    }
}
