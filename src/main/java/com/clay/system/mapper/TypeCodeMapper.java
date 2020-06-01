package com.clay.system.mapper;

import com.clay.system.model.enity.DrugTypeCode;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author clay
 * @Email wandererchen.xyz@foxmail.com
 * @Blog www.wandererchen.xyz
 * @Date 2020/5/30 19:47
 * @Version 1.0
 *
 * 类型码映射
 */
@Repository
public interface TypeCodeMapper
{
    List<DrugTypeCode>queryAllTypeCode();

    int insert(DrugTypeCode typeCode);

    int delById(int id);

    int updateById(DrugTypeCode typeCode);
}
