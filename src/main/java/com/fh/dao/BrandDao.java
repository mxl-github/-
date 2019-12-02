package com.fh.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fh.bean.Brand;
import com.fh.bean.BrandQuery;
import com.fh.bean.DataTable;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface BrandDao extends BaseMapper<Brand> {

    Long queryCount(@Param("brandQuery") BrandQuery brandQuery);

    List<Brand> queryBrandDataTable(@Param("dataTable") DataTable<Brand> dataTable, @Param("brandQuery") BrandQuery brandQuery);

    List<Brand> queryBrandList(@Param("brandQuery") BrandQuery brandQuery);

    List<Brand> queryShowBrandList(String id);

    List<Brand> queryBrandListByTypeId(String id);
}
