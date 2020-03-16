package com.van.shoponline.audit.service;

import com.van.shoponline.audit.dto.ActivityLogData;
import com.van.shoponline.audit.persistence.entity.ActivityLogEntity;

public interface IActivityLogService {
    ActivityLogEntity save(ActivityLogData dto);
}
