package com.clay.system.service;

import com.clay.system.model.enity.SystemLog;

import java.util.List;

/**
 * @Author clay
 * @Email wandererchen.xyz@foxmail.com
 * @Blog www.wandererchen.xyz
 * @Date 2020/6/2 14:59
 * @Version 1.0
 *
 * 日志服务
 */
public interface LogService
{
    //批量存储日志
    void saveLoggs(List<SystemLog>logList);

    void saveLog(SystemLog log);

    //获取所有
    List<SystemLog>getAllLog();

    //通过类型获取
    List<SystemLog>getAllByType(int type);


}
