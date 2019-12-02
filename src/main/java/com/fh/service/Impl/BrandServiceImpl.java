package com.fh.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fh.bean.Brand;
import com.fh.bean.BrandQuery;
import com.fh.bean.DataTable;
import com.fh.dao.BrandDao;
import com.fh.service.BrandService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BrandServiceImpl implements BrandService  {

    @Resource
    private BrandDao brandDao;

    public void queryBrandPage(DataTable<Brand> dataTable, BrandQuery brandQuery){
        Long brandCount = brandDao.queryCount(brandQuery);
        dataTable.setRecordsTotal(brandCount);
        dataTable.setRecordsFiltered(brandCount);
        List<Brand> brandList = brandDao.queryBrandDataTable(dataTable,brandQuery);
        dataTable.setData(brandList);
    }

    @Override
    public void addBrand(Brand brand) {
        brandDao.insert(brand);
    }

    @Override
    public Brand getBrandId(Integer brandId) {
        QueryWrapper<Brand> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("brandId",brandId);
        return brandDao.selectOne(queryWrapper);
    }

    @Override
    public void updateBrand(Brand brand) {
        brandDao.updateById(brand);
    }

    @Override
    public void deleteBrand(Integer brandId) {
        QueryWrapper<Brand> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("brandId",brandId);
        brandDao.delete(queryWrapper);
    }

    @Override
    public List<Brand> queryBrandList(BrandQuery brandQuery) {
        List<Brand> brandList=brandDao.queryBrandList(brandQuery);
        return brandList;
    }

    @Override
    public List<Brand> queryAll() {
        List<Brand> brandList = brandDao.selectList(null);
        return brandList;
    }

    @Override
    public List<Brand> queryShowBrandList(String id) {
        List<Brand> brandList =brandDao.queryShowBrandList(id);
        return brandList;
    }

    @Override
    public List<Brand> queryBrandListByTypeId(String id) {
        return brandDao.queryBrandListByTypeId(id);
    }
}
