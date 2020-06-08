package com.clay.system.utils;

import com.alibaba.excel.EasyExcel;
import com.clay.system.model.excel.UserExcel;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author clay
 * @Email wandererchen.xyz@foxmail.com
 * @Blog www.wandererchen.xyz
 * @Date 2020/6/5 1:56
 * @Version 1.0
 */
public class ExcelTest
{
    public static void main(String[]args)
    {
       String name="D:\\3D\\test.xlsx";
        EasyExcel.write(name, UserExcel.class).sheet("测试").doWrite(data());

    }
    public static List<UserExcel>data()
    {
        List<UserExcel>data=new LinkedList<>();
        UserExcel user0=new UserExcel();
        user0.setName("描述");
        user0.setDes("miao");
        data.add(user0);
        for (int i=0;i<10;i++)
        {
            UserExcel user=new UserExcel();
            user.setName("clay_"+i);
            user.setDes("dedsd"+i*10);
            data.add(user);
        }

        return data;
    }
}
