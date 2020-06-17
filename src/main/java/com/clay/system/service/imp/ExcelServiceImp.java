package com.clay.system.service.imp;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.clay.system.model.enity.DrugStorage;
import com.clay.system.model.excel.*;
import com.clay.system.service.*;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author clay
 * @Email wandererchen.xyz@foxmail.com
 * @Blog www.wandererchen.xyz
 * @Date 2020/6/5 11:10
 * @Version 1.0
 *
 * Excel 导出服务实现
 * 依赖以下服务：
 * {@link DrugStorageService}
 * {@link RecordService}
 * {@link LogService}
 * {@link DetailsService}
 * {@link TypeCodeService}
 * {@link SupplierService}
 * {@link SellRecordService}
 * {@link SellRecordDetailsService}
 *
 * 实现接口：{@link ExcelService}
 */
@Slf4j
@Service
@AllArgsConstructor
public class ExcelServiceImp implements ExcelService
{
    private DrugStorageService storageService;

    private LogService logService;

    private RecordService recordService;

    private DetailsService detailsService;

    private TypeCodeService codeService;

    private SupplierService supplierService;

    private SellRecordService sellRecordService;

    private SellRecordDetailsService sellDetailsService;

    private DrugTimeOutService timeOutService;

    private UserService userService;

    /**
     * 产生药物采购报表的服务
     * @param response rep
     * @throws IOException e
     */
    @Override
    public void buildDrugPurchaseExcel(HttpServletResponse response) throws IOException {
        List<DrugPurchaseExcel>excelList=new LinkedList<>();
        recordService.queryAllRecord()
                .forEach(item->detailsService.queryByCode(item.getPurchaseCode())
                .forEach(detail->{
                    DrugPurchaseExcel excel=new DrugPurchaseExcel();
                    excel.setId(item.getId());
                    excel.setCreateTime(item.getTime());
                    excel.setOperationUser(item.getOperationUser());
                    excel.setPurchaseCode(item.getPurchaseCode());
                    excel.setTotalPrice(item.getTotalPrice());
                    excel.setTip(item.getTip());

                    //详情数据部分
                    excel.setDetailId(detail.getId());
                    excel.setDrugCode(detail.getDrugCode());
                    excel.setDrugNum(detail.getDrugNum());
                    excel.setSinglePrice(detail.getSinglePrice());
                    excel.setDetailsTotalPrice(detail.getTotalPrice());

                    excelList.add(excel);
                }));
        deal(response,"采购记录报表",excelList,DrugPurchaseExcel.class);
    }

    /**
     * 产生销售记录报表的服务
     * @param response rep
     * @throws IOException e
     */
    @Override
    public void buildDrugSellExcel(HttpServletResponse response) throws IOException {
        List<DrugSellExcel> excelList=new LinkedList<>();
        sellRecordService.getAllRecord()
                .forEach(item-> sellDetailsService.getByOrderCode(item.getOrderCode())
                        .forEach(detail->{
                            DrugSellExcel excel=new DrugSellExcel();
                            excel.setCreateTime(item.getCreateTime());
                            excel.setId(item.getId());
                            excel.setOperationUser(item.getOperationUser()); //这个字段还没持久化
                            excel.setOrderCode(item.getOrderCode());
                            excel.setTotalPrice(item.getTotalPrice());
                            //详情
                            excel.setDetailsId(detail.getId());
                            excel.setDrugCode(detail.getDrugCode());
                            excel.setDrugNum(detail.getDrugNum());
                            excel.setDrugPrice(detail.getDrugPrice());
                            excelList.add(excel);
                        }));
        deal(response,"销售记录报表",excelList,DrugSellExcel.class);
    }

    /**
     * 产生药物库存报表的服务
     * @param response rep
     * @throws IOException e
     */
    @Override
    public void buildDrugStorageExcel(HttpServletResponse response) throws IOException {
        List<DrugStorage> drugStorageList=storageService.getAll();
        List<DrugStorageExcel> excelList=new LinkedList<>();
        drugStorageList.forEach(item->{
            DrugStorageExcel excel=new DrugStorageExcel();
            excel.setCreateTime(item.getCreateTime());
            excel.setDescription(item.getDescription());
            excel.setDrugName(item.getDrugName());
            excel.setDrugCode(item.getDrugCode());
            excel.setDrugNum(item.getDrugNum());
            excel.setId(item.getId());
            excel.setSinglePrice(item.getSinglePrice());
            excel.setSupplierCode(item.getSupplier());
            excel.setDrugType(codeService.getByCodeId(item.getTypeCodeId()).getTypeName());
            excelList.add(excel);
        });
        deal(response,"药物库存报表",excelList,DrugStorageExcel.class);
    }

