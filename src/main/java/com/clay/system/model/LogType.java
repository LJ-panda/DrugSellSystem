package com.clay.system.model;

import java.util.Iterator;
import java.util.function.Consumer;

/**
 * @Author clay
 * @Email wandererchen.xyz@foxmail.com
 * @Blog www.wandererchen.xyz
 * @Date 2020/6/2 17:39
 * @Version 1.0
 *
 * 日志类型枚举
 */
public enum LogType
{
    NORMAL(0),EXCEPTION(1),OTHER(2),VISITED(3);

    private int val;
    LogType(int i)
    {
        this.val=i;
    }

    public int getVal() {
        return val;
    }

}
