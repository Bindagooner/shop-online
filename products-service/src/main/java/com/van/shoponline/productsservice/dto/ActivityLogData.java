package com.van.shoponline.productsservice.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
@EqualsAndHashCode
public class ActivityLogData {
    private Date timeStamp;
    private String type;
    private String searchBy;
    private String searchQuery;
    private String sortDirection;
    private String sortBy;
}
