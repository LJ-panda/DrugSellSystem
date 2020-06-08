package com.clay.system.service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Author clay
 * @Email wandererchen.xyz@foxmail.com
 * @Blog www.wandererchen.xyz
 * @Date 2020/6/5 3:19
 * @Version 1.0
 *
 * 各数据报表的生成服务
 */
public interface ExcelService
{
    /**
     * 产生药物采购报表的服务
     * @param response rep
     * @throws IOException e
     */
    void buildDrugPurchaseExcel(HttpServletResponse response) throws IOException;

    /**
     * 产生销售记录报表的服务
     * @param response rep
     * @throws IOException e
     */
    void buildDrugSellExcel(HttpServletResponse response) throws IOException;

    /**
     * 产生药物库存报表的服务
     * @param response rep
     * @throws IOException e
     */
    void buildDrugStorageExcel(HttpServletResponse response) throws IOException;

    /**
     * 产生供应商报表的服务
     * @param response rep
     * @throws IOException e
     */
    void buildDrugSupplierExcel(HttpServletResponse response) throws IOException;

    /**
     * 产生类型代码报表的服务
     * @param response rep
     * @throws IOException e
     */
    void buildDrugTypeCodeExcel(HttpServletResponse response) throws IOException;

    /**
     * 日志报表服务
     * @param response rep
     * @throws IOException e
     */
    void buildLogExcel(HttpServletResponse response) throws IOException;

    /**
     * 过期药物的报表服务
     * @param response rep
     * @throws IOException e
     */
    void buildTimeOutDrugExcel(HttpServletResponse response) throws IOException;


    /**
     * 用户信息报表服务
     * @param response rep
     * @throws IOException e
     */
    void buildUserExcel(HttpServletResponse response) throws IOException;

    /**
     * 工具方法，
     * 用于封装 Excel 处理的共同部分，
     * 并将数据写入输出流
     * @param response  响应体
     * @param fileName  下载的文件名
     * @param excelList 数据列表
     * @param clazz     Excel 对应的 Class 对象
     * @param <T>       泛型参数
     * @throws IOException 可能的异常
     */
    <T>void deal(HttpServletResponse response, String fileName, List<T> excelList, Class<T>clazz) throws IOException;
}
