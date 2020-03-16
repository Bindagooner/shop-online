package com.van.shoponline.productsservice.audit;

import com.van.shoponline.productsservice.dto.ActivityLogData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AmqpActivityLogger implements IAuditLogger<ActivityLogData> {
    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public AmqpActivityLogger(RabbitTemplate rabbitTemplate){
        this.rabbitTemplate = rabbitTemplate;
    }
    @Override
    public void log(ActivityLogData auditLogData) {
        this.rabbitTemplate.convertAndSend(RabbitConfig.QUEUE_AUDIT, auditLogData);
    }
}
