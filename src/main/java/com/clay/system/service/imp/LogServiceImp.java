package com.clay.system.service.imp;

import com.clay.system.mapper.LogMapper;
import com.clay.system.model.enity.SystemLog;
import com.clay.system.service.LogService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author clay
 * @Email wandererchen.xyz@foxmail.com
 * @Blog www.wandererchen.xyz
 * @Date 2020/6/2 15:02
 * @Version 1.0
 */
@Slf4j
@Service
@AllArgsConstructor
public class LogServiceImp implements LogService
{
    private LogMapper logMapper;

    @Override
    public void saveLog(SystemLog log) {
        logMapper.insertLog(log);
    }

    @Override
    public void saveLoggs(List<SystemLog> logList)
    {
        log.debug("service 层存储日志");
        logMapper.insertLogs(logList);
    }

    @Override
    public List<SystemLog> getAllLog()
    {
        return logMapper.queryLogs();
    }

    @Override
    public List<SystemLog> getAllByType(int type) {
        return logMapper.queryLogByType(type);
    }
}
