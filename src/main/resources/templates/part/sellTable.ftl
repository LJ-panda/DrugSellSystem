<#--
 销售扣减界面
-->
<div id="part-sell-div" class="div-id">
    <button class="btn btn-block btn-primary" onclick="addDrugTr()">点击添加药品</button>
    <button class="btn btn-primary btn-block" onclick="postSellData()">交易以下药物</button>


    <table class="table table-striped"  id="sellRecord">
        <tr>
            <td colspan="4" align="center">
                <font color="#D62516" size="6">销售</font>
            </td>
        </tr>

        <tr>
            <td align="center" rowspan="*">药品信息</td>
            <td colspan="2" id="addHere">
                <table class="table table-striped" id="drug-info-sell">
                    <thead>
                    <tr>
                        <th>代码:名称:库存:单价</th>
                        <th>购买数量</th>
                    </tr>
                    </thead>

                    <#--   直接点击添加,不要这个
                    <tr class="sell-drug-item">
                        <td >
                            <select class="drug-list" onclick="getData(this)">
                                <option value="-1">code:name:num:price</option>
                            </select>
                        </td>
                        <td>
                            <input type="text" required="required" class="sell-drug-num" />
                        </td>
                    </tr>
                    -->
                </table>
            </td>
        </tr>



    </table>
</div>