package com.example.mall.common.api;

import com.github.pagehelper.PageInfo;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @author W
 * @date 2022-02-23
 */
public class CommonPage<T> {

    /**
     * 当前页码
     */
    private Integer pageNum;

    /**
     * 页面大小
     */
    private Integer pageSize;

    /**
     * 总页数
     */
    private Integer totalPage;

    /**
     * 总条数
     */
    private Long total;

    /**
     * 分页数据
     */
    private List<T> list;

    /**
     * 将pageHelper分页后的数据转为自己的分页信息
     *
     * @param list
     * @param <T>
     * @return
     */
    public static <T> CommonPage<T> restPage(List<T> list) {
        CommonPage<T> result = new CommonPage<>();
        PageInfo<T> pageInfo = new PageInfo<>(list);
        result.setTotalPage(pageInfo.getPages());
        result.setTotal(pageInfo.getTotal());
        result.setPageNum(pageInfo.getPageNum());
        result.setPageSize(pageInfo.getPageSize());
        result.setList(pageInfo.getList());
        return result;
    }

    /**
     * 将SpringData分页后的list转为分页信息
     */
    public static <T> CommonPage<T> restPage(Page<T> pageInfo) {
        CommonPage<T> result = new CommonPage<>();
        result.setTotalPage(pageInfo.getTotalPages());
        result.setTotal(pageInfo.getTotalElements());
        result.setPageSize(pageInfo.getSize());
        result.setPageNum(pageInfo.getNumber());
        result.setList(pageInfo.getContent());
        return result;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
