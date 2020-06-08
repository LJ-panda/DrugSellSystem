<#--
   用户添加表格碎片
   其中的js放 buttonsrc.ftl
-->
<div id="part-userAdd-div" class="div-id">

    <table class="table table-striped" border="3px"  id="sellRecord">
        <thead>
        <tr>
            <td rowspan="*">用户添加表单</td>
            <td>属性</td>
            <td>值</td>
        </tr>
        </thead>

        <tr>
            <td rowspan="3">
                <a class="btn btn-primary" href="" onclick="addUserToServer()">点击添加用户</a>
            </td>
            <td>名称：</td>
            <td><input type="text" id="user_name" name="user_name" required="required"/></td>
        </tr>
        <tr>

            <td>邮箱：</td>
            <td><input type="email" id="user_email" name="user_email" required="required"/></td>
        </tr>


        <tr>

            <td>状态：</td>
            <td>
                <select id="user_status" >
                    <option value="1" selected="selected">可用</option>
                    <option value="-1">禁用</option>
                </select>
            </td>
        </tr>

        <tr>
            <td rowspan="2"></td>
            <td>密码：</td>
            <td><input type="password" id="user_pwd" required="required"/></td>
        </tr>
        <tr>

            <td>确认密码：</td>
            <td><input type="password" id="user_pwd2" required="required"/></td>
        </tr>


        <tr>
            <td></td>
            <td>描述：</td>
            <td><input type="text" id="user_des" name="user_des" required="required"></td>
        </tr>

        <tr>
            <td rowspan="*"><a class="btn btn-primary" href="" id="user_level_btn" onclick="clickAddPermission()">点击添加权限</a></td>
            <td rowspan="*">
                <span>权限:</span>
                <select id="user_level" onclick="queryAndSetPer()">
                    <option value="-1">待选择</option>
                </select>
            </td>
            <td id="user_per">

            </td>
        </tr>

    </table>

</div>