package com.clay.system.mapper;

import com.clay.system.model.enity.SystemLog;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author clay
 * @Email wandererchen.xyz@foxmail.com
 * @Blog www.wandererchen.xyz
 * @Date 2020/5/30 21:50
 * @Version 1.0
 *
 * 日志映射器
 */
@Repository
public interface LogMapper
{
    int insertLog(SystemLog log);

    int insertLogs(List<SystemLog> logs);

    List<SystemLog>queryLogs();

    List<SystemLog>queryLogByType(int typeId);
}
