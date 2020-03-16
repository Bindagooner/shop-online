package com.van.shoponline.audit.service;

import com.van.shoponline.audit.dto.ActivityLogData;
import com.van.shoponline.audit.persistence.entity.ActivityLogEntity;
import com.van.shoponline.audit.persistence.repository.ActivityLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActivityLogServiceImpl implements IActivityLogService {

    @Autowired
    private ActivityLogRepository activityLogRepository;

    @Override
    public ActivityLogEntity save(ActivityLogData dto) {
        ActivityLogEntity entity = new ActivityLogEntity();
        entity.setSortDirection(dto.getSortDirection());
        entity.setSortBy(dto.getSortBy());
        entity.setSearchBy(dto.getSearchBy());
        entity.setSearchQuery(dto.getSearchQuery());
        entity.setTimeStamp(dto.getTimeStamp());
        entity.setType(dto.getType());
        return activityLogRepository.save(entity);
    }
}
