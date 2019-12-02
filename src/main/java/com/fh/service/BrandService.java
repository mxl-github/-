package com.fh.service;

import com.fh.bean.Brand;
import com.fh.bean.BrandQuery;
import com.fh.bean.DataTable;

import java.util.List;

public interface BrandService {

   void queryBrandPage(DataTable<Brand> dataTable, BrandQuery brandQuery);

    void addBrand(Brand brand);

    Brand getBrandId(Integer brandId);

    void updateBrand(Brand brand);

    void deleteBrand(Integer brandId);

    List<Brand> queryBrandList(BrandQuery brandQuery);

    List<Brand> queryAll();

    List<Brand> queryShowBrandList(String id);

    List<Brand> queryBrandListByTypeId(String id);
}
