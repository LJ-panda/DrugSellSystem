package com.clay.system.service.imp;

import com.clay.system.mapper.TypeCodeMapper;
import com.clay.system.model.enity.DrugTypeCode;
import com.clay.system.service.TypeCodeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author clay
 * @Email wandererchen.xyz@foxmail.com
 * @Blog www.wandererchen.xyz
 * @Date 2020/6/2 15:08
 * @Version 1.0
 *
 * 药物类型代码服务
 */
@Service
@AllArgsConstructor
public class TypeCodeServiceImp implements TypeCodeService
{
    private TypeCodeMapper typeCodeMapper;

    @Override
    public void saveAType(DrugTypeCode typeCode)
    {
        typeCodeMapper.insert(typeCode);
    }

    @Override
    public List<DrugTypeCode> getAllTypeCode()
    {
        return typeCodeMapper.queryAllTypeCode();
    }

    @Override
    public int delById(int id) {
        return typeCodeMapper.delById(id);
    }

    @Override
    public int updateById(DrugTypeCode typeCode) {
        return typeCodeMapper.updateById(typeCode);
    }
}
