package com.van.shoponline.productsservice;

import com.van.shoponline.productsservice.audit.AuditActivitiesInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.handler.MappedInterceptor;

@Configuration
public class CustomWebMvcConfig {

    @Autowired
    private AuditActivitiesInterceptor auditActivitiesInterceptor;

    @Bean
    public MappedInterceptor dbEditorTenantInterceptor() {
        return new MappedInterceptor(new String[]{"/api/**"}, auditActivitiesInterceptor);
    }
}
