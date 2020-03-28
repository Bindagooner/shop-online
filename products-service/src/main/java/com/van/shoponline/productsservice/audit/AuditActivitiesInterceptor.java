package com.van.shoponline.productsservice.audit;

import com.van.shoponline.productsservice.dto.ActivityLogData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.Map;

@Component
@Slf4j
public class AuditActivitiesInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private IAuditLogger<ActivityLogData> auditLogger;
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
                                @Nullable Exception ex) throws Exception {

        ActivityLogData logData = buildActivityLogData(request.getRequestURI(), request.getParameterMap());
        auditLogger.log(logData);
        log.info(logData.toString());
    }

    protected ActivityLogData buildActivityLogData(String uri, Map<String, String[]> parameterMap) {
        String[] split = uri.split("/");
        ActivityLogData logData = new ActivityLogData();
        logData.setTimeStamp(new Date());
        logData.setType(split[3]);
        if (split.length >= 5 && "search".equalsIgnoreCase(split[4])) {
            String searchBy = split[5].replace("by", "");
            logData.setSearchBy(searchBy.toLowerCase());
            String[] query = parameterMap.get(searchBy.toLowerCase());
            if (null != query) {
                logData.setSearchQuery(String.join(",", parameterMap.get(searchBy.toLowerCase())));
            }
        }
        String[] sorts = parameterMap.get("sort");
        if (null != sorts) {
            String[] split1 = sorts[0].split(",");
            logData.setSortBy(split1[0]);
            if (split1.length == 2) {
                logData.setSortDirection(split1[1].toLowerCase());
            } else {
                logData.setSortDirection("asc");
            }
        }
        return logData;
    }
}
