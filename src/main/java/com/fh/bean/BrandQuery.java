package com.fh.bean;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Data
public class BrandQuery {

    private String brandName;//	varchar 名称

    private Integer brandStatus;//	int 状态

    @DateTimeFormat(pattern ="yyyy-MM-dd")
    private Date updateTime;//	date    修改时间

    @DateTimeFormat(pattern ="yyyy-MM-dd")
    private Date startDate;

    @DateTimeFormat(pattern ="yyyy-MM-dd")
    private Date endDate;

}
