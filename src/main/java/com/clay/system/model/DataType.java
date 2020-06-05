package com.clay.system.model;

/**
 * @Author clay
 * @Email wandererchen.xyz@foxmail.com
 * @Blog www.wandererchen.xyz
 * @Date 2020/6/5 17:32
 * @Version 1.0
 */
public enum  DataType
{
    LOG(0),DRUG_SRORAGE(1);

    private int val;
    DataType(int i) {
        this.val=i;
    }

    public int getVal() {
        return val;
    }
}
