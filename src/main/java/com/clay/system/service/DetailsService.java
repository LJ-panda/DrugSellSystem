package com.clay.system.service;

import com.clay.system.model.enity.PurchaseDetails;

import java.util.List;

/**
 * @Author clay
 * @Email wandererchen.xyz@foxmail.com
 * @Blog www.wandererchen.xyz
 * @Date 2020/6/1 18:36
 * @Version 1.0
 *
 * 采购详情处理方法封装
 * {@link RecordService}是采购记录对象的处理封装
 * 实现类 {@link com.clay.system.service.imp.PurchaseServiceImp}
 */
public interface DetailsService
{
    int saveADetails(PurchaseDetails details);

    int saveAllDetails(List<PurchaseDetails>detailsList);


    //通过采购吗获取
    List<PurchaseDetails>queryByCode(int code);
}
