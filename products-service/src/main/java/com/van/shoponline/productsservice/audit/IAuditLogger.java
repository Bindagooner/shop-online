package com.van.shoponline.productsservice.audit;

public interface IAuditLogger<T> {
    void log(T t);
}
