package com.clay.system.service;

import com.clay.system.model.enity.DrugTypeCode;

import java.util.List;

/**
 * @Author clay
 * @Email wandererchen.xyz@foxmail.com
 * @Blog www.wandererchen.xyz
 * @Date 2020/6/2 15:06
 * @Version 1.0
 *
 * 药物类型代码服务
 */
public interface TypeCodeService
{
    void saveAType(DrugTypeCode typeCode);

    List<DrugTypeCode>getAllTypeCode();

    int delById(int id);

    int updateById(DrugTypeCode typeCode);

    DrugTypeCode getByCodeId(int id);
}
