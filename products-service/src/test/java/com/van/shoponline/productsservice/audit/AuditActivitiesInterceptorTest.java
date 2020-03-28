package com.van.shoponline.productsservice.audit;

import com.van.shoponline.productsservice.dto.ActivityLogData;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

public class AuditActivitiesInterceptorTest {

    private AuditActivitiesInterceptor interceptor = new AuditActivitiesInterceptor();

    @Test
    public void testBuildActivityLogData() {
        // 'http://localhost:7770/products-service/api/products/search/byName?name=iphone&sort=price,desc'
        String uri = "/product-service/api/products/search/byName";
        Map<String, String[]> params = new HashMap<>();
        params.put("name", new String[]{"iphone"});
        params.put("sort", new String[] {"price,desc"});
        ActivityLogData actual = interceptor.buildActivityLogData(uri, params);
        Assert.assertEquals("products", actual.getType());
        Assert.assertEquals("name", actual.getSearchBy());
        Assert.assertEquals("iphone", actual.getSearchQuery());
        Assert.assertEquals("price", actual.getSortBy());
        Assert.assertEquals("desc", actual.getSortDirection());
    }
}
