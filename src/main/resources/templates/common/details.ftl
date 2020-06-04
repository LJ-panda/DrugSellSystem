<!--item start-->
<table class="table table-striped" border="3px">
    <tr>
        <td>药物名称：</td>
        <td colspan="2"><input type="text" name="drugName" id="drugName" required="required"/></td>
    </tr>

    <tr>
        <td>采购数：</td>
        <td colspan="2"><input type="text" name="drugNum" id="drugNum" required="required"/></td>
    </tr>

    <tr>
        <td>单价：</td>
        <td colspan="2"><input type="text" id="singlePrice" name="singlePrice" required="required"/></td>
    </tr>

    <tr>
        <!--通过点击事件异步加载-->
        <td>类型代码：</td>
        <td colspan="2">
            <select class="typeCode" name="typeCode" onclick="getTypeCode()">
                <option>无</option>
            </select>
        </td>
    </tr>

    <tr>
        <td>采购描述：</td>
        <td colspan="2"><input type="text" id="description" name="description"/></td>
    </tr>

    <tr class="supplierInfo">
        <td rowspan="6">供应商信息：</td>
        <td colspan="2">
    <tr>
        <td>名称：</td>
        <td><input type="text" id="name" name="name"/></td>
    </tr>
    <tr>
        <td>商标：</td>
        <td><input type="text" id="brand" name="brand"/></td>
    </tr>

    <tr>
        <td>电话：</td>
        <td><input type="tel" id="phoneNum" name="phoneNum"/></td>
    </tr>

    <tr>
        <td>邮箱：</td>
        <td><input type="email" id="email" name="email"/></td>
    </tr>

    <tr>
        <td>地址：</td>
        <td><input type="text" id="adress" name="adress"/></td>
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