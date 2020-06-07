package com.clay.system.controller;

import com.clay.system.annotation.Description;
import com.clay.system.exception.DrugSystemException;
import com.clay.system.model.SystemResponse;
import com.clay.system.model.enity.SellRecord;
import com.clay.system.model.vo.VoOrder;
import com.clay.system.service.SellRecordDetailsService;
import com.clay.system.service.SellRecordService;
import com.clay.system.utils.ConvertUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @Author clay
 * @Email wandererchen.xyz@foxmail.com
 * @Blog www.wandererchen.xyz
 * @Date 2020/6/4 23:33
 * @Version 1.0
 *
 * 用于记录库存扣减的情况
 * 用于查询和插入库存扣减情况
 */
@Slf4j
@RestController
@RequestMapping(value = "/api/sell")
@AllArgsConstructor
public class SellRecordController
{
    private SellRecordService recordService;

    private SellRecordDetailsService detailsService;

    /*
    {
  "totalPrice": 15,
  "details": [
    {"drugCode": "code","drugNum": "数量","drugPrice": "price"},
    {"drugCode": "code02","drugNum": "数量2","drugPrice": "price"}
  ]
}
     */

    /**
     * 暴露对外的销售接口
     * 需要权限：order:insert
     * @param order order
     * @return
     * @throws DrugSystemException
     */
    @RequiresPermissions("order:insert")
    @Description(description = "销售信息存储接口")
    @PostMapping(value = "/add")
    public SystemResponse add(@Validated
                                  @RequestBody VoOrder order) throws DrugSystemException {
        log.info("order:{}",order);
        SellRecord record= ConvertUtils.buildRecordByVo(order);
        recordService.saveRecord(record);
        return new SystemResponse()
                .message("ok")
                .success()
                .data(null);
    }

    /**
     * 获取详情
     * @param orderCode orderCode
     * @return
     */
    @RequiresPermissions("order:query")
    @Description(description = "详情查询")
    @GetMapping(value = "/queryDetails/{orderCode}")
    public SystemResponse queryDetails(@PathVariable int orderCode)
    {
        return new SystemResponse()
                .success()
                .message("ok")
                .data(detailsService.getByOrderCode(orderCode));
    }

    /**
     * 查询所有库存扣减情况
     * @return
     */
    @RequiresPermissions(value = "order:query")
    @GetMapping(value = "/queryAll")
    public SystemResponse queryAll()
    {
        return new SystemResponse()
                .success()
                .message("ok")
                .data(recordService.getAllRecord());
    }

}
