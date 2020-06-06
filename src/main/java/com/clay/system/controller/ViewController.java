package com.clay.system.controller;

import com.clay.system.annotation.Description;
import com.clay.system.model.DataType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

/**
 * @Author clay
 * @Email wandererchen.xyz@foxmail.com
 * @Blog www.wandererchen.xyz
 * @Date 2020/6/2 15:37
 * @Version 1.0
 *
 * 视图控制器
 * 为前端提供视图
 */
@Slf4j
@Validated
@Controller
@RequestMapping(value = "/view")
public class ViewController
{
    /**
     * 登陆页面
     * @return login.ftl
     */
    @Description(description = "登陆视图获取")
    @GetMapping(value = "/user/toLogin")
    public String toLogin()
    {
        return "login";
    }

    /**
     * 登陆成功后进入用户主页
     * @return  index.ftl
     */
    @Description(description = "用户主页视图获取")
    @GetMapping(value = "/user/index")
    public String toIndex()
    {
        return "index";
    }

    /**
     * 用于前端获取详情表格部分
     * 没毛病
     * @return
     */
    @Description(description = "药物采购详情表格获取")
    @GetMapping(value = "/part/details")
    public String details()
    {
        log.info("details请求");
        return "part/details";
    }

    /**
     * 获取采购记录基础表格
     * @return
     */
    @Description(description = "药物采购基础表格获取")
    @GetMapping(value = "/part/record")
    public String record()
    {
        return "part/record";
    }

    //测试
    @GetMapping(value = "/test")
    public String test()
    {
        return "testTable";
    }

    /**
     * 获取数据表格
     * 这个表格计划用来做数据报表的在线显示和查询
     * @return
     */
    @Description(description = "数据报表父表获取")
    @GetMapping(value = "/part/table")
    public String table()
    {
        return "part/pageTable";
    }


    /**
     * 供SPA 获取库存扣减表格
     * @return
     */
    @Description(description = "销售扣减表格获取")
    @GetMapping(value = "/part/sellTable")
    public String sellTable()
    {
        return "part/sellTable";
    }


    /**
     * 供SPA用户添加
     * @return
     */
    @Description(description = "用户添加表格获取")
    @GetMapping(value = "/part/user")
    public String getUserAdd()
    {
        return "part/userAdd";
    }
    /**
     * 供前端获取各个数据表的自己的数据报表表格
     * @param type
     * @param model
     * @return
     */
    @Description(description = "数据报表表格生成")
    @GetMapping(value = "/part/dataTable/{type}")
    public String getDataTable(@PathVariable @PositiveOrZero(message = "必须大于0") int type, Model model)
    {
       switch (type)
       {
           case 0:
               model.addAttribute("type",0);
               model.addAttribute("msg","日志表格");
               break;
           case 1:
               model.addAttribute("type",1);
               break;
           case 2:
               model.addAttribute("type",2);
               break;
           case 3:
               model.addAttribute("type",3);
               break;
           case 4:
               model.addAttribute("type",4);
               break;
           case 5:
               model.addAttribute("type",5);
               break;
       }
       return "part/dataShowTable";
    }


}
