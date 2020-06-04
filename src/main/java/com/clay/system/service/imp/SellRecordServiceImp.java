package com.clay.system.service.imp;

import com.clay.system.exception.DrugSystemException;
import com.clay.system.mapper.SellRecordDetailsMapper;
import com.clay.system.mapper.SellRecordMapper;
import com.clay.system.model.enity.DrugStorage;
import com.clay.system.model.enity.SellRecord;
import com.clay.system.model.enity.SellRecordDetails;
import com.clay.system.service.DrugStorageService;
import com.clay.system.service.SellRecordDetailsService;
import com.clay.system.service.SellRecordService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author clay
 * @Email wandererchen.xyz@foxmail.com
 * @Blog www.wandererchen.xyz
 * @Date 2020/6/4 23:24
 * @Version 1.0
 *
 * 销售记录服务详情
 * 实现接口：{@link SellRecordDetailsService}、{@link SellRecordService}
 */
@Slf4j
@Service
@AllArgsConstructor
public class SellRecordServiceImp implements SellRecordService, SellRecordDetailsService
{
    private SellRecordDetailsMapper detailsMapper;

    private SellRecordMapper recordMapper;

    //用于库存扣减
    private DrugStorageService storageService;


    @Override
    public void saveDetails(List<SellRecordDetails> detailsList)
            throws DrugSystemException
    {
        for (SellRecordDetails item:detailsList)
        {
            DrugStorage drugStorage=new DrugStorage();
            drugStorage.setDrugCode(item.getDrugCode());
            if (storageService.getByCode(item.getDrugCode()).getDrugNum()-item.getDrugNum()<0)
            {
                throw new DrugSystemException("库存不足：drugCode_"+item.getDrugCode());
            }
            drugStorage.setDrugNum(item.getDrugNum()*-1);  //因为服务的更新最开始只考虑了+
            storageService.updateNum(drugStorage);   //库存扣减
            detailsMapper.insertDetails(item);
        }
    }

    @Override
    public List<SellRecordDetails> getByOrderCode(int orderCode) {
        return detailsMapper.queryByOrderCode(orderCode);
    }

    @Transactional(rollbackFor = Exception.class,isolation = Isolation.READ_COMMITTED)
    @Override
    public void saveRecord(SellRecord record)
            throws DrugSystemException {
        saveDetails(record.getDetailsList());
        recordMapper.insertRecord(record);
    }

    @Override
    public List<SellRecord> getAllRecord() {
        return recordMapper.queryAll();
    }
}
