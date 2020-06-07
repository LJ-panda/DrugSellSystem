<#--
   新增采购记录的表格，SPA 碎片
-->
<div id="part-record-div" class="div-id">

    <button class="btn btn-block btn-primary" onclick="add()">点击添加</button>
    <button class="btn btn-block btn-primary" onclick="postRecordToServer()">点击提交数据</button>
    <form>
        <table class="table table-striped"  id="record">
            <tr>
                <td colspan="4" align="center">
                    <font color="#D62516" size="6">采购信息</font>
                </td>
            </tr>
            <tr>
                <td>操作人：</td>
                <td colspan="3"><input type="text" id="operationUser" name="operationUser"  required="required"/></td>
            </tr>

            <tr>
                <td>备注：</td>
                <td colspan="3"><input type="text" id="tip" name="tip"  required="required"/></td>
            </tr>

            <tr>
                <td align="center" rowspan="*">药品信息</td>
                <td id="items" class="drug-info-table-container">
                    <!--
                    用于添加的这一段，直接通过ajax去后端获取该段代码的渲染值，然后赋值给js变量
                    -->

                    <#include "details.ftl"/>

                </td>
            </tr>



        </table>
    </form>
</div>