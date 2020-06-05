<#--
js获取后增加 data-table-mine-+类型的class 用于标识
-->
<table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
    <thead>
    <tr>
        <#if type=0>
            <th>ID</th>
            <th>日志类型</th>
            <th>时间</th>
            <th>日志</th>
        <#elseif type=1>
            <#--库存-->
            <th>ID</th>
            <th>药物代码</th>
            <th>药物名</th>
            <th>药物余量</th>
            <th>单价</th>
            <th>入库时间</th>
            <th>药物类型</th>
            <th>供应商代码</th>
            <th>药物简介</th>
        <#elseif type=2>
            <th>药物类型代码</th>
            <th>类型名</th>
            <th>简介</th>
        <#elseif type=3>
            <th>ID</th>
            <th>供应商名</th>
            <th>供应商代码</th>
            <th>商标</th>
            <th>联系电话</th>
            <th>邮箱</th>
            <th>地址</th>
        <#elseif type=4>
            <th>ID</th>
            <th>采购时间</th>
            <th>采购人</th>
            <th>采购代码</th>
            <th>总开支</th>
            <th>小记</th>
            <th>操作</th>
        <#elseif type=5>
            <th>ID</th>
            <th>交易时间</th>
            <th>操作人</th>
            <th>单号代码</th>
            <th>总价</th>
            <th>详情</th>
        </#if>
    </tr>
    </thead>
    <tfoot>
    <tr>
            <#if type=0>
                    <th>ID</th>
                    <th>日志类型</th>
                    <th>时间</th>
                    <th>日志</th>
            <#elseif type=1>
            <#--库存-->
                    <th>ID</th>
                    <th>药物代码</th>
                    <th>药物名</th>
                    <th>药物余量</th>
                    <th>单价</th>
                    <th>入库时间</th>
                    <th>药物类型</th>
                    <th>供应商代码</th>
                    <th>药物简介</th>
            <#elseif type=2>
                    <th>药物类型代码</th>
                    <th>类型名</th>
                    <th>简介</th>
            <#elseif type=3>
                    <th>ID</th>
                    <th>供应商名</th>
                    <th>供应商代码</th>
                    <th>商标</th>
                    <th>联系电话</th>
                    <th>邮箱</th>
                    <th>地址</th>
            <#elseif type=4>
                    <th>ID</th>
                    <th>采购时间</th>
                    <th>采购人</th>
                    <th>采购代码</th>
                    <th>总开支</th>
                    <th>小记</th>
                    <th>操作</th>
            <#elseif type=5>
                    <th>ID</th>
                    <th>交易时间</th>
                    <th>操作人</th>
                    <th>单号代码</th>
                    <th>总价</th>
                    <th>详情</th>
            </#if>
    </tr>
    </tfoot>
    <tbody>
    </tbody>
</table>