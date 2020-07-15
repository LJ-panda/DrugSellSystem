# 药物销售管理系统
### 作者博客：[手可摘星辰](https://www.wandererchen.xyz)
### 简介
>- 涉及技术
>>Spring、Spring Boot、Spring MVC、Spring Data Jpa、MyBatis、Shiro、MySQL、H2、FreeMarker、JQuery、Bootstarp等。
>>- 项目采用 Spring Boot 进行快速搭建。
>>- 使用安全框架 Shiro 实现认证和授权操作。
>>- 开发阶段采用 MySQL 作为数据库、开发完毕使用 H2 作为数据库，分别对应配置文件 dev 和 pro 两个。
>>- 视图技术为 FreeMarker 模板引擎技术，提供页面碎片渲染支持。
>>- 项目使用 Jpa 在启动时建表和初始化数据库、然后所有的数据持久化和查询、更新等使用 MyBatis。


### 系统简要说明
>- 用户说明:
>>系统初始化时只会初始化以下用户，需要增加用户请自行添加和授权！

|用户|密码|说明|权限|
|-------|-------|-------|-------|
|wandererchen@foxmail.com|123456789|开发者、超级管理员|最高，即*|
|123456@qq.com|123456789|拥有用户权限|user:*|
|456789@qq.com|123456789|类型码相关管理|typeCode:*|
>- 密码说明：
>>添加用户时，密码不得少于10位，具体要求效验规则会返回。
### 功能简介
>- #### 用户的新增和授权
>>- 已实现
>>- ***存在的问题，没有对权限进一步处理，应该增加避免越权授权的问题。***
>- #### 药物采购数据
>>- 药物采购记录增加已实现，但是界面的一些js操作还是有些不足。
>- #### 库存扣减
>>- 简陋的实现了模拟了用户扣减库存的操作，有待优化。
>- #### 数据查询
>>- 设计了通过下拉列表动态显示数据的表格，所有基础表格都是在第一次下拉的时候选中通过 ajax 到后端异步获取的，以后再选中则只通过 ajax 异步更新数据。
>>- 表格的展示主要通过 JQuery 或者单纯的 js DOM 操作进行表格的 show()、hide()。
>- #### 数据报表生成
>>- 项目引入了阿里的 EasyExcel 开源项目实现了 Excel 报表的生成，然后提供了报表服务。
>- #### 单页化(SPA)
>>- 本次的一大特色，实现了单业应用(SPA)，以下是项目中 SPA 核心代码
```js
/**
     * 核心 SPA 代码
     * @type {*[]}   存储请求的碎片id和hash组合值
     */
    var hashSet=[];
    function hashChageFun()
    {
      let hash=window.location.hash.toString();
      hash=hash.substr(1,hash.length-1);
      let baseUrl="${springMacroRequestContext.contextPath}/view/part/";
      let flag=false;
      for (i=0;i<hashSet.length;i++)
      {
        if (hashSet[i].split("@")[0]===hash)
        {
          $("#"+hashSet[i].split("@")[1]).show();
          flag=true;
        }
        else
        {
          $("#"+hashSet[i].split("@")[1]).hide();
        }
      }
      if (!flag&&hash.length!==0)
      {
        console.log("请求Url："+baseUrl+hash);
        $.get(baseUrl+hash,function (data) {
          $("#father-div").append(data);
          hashSet.push(hash+"@"+data.substr(data.indexOf("id=\"")+4,data.indexOf(" class")-10).trim());
          console.log("id列表："+JSON.stringify(hashSet));
        });
      }}
```
### 设计的一些细节
>- 采购记录怎么存的？ 
>>每次采购后，进行药物库存修改？采购记录写入？也就是说，药品库存的增加，必须走采购记录服务
>- 关于药物代码的问题：
>>药物代码是使用的 vo 中的 Drug 对象的 hashCode ，抛开了它的状态属性（时间）。解决的库存中同种药品的重复插入问题。
>- 等等后面再写
***
### 待增加功能

>- 数据显示的表格页面，分页丢失，分页式基于id和class实现的
>>待解决
>>最新发现，需要结合具体的表格

