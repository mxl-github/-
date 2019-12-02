package com.fh.bean;

import java.util.List;

public class DataTable<T> {
     private Integer start;//    开始下表start
     private Integer length;//       每页条数length
     private Integer draw=1;//       绘制次数draw=1
     private Long    recordsTotal;//       总长度recordsTotal
     private Long    recordsFiltered;//       过滤后的长度recordsFiltered
     private List<T> data;//包含的数据data

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Integer getDraw() {
        return draw;
    }

    public void setDraw(Integer draw) {
        this.draw = draw;
    }

    public Long getRecordsTotal() {
        return recordsTotal;
    }

    public void setRecordsTotal(Long recordsTotal) {
        this.recordsTotal = recordsTotal;
    }

    public Long getRecordsFiltered() {
        return recordsFiltered;
    }

    public void setRecordsFiltered(Long recordsFiltered) {
        this.recordsFiltered = recordsFiltered;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
