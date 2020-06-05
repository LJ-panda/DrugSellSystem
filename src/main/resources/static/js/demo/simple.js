/**
 * 样本js
 */
function postRecord()
{
    let dataModel={
        tip:"备注信息",
        //purchaseCode:"采购码，后端会进行hash",
        //time:"后端会生成",
        drugs:[
            {
                //id:"药物id",
                drugName:"药物名",
                drugNum:10,
                singlePrice:15,
                typeCode:1,
                description:"描述",
                suppliersInfo:{
                    name:"供应商01",
                    brand:"商标01",
                    phoneNum:"1234567",
                    email:"254565444@qq.com",
                    address:"四川成都"
                    //supplierCode:""
                }
            },
            {
                //id:"药物id2",
                drugName:"药物名2",
                drugNum:10,
                singlePrice:15,
                typeCode:1,
                description:"描述2",
                suppliersInfo:{
                    name:"供应商02",
                    brand:"商标02",
                    phoneNum:"12345678",
                    email:"254565444@qq.com",
                    address:"四川成都"
                    //supplierCode:""
                }
            }
        ]
    };

    console.log("data:"+JSON.stringify(dataModel));

    let  postUrl="${springMacroRequestContext.contextPath}/api/record/add";
    $.ajax({
        url:postUrl,
        type:"post",
        data:JSON.stringify(dataModel),      // 对象数组
        contentType: "application/json;charset=UTF-8",
        dataType:"json",
        success:function (data) {
            console.log("响应："+data);
        }
    });
}

