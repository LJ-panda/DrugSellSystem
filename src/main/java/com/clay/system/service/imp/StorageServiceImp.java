package com.clay.system.service.imp;

import com.clay.system.mapper.DrugStorageMapper;
import com.clay.system.model.enity.DrugStorage;
import com.clay.system.model.enity.TimeOutDrug;
import com.clay.system.service.DrugStorageService;
import com.clay.system.service.DrugTimeOutService;
import com.clay.system.utils.ConvertUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author clay
 * @Email wandererchen.xyz@foxmail.com
 * @Blog www.wandererchen.xyz
 * @Date 2020/6/1 21:27
 * @Version 1.0
 *
 * 药品库存服务
 */
@Slf4j
@Service
@AllArgsConstructor
public class StorageServiceImp implements DrugStorageService
{

    private DrugStorageMapper storageMapper;

    private DrugTimeOutService timeOutService;

    /**
     * 修改库存
     * 数据库中有，则更改数据
     * 否则就插入数据
     * @param storageList
     */
    @Override
    public void saveDrugs(List<DrugStorage> storageList)
    {
       storageList.forEach(drug->{
           if (getByCode(drug.getDrugCode())!=null)
           {
               updateNum(drug);
           }
           else
           {
               storageMapper.insertDrugInfo(drug);
           }
       });
    }

    /**
     * 更新库存
     * @param storage 新增的信息
     */
    @Override
    public void updateNum(DrugStorage storage)
    {
        storageMapper.update(storage);
    }

    /**
     * 通过药物code获取数据库中的药物信息
     * @param code   药物code
     * @return
     */
    @Override
    public DrugStorage getByCode(int code)
    {
        DrugStorage drug=storageMapper.queryByCode(code);
        if (drug!=null&&drug.getCanUseTime().before(new Date()))
        {
            timeOutService.save(ConvertUtils.buildOutDrug(drug));
            storageMapper.delById(drug.getId());
            return null;
        }
        return drug;
    }

    @Override
    public void delById(int id) {
        storageMapper.delById(id);
    }

    /**
     * 进行过滤操作
     * @return l
     */
    @Override
    public List<DrugStorage> getAll()
    {
        return getCanUseDrug(storageMapper.queryAll());
    }

    /**
     * 过滤数据，只返回可用药物
     * 将过期药物持久化到别的表
     * @param list 查询的所有
     * @return can use
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public List<DrugStorage> getCanUseDrug(List<DrugStorage> list)
    {
        Date now=new Date();            //获取当前日期

        List<TimeOutDrug>outDrug = new LinkedList<>();
        for (DrugStorage drug:list)
        {
            if (drug.getCanUseTime().before(now))
            {
                list.remove(drug);
                delById(drug.getId());
                outDrug.add(ConvertUtils.buildOutDrug(drug));
            }
        }

        if (!outDrug.isEmpty())
        {
            timeOutService.saveAll(outDrug);
        }

        return list;
    }
}
