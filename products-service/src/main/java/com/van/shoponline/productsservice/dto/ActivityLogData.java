package com.van.shoponline.productsservice.dto;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
public class ActivityLogData {
    private Date timeStamp;
    private String type;
    private String searchBy;
    private String searchQuery;
    private String order;
    private String sortBy;
}
