package com.clay.system.model.vo;

import com.clay.system.model.enity.DrugStorage;
import com.clay.system.model.enity.DrugSuppliersInfo;
import com.clay.system.model.enity.PurchaseDetails;
import com.clay.system.model.enity.PurchaseRecord;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author clay
 * @Email wandererchen.xyz@foxmail.com
 * @Blog www.wandererchen.xyz
 * @Date 2020/6/1 18:59
 * @Version 1.0
 *
 * 采购解析的数据组合
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseDataModel
{
    private PurchaseRecord record;
    private List<PurchaseDetails>details;
    private List<DrugStorage> drugStorageList;
    private List<DrugSuppliersInfo>suppliersInfos;
}
