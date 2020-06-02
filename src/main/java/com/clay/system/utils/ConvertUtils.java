package com.clay.system.utils;

import com.clay.system.model.enity.DrugStorage;
import com.clay.system.model.enity.PurchaseDetails;
import com.clay.system.model.enity.PurchaseRecord;
import com.clay.system.model.enity.User;
import com.clay.system.model.vo.BuyRecord;
import com.clay.system.model.vo.Drug;
import com.clay.system.model.vo.PurchaseDataModel;
import com.clay.system.model.vo.VoUser;
import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;

/**
 * @Author clay
 * @Email wandererchen.xyz@foxmail.com
 * @Blog www.wandererchen.xyz
 * @Date 2020/5/30 13:49
 * @Version 1.0
 *
 * 数据转换工具类
 * 主要用于组装数据库返回的数据、或者组装前端传递的数据
 */
@Slf4j
public class ConvertUtils
{
    /**
     * 将前端传递的采购记录转换为便于持久化的对象
     * @param record 前端的合法记录
     * @return 一个封装对象
     */
    public static PurchaseDataModel RecordConvertToDB(BuyRecord record)
    {
        PurchaseDataModel model=new PurchaseDataModel();
        model.setDetails(new LinkedList<>());
        model.setDrugStorageList(new LinkedList<>());
        model.setSuppliersInfos(new LinkedList<>());

        PurchaseRecord record1=new PurchaseRecord();
        int code=record.hashCode();
        record1.setTotalPrice(0);
        record1.setTip(record.getTip());
        record1.setPurchaseCode(code);
        record1.setTime(record.getTime());
        model.setRecord(record1);
        record.getDrugs()
                .forEach(a->{
                    a.setDrugCode(a.hashCode());          //药物代码
                    a.getSuppliersInfo().setSupplierCode(a.getSuppliersInfo().hashCode());  //药物供应商代码
                    //添加库存对象
                    model.getDrugStorageList().add(buildDrugStorage(a));
                    //添加所有供应商对象以便后期写库
                    model.getSuppliersInfos().add(a.getSuppliersInfo());

                    PurchaseDetails details=new PurchaseDetails();
                    details.setDrugCode(a.getDrugCode());  //drug对象hash出来的代码
                    details.setDrugNum(a.getDrugNum());
                    details.setPurchaseCode(code);
                    details.setSinglePrice(a.getSinglePrice());
                    details.setTotalPrice(a.getSinglePrice()*a.getDrugNum());
                    record1.setTotalPrice(record1.getTotalPrice()+details.getTotalPrice());
                    model.getDetails().add(details);
                });
        return model;
    }

    public static DrugStorage buildDrugStorage(Drug drug)
    {
        DrugStorage storage=new DrugStorage();
        storage.setDescription(drug.getDescription());   //药物描述
        storage.setDrugCode(drug.hashCode());         //药物代码
        storage.setDrugName(drug.getDrugName());      //name
        storage.setDrugNum(drug.getDrugNum());            //数量
        storage.setTypeCodeId(drug.getTypeCode());      //类型代码
        storage.setSupplier(drug.getSuppliersInfo().getSupplierCode());      //供应商
        log.debug("转换的drug对象:{}",storage);
        return storage;
    }


    public static User buildUserByVo(VoUser user)
    {
        User u=new User();
        u.setEmail(user.getEmail());
        u.setDescription(user.getDescription());
        u.setPassword(user.getPassword());
        u.setStatus(user.getStatus()==1||user.getStatus()==-1?user.getStatus():1);
        u.setUserName(user.getUserName());
        return u;
    }
}