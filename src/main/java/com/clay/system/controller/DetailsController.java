package com.clay.system.controller;

import com.clay.system.annotation.Description;
import com.clay.system.model.SystemResponse;
import com.clay.system.service.DetailsService;
import lombok.AllArgsConstructor;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author clay
 * @Email wandererchen.xyz@foxmail.com
 * @Blog www.wandererchen.xyz
 * @Date 2020/6/2 16:44
 * @Version 1.0
 *
 * 采购详情处理器
 * 目前只开放一个详情查询
 * 后期可能新增更新等操作
 *
 * 需要服务：{@link DetailsService}
 */
//@Slf4j
@RestController
@RequestMapping(value = "/api/details")
@AllArgsConstructor
public class DetailsController
{
    private DetailsService detailsService;

    /**
     * 主要用于前台通过查看记录简略后
     * 通过采购码获取详情
     * 需要权限：purchaseDetails:query
     * @param code 采购码
     * @return
     */
    @RequiresPermissions("purchaseDetails:query")
    @Description(description = "查询详情")
    @GetMapping(value = "/code/{code}")
    public SystemResponse getDetails(@PathVariable int code)
    {
        return new SystemResponse()
                .success()
                .message("ok")
                .data(detailsService.queryByCode(code));
    }

}
