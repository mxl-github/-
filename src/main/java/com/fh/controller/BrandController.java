package com.fh.controller;

import com.alibaba.fastjson.JSON;
import com.fh.bean.Brand;
import com.fh.redis.RedisService;
import com.fh.service.BrandService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("brand")
@CrossOrigin(maxAge = 3600,origins = "http://localhost:8080")
public class BrandController {

    @Resource
    private BrandService brandService;

    @Resource
    private RedisService redisService;

    @GetMapping("queryAll")
    public List<Brand> queryAll(){
        List<Brand> list=brandService.queryAll();
    return list;
    }

    /*查询类型对应的品牌*/
    @GetMapping("queryShowBrandList")
    @ResponseBody
    public Object queryShowBrandList(String id){
        Boolean isExistKey=redisService.isExistKey("brands");
        Object brandList=null;
        if(!isExistKey){
            brandList=brandService.queryShowBrandList(id);
            String cateJson= JSON.toJSONString(brandList);
            redisService.setStringKeyAndValue("categoryAll",cateJson);
        }else{
            brandList= redisService.getStringValueByKey("brands");
        }
        return  brandList;
    }


    @GetMapping("queryBrandListByTypeId")
    @ResponseBody
    public List<Brand> queryBrandListByTypeId(String id){
        return brandService.queryBrandListByTypeId(id);
    }

}
   /* *//*分页*//*
    @RequestMapping("queryBrandPage")
    @ResponseBody
    public DataTable<Brand> queryBrandPage(DataTable<Brand> dataTable, BrandQuery brandQuery){
       brandService.queryBrandPage(dataTable,brandQuery);
       return dataTable;
    }

    *//*图片*//*
    @RequestMapping("uploadFile")
    @ResponseBody
    public  Map<String,Object> uploadFile(@RequestParam("file") MultipartFile file){
            Map<String,Object> map=new HashMap<String, Object>();
            String image = CopyFile.copyFile(file, "image");
            map.put("image",image);
        return map;
    }

    *//*跳入新增页*//*
    @RequestMapping("toBrandAdd")
    public String toBrandAdd(){
        return "brand/brand-add";
    }

    *//*新增*//*
    @RequestMapping("brandAdd")
    @ResponseBody
    public Map<String,Object> brandAdd(Brand brand){
        Map<String,Object> map=new HashMap<String, Object>();
        if(brand!=null){
            brandService.addBrand(brand);
            map.put("ccc",true);
            map.put("aaa","新增成功");
        }
       return  map;
    }


    *//*回显*//*
    @RequestMapping("toUpdateBrand")
    public String toUpdateBrand(Integer brandId, Model model){
        Brand brand=brandService.getBrandId(brandId);
        model.addAttribute("brand",brand);
        return "brand/brand-update";
    }

    *//*修改*//*
    @RequestMapping("updateBrand")
    @ResponseBody
    public Map<String,Object> updateBrand(Brand brand){
        Map<String,Object> map=new HashMap<String, Object>();
        if(brand!=null){
            brandService.updateBrand(brand);
            map.put("ccc",true);
            map.put("aaa","修改成功");
        }
        return  map;
    }

    *//*删除*//*
    @RequestMapping("deleteBrand")
    @ResponseBody
    public Map<String,Object> deleteBrand(Integer brandId){
        Map<String,Object> map=new HashMap<String, Object>();
        if(brandId!=null){
            brandService.deleteBrand(brandId);
            map.put("ccc",true);
            map.put("aaa","删除成功");
        }
        return  map;
    }


    *//*导出excel*//*
    @RequestMapping("exportExcel")
    @ResponseBody
    public Map<String,Object> exportExcel(BrandQuery brandQuery) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Brand> brandList = brandService.queryBrandList(brandQuery);
        if (brandList.size() == 0) {
            map.put("ccc", "没有要导出的数据!");
            return map;
        }
        String url = ExcelUtils.export(brandList, Brand.class);
        map.put("ccc", url);
        return map;
        }*/
