package com.clay.system.controller;

import com.clay.system.annotation.Description;
import com.clay.system.model.SystemResponse;
import com.clay.system.model.enity.DrugTypeCode;
import com.clay.system.service.TypeCodeService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;

/**
 * @Author clay
 * @Email wandererchen.xyz@foxmail.com
 * @Blog www.wandererchen.xyz
 * @Date 2020/6/2 16:49
 * @Version 1.0
 *
 * 药物类型代码控制器
 * 主要用于类型代码查询等
 * 需要服务：{@link TypeCodeService}
 */
@Slf4j
@Validated
@RestController
@RequestMapping(value = "/api/typecode")
@AllArgsConstructor
public class TypeCodeController
{
    private TypeCodeService codeService;

    /**
     * 获取所有类别代码
     * 需要权限：typeCode:query
     * @return
     */
    @RequiresPermissions("typeCode:query")
    @Description(description = "获取所有类别代码")
    @GetMapping(value = "/query")
    public SystemResponse queryAll()
    {
        return new SystemResponse()
                .success()
                .message("ok")
                .data(codeService.getAllTypeCode());
    }

    /**
     * 新增类别码
     * 需要权限：typeCode:insert
     * @param code code
     */
    @RequiresPermissions("typeCode:insert")
    @Description(description = "新增类别代码")
    @PostMapping(value = "/add")
    public SystemResponse add(@Validated DrugTypeCode code)
    {
        codeService.saveAType(code);
        return new SystemResponse()
                .success()
                .message("ok")
                .data(codeService.getAllTypeCode());
    }

    /**
     * 通过id删除类别码
     * 然后返回新数据
     * 需要权限：typeCode:delete
     * @param id id
     * @return
     */
    @RequiresPermissions("typeCode:delete")
    @Description(description = "通过Id删除")
    @GetMapping(value = "/del/{id}")
    public SystemResponse del(@Positive(message = "id必须大于0")
                                  @PathVariable int id)
    {
        int r=codeService.delById(id);
        return new SystemResponse()
                .code(HttpStatus.ACCEPTED)
                .message("just do it")
                .data(r==1?codeService.getAllTypeCode():null);
    }

    /**
     * 成功更新后返回新的数据
     * 需要权限：typeCode:update
     * @param code code
     * @return
     */
    @RequiresPermissions("typeCode:update")
    @Description(description = "更新类别码")
    @PostMapping(value = "/update")
    public SystemResponse update(@Validated DrugTypeCode code)
    {
        int r=codeService.updateById(code);
        return new SystemResponse()
                .code(HttpStatus.ACCEPTED)
                .message("just do it")
                .data(r==1?codeService.getAllTypeCode():null);
    }

}
