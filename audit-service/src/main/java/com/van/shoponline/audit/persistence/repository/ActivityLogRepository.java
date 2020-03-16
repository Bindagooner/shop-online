package com.van.shoponline.audit.persistence.repository;

import com.van.shoponline.audit.persistence.entity.ActivityLogEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ActivityLogRepository extends PagingAndSortingRepository<ActivityLogEntity, Long> {
}