    /**
     * 产生供应商报表的服务
     * @param response rep
     * @throws IOException e
     */
    @Override
    public void buildDrugSupplierExcel(HttpServletResponse response) throws IOException {
        List<DrugSupplierExcel> excelList=new LinkedList<>();
        supplierService.getAll()
                .forEach(item->{
                    DrugSupplierExcel supplierExcel=new DrugSupplierExcel();
                    supplierExcel.setId(item.getId());
                    supplierExcel.setAddress(item.getAddress());
                    supplierExcel.setBrand(item.getBrand());
                    supplierExcel.setEmail(item.getEmail());
                    supplierExcel.setPhoneNum(item.getPhoneNum());
                    supplierExcel.setSupplierCode(item.getSupplierCode());
                    supplierExcel.setName(item.getName());
                    excelList.add(supplierExcel);
                });
        deal(response,"药物供应商报表",excelList,DrugSupplierExcel.class);
    }

    /**
     * 产生类型代码报表的服务
     * @param response rep
     * @throws IOException e
     */
    @Override
    public void buildDrugTypeCodeExcel(HttpServletResponse response) throws IOException {
        List<DrugTypeCodeExcel>excelList=new LinkedList<>();
        codeService.getAllTypeCode()
                .forEach(item->{
                    DrugTypeCodeExcel excel=new DrugTypeCodeExcel();
                    excel.setName(item.getTypeName());
                    excel.setTypeId(item.getId());
                    excel.setDescription(item.getDescription());
                    excelList.add(excel);
                });
        deal(response,"药物类型代码报表",excelList,DrugTypeCodeExcel.class);
    }

    /**
     * 日志报表服务
     * @param response rep
     * @throws IOException e
     */
    @Override
    public void buildLogExcel(HttpServletResponse response) throws IOException {
        List<LogExcel>excelList=new LinkedList<>();
        logService.getAllLog()
                .forEach(item->{
                    LogExcel excel=new LogExcel();
                    excel.setCreateTime(item.getCreateTime());
                    excel.setId(item.getId());
                    excel.setLog(item.getLogBody());
                    excel.setType(item.getLogType());
                    excelList.add(excel);
                });
        deal(response,"系统日志报表",excelList,LogExcel.class);
    }

    /**
     * 用户信息报表服务
     * @param response rep
     * @throws IOException e
     */
    @Override
    public void buildUserExcel(HttpServletResponse response) throws IOException {
        List<UserExcel>excelList=new LinkedList<>();
        userService.getAll()
                .forEach(item->{
                    UserExcel excel=new UserExcel();
                    excel.setName(item.getUserName());
                    excel.setEmail(item.getEmail());
                    excel.setStatus(item.getStatus()==1?"可用":"锁定");
                    excel.setDes(item.getDescription());
                    excelList.add(excel);
                });
        deal(response,"用户信息报表",excelList,UserExcel.class);
    }

    /**
     * 过期药物的报表服务
     * @param response rep
     * @throws IOException e
     */
    @Override
    public void buildTimeOutDrugExcel(HttpServletResponse response) throws IOException {
        List<DrugTimeOutExcel>excelList=new LinkedList<>();
        timeOutService.getAll()
                .forEach(item->{
                    DrugTimeOutExcel excel=new DrugTimeOutExcel();
                    excel.setDrugCode(item.getDrugCode());
                    excel.setDescription(item.getDescription());
                    excel.setDrugName(item.getDrugName());
                    excel.setId(item.getId());
                    excel.setTypeName(codeService.getByCodeId(item.getTypeCode()).getTypeName());
                    excel.setSinglePrice(item.getSinglePrice());
                    excel.setSupplierCode(item.getSupplierCode());
                    excelList.add(excel);
                });
        deal(response,"过期药品报表",excelList,DrugTimeOutExcel.class);
    }

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
    @Override
    public <T> void deal(HttpServletResponse response,String fileName,List<T>excelList,Class<T>clazz)
            throws IOException
    {
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("UTF-8");
        String file= URLEncoder.encode(fileName, StandardCharsets.UTF_8);
        response.setHeader("Content-disposition", "attachment;filename=" + file + ExcelTypeEnum.XLSX.getValue());

        EasyExcel.write(response.getOutputStream(),clazz)
                .sheet("报表")
                .doWrite(excelList);
    }
}
