package com.clay.system.service.imp;

import com.clay.system.mapper.DetailsMapper;
import com.clay.system.mapper.PurchaseRecordMapper;
import com.clay.system.model.enity.PurchaseDetails;
import com.clay.system.model.enity.PurchaseRecord;
import com.clay.system.model.vo.BuyRecord;
import com.clay.system.model.vo.PurchaseDataModel;
import com.clay.system.service.DetailsService;
import com.clay.system.service.DrugStorageService;
import com.clay.system.service.RecordService;
import com.clay.system.service.SupplierService;
import com.clay.system.utils.ConvertUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author clay
 * @Email wandererchen.xyz@foxmail.com
 * @Blog www.wandererchen.xyz
 * @Date 2020/6/1 18:47
 * @Version 1.0
 *
 * 采购记录信息的实现类
 * 实现接口{@link RecordService}、{@link DetailsService}
 */
@Slf4j
@Service
@AllArgsConstructor
public class PurchaseServiceImp implements RecordService, DetailsService
{
    private DetailsMapper detailsMapper;

    private PurchaseRecordMapper recordMapper;

    private SupplierService supplierService;

    private DrugStorageService storageService;
    /**
     * 存储单个记录
     *
     * @param details  记录细节
     * @return 影响的数据行数
     */
    @Override
    public int saveADetails(PurchaseDetails details)
    {
        List<PurchaseDetails>details1=new ArrayList<>();
        details1.add(details);
        return this.saveAllDetails(details1);
    }

    /**
     * 批量插入数据
     * @param detailsList 要插入的数据集合
     * @return 行数
     */
    @Override
    public int saveAllDetails(List<PurchaseDetails> detailsList)
    {
        return detailsMapper.insertDetails(detailsList);
    }

    /**
     * 通过采购代码查询对应的采购详情
     * @param code 采购码
     * @return 结果集合
     */
    @Override
    public List<PurchaseDetails> queryByCode(int code)
    {
        return detailsMapper.queryByCode(code);
    }

    /**
     * 进行采购记录写库
     * 但是会通过该服务调用库存服务和供应商等服务
     * 需要使用事务
     * @param record 记录
     * @return 没用的
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int saveRecord(BuyRecord record)
    {
        log.debug("sevice 层进行采购记录写库:{}",record);
        PurchaseDataModel model= ConvertUtils.RecordConvertToDB(record);
        //存储供应商信息
        supplierService.saveSuppliers(model.getSuppliersInfos());
        //库存信息
        storageService.saveDrugs(model.getDrugStorageList());
        this.saveAllDetails(model.getDetails());
        return recordMapper.insertRecord(model.getRecord());
    }

    /**
     * 通过采购吗查询
     * @param code 采购码
     * @return
     */
    @Override
    public PurchaseRecord queryARecordByCode(int code) {
        return recordMapper.queryByCode(code);
    }

    @Override
    public List<PurchaseRecord> queryAllRecord()
    {
        return recordMapper.queryAll();
    }
}
