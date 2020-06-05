<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title></title>
		<meta charset="utf-8">
		  <meta name="viewport" content="width=device-width, initial-scale=1">
		
		<!-- 新 Bootstrap4 核心 CSS 文件 -->
		<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/css/bootstrap.min.css">
		 
		<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
		<script src="${springMacroRequestContext.contextPath}/js/jquery-3.4.1.js"></script>
		 
		<!-- bootstrap.bundle.min.js 用于弹窗、提示、下拉菜单，包含了 popper.min.js -->
		<script src="https://cdn.staticfile.org/popper.js/1.15.0/umd/popper.min.js"></script>
		 
		<!-- 最新的 Bootstrap4 核心 JavaScript 文件 -->
		<script src="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>
			
		<script>

			/*
			 *
			 * 核心js
			 * 主要用于点击添加药物信息
			 */

			var detailTable=null;   //缓存详情表的部分h5数据

			function add()
			{
				if (detailTable==null)
				{
					let url="${springMacroRequestContext.contextPath}/view/part/details";
					$.get(url,function(data){
						detailTable=data;
						$("#items").append(data);
					});
				}
				else
				{
					$("#items").append(detailTable);
				}
			}

			var code=null;   //缓存后端传递的typecode
			/*
			 *
			 * 获取typeCode
			 * 并缓存
			 */

			function getTypeCode()
			{
				let url="${springMacroRequestContext.contextPath}/api/typecode/query";
				if (code==null)
				{
					$.get(url,function (data) {
						console.log("data:"+data);
						code=data.data;
						handlerIt(code);
					});
				}
				else
				{
					handlerIt(code);
				}
			}

			/**
			 * 该段js主要处理新增的item的option
			 * @param code
			 */
			function handlerIt(code)
			{
				let els=document.getElementsByClassName("typeCode");
				for (j=0;j<els.length;j++)
				{
					if (!els[j].classList.contains("added"))
					{
						for (i=0;i<code.length;i++)
						{
							let str=code[i].id+":"+code[i].typeName;
							let ael=document.createElement("option");
							ael.text=str;
							els[j].appendChild(ael);
						}
					}
					els[j].classList.add("added");
				}
			}
		</script>
	</head>
	<body>
		<button class="btn btn-block btn-primary" onclick="add()">点击添加</button>
		<form>
			<table class="table table-striped"  id="record">
				<tr>
					<td colspan="4" align="center">
						<font color="#D62516" size="6">采购信息</font>
					</td>
				</tr>
				<tr>
					<td>操作人：</td>
					<td colspan="3"><input type="text" id="operationUser" name="operationUser"/></td>
				</tr>
				
				<tr>
					<td>备注：</td>
					<td colspan="3"><input type="text" id="tip" name="tip"/></td>
				</tr>
				
				<tr>
					<td align="center" rowspan="*">药品信息</td>
					<td id="items">
						<!--
						用于添加的这一段，直接通过ajax去后端获取该段代码的渲染值，然后赋值给js变量
						-->
						<#include "common/details.ftl"/>
					</td>
				</tr>
				
				
							
			</table>
		</form>
		
	</body>
</html>