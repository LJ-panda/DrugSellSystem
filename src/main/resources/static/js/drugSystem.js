/**
 * 抽离出来会导致报错
 */
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

/**
 * 发送整理的采购记录数据到后端
 *
 */
function postRecordData() {
    let postUrl="${springMacroRequestContext.contextPath}/api/record/add";
    let recordData=getData();
    if (recordData==null)
    {
        return;
    }
    console.log("data:"+JSON.stringify(recordData));
    $.ajax({
        url:postUrl,
        type:"post",
        data:JSON.stringify(recordData),      // 对象数组
        contentType: "application/json;charset=UTF-8",
        dataType:"json",
        success:function (data) {
            console.log("响应："+data);
        }
    });

}

/**
 * 整理页面的数据
 * @returns {{drugs: [], tip: (*|jQuery|HTMLElement), operationUser: (*|jQuery|HTMLElement)}}
 */
function getData()
{
    let operationUser=$("#operationUser").val();
    let tip=$("#tip").val();
    let els=document.getElementsByClassName("drug-table");
    let drugs=[];

    let i;
    for (i=0;i<els.length;i++)
    {
        let drugName=els[i].getElementsByClassName("drugName")[0].value;
        let drugNum=els[i].getElementsByClassName("drugNum")[0].value;
        let singlePrice=els[i].getElementsByClassName("singlePrice")[0].value;
        let typeCode=els[i].getElementsByClassName("typeCode")[0].value;
        let description=els[i].getElementsByClassName("description")[0].value;

        //供应商数据
        let supplier_name=els[i].getElementsByClassName("supplier_name")[0].value;
        let supplier_brand=els[i].getElementsByClassName("supplier_brand")[0].value;
        let supplier_phoneNum=els[i].getElementsByClassName("supplier_phoneNum")[0].value;
        let supplier_email=els[i].getElementsByClassName("supplier_email")[0].value;
        let supplier_address=els[i].getElementsByClassName("supplier_address")[0].value;

        if (!(drugName.length!==0&&drugNum!==0&&singlePrice!==0&&typeCode.length!==0&&description.length!==0&&
            supplier_name.length!==0&&supplier_brand.length!==0&&supplier_phoneNum.length!==0&&supplier_email.length!==0&&supplier_address.length!==0))
        {
            alert("<h2 class='alert'>请按要求填写完表格的所有数据</h2>");
            return null;
        }
        let aDrug={
            drugName:drugName,
            drugNum:drugNum,
            singlePrice:singlePrice,
            typeCode:typeCode.split(":")[0],
            description:description,
            suppliersInfo:{
                name:supplier_name,
                brand:supplier_brand,
                phoneNum:supplier_phoneNum,
                email:supplier_email,
                address:supplier_address
            }
        };
        drugs.push(aDrug);
    }

    return {
        tip: tip,
        operationUser: operationUser,
        drugs: drugs
    };
}