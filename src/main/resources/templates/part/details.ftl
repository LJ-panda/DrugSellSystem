<!--item start-->
<#--
通过class属性来确定找出字段，避免多id的冲突
-->
<table class="table table-striped drug-table" border="3px">
    <tr>
        <td>药物名称：</td>
        <td colspan="2"><input type="text" name="drugName" class="drugName" required="required"/></td>
    </tr>

    <tr>
        <td>可用时间：</td>
        <td colspan="2"><input type="date" name="canUseTime" class="canUseTime" required="required"></td>
    </tr>
    <tr>
        <td>采购数：</td>
        <td colspan="2"><input type="text" name="drugNum" class="drugNum" required="required"/></td>
    </tr>

    <tr>
        <td>单价：</td>
        <td colspan="2"><input type="text" name="singlePrice" class="singlePrice" required="required"/></td>
    </tr>

    <tr>
        <!--通过点击事件异步加载-->
        <td>类型代码：</td>
        <td colspan="2">
            <select name="typeCode" class="typeCode" onclick="getTypeCode()">
                <option>无</option>
            </select>
        </td>
    </tr>

    <tr>
        <td>采购描述：</td>
        <td colspan="2"><input type="text" name="description" class="description"  required="required"/></td>
    </tr>

    <tr class="supplierInfo">
        <td rowspan="6">供应商信息：</td>
        <td colspan="2">
    <tr>
        <td>名称：</td>
        <td><input type="text" class="supplier_name" name="name"   required="required"/></td>
    </tr>
    <tr>
        <td>商标：</td>
        <td><input type="text" class="supplier_brand" name="brand"   required="required"/></td>
    </tr>

    <tr>
        <td>电话：</td>
        <td><input type="tel" class="supplier_phoneNum" name="phoneNum"   required="required"/></td>
    </tr>

    <tr>
        <td>邮箱：</td>
        <td><input type="email" class="supplier_email" name="email"  required="required"/></td>
    </tr>

    <tr>
        <td>地址：</td>
        <td><input type="text" class="supplier_address" name="adress"  required="required"/></td>
    </tr>
        </td>
    </tr>

    <tr>
        <td colspan="3">
            <hr style="height:5px;border:none;border-top:5px ridge green;" />
        </td>
    </tr>
</table>
<!--item end-->