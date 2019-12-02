package com.fh.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@TableName("dirSir_brand")
@Data
public class Brand {
    //品牌表
    @TableId(value ="brandId",type = IdType.UUID)
    private String brandId;//	Integer
    @TableField("brandName")
    private String brandName;//	varchar 名称
    @TableField("brandPhone")
    private String brandPhone;//	varchar 电话
    @TableField("brandWebsite")
    private String brandWebsite;//	varchar0    网站
    @TableField("typeId")
    private Integer typeId;//	int 类型
    @TableField("brandLoGo")
    private String brandLoGo;//	varchar 图标
    @TableField("brandStatus")
    private Integer brandStatus;//	int 状态
    @TableField("updateTime")
    @DateTimeFormat(pattern ="yyyy-MM-dd")
    private Date updateTime;//	date    修改时间

}
