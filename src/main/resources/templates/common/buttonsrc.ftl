<!-- Bootstrap core JavaScript-->
<#--
<script src="${springMacroRequestContext.contextPath}/vendor/jquery/jquery.min.js"></script>
-->
<script src="${springMacroRequestContext.contextPath}/js/jquery-3.4.1.js"></script>
<script src="${springMacroRequestContext.contextPath}/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Core plugin JavaScript-->
<script src="${springMacroRequestContext.contextPath}/vendor/jquery-easing/jquery.easing.min.js"></script>

<!-- Custom scripts for all pages-->
<script src="${springMacroRequestContext.contextPath}/js/sb-admin-2.min.js"></script>

<!-- Page level plugins -->
<script src="${springMacroRequestContext.contextPath}/vendor/datatables/jquery.dataTables.min.js"></script>
<script src="${springMacroRequestContext.contextPath}/vendor/datatables/dataTables.bootstrap4.min.js"></script>

<!-- Page level custom scripts -->
<script src="${springMacroRequestContext.contextPath}/js/demo/datatables-demo.js"></script>

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
                alert("请按要求填写完表格的所有数据");
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


    /**
     * 用于用户选择数据类型的响应函数
     * 根据类型获取表格
     * @type {*[]}
     */

    var dataTableClassSet=[];
    function choiceDataType()
    {
        let baseUrl="${springMacroRequestContext.contextPath}/view/part/dataTable/";
        let el=document.getElementById("choice");
        console.log("choice:"+el.value);
        let elVal=el.value;


        if (Number.parseInt(elVal)>-1)
        {
            $("#choice-val").val(elVal);

            changeExcelUrl(elVal);  //该变url
            let flag=false;
            let i;
            console.log("classSet01:"+JSON.stringify(dataTableClassSet));
            for (i=0;i<dataTableClassSet.length;i++)
            {
                let className="data-table-mine-"+elVal;
                console.log("寻找class："+className+"-----当前："+dataTableClassSet[i].toString());
                if (dataTableClassSet[i].toString()==="data-table-mine-"+elVal)
                {
                    console.log("show节点：data-table-mine-"+elVal.toString());
                    $("."+dataTableClassSet[i].toString()).show();
                    $("."+dataTableClassSet[i].toString()).attr("id","dataTable");

                    //清空旧表数据，自动刷新
                    $(".data-table-mine-"+elVal+" tbody").empty();
                    getDataByType(elVal);
                    flag=true;
                }
                else
                {
                    console.log("hide节点：data-table-mine-"+elVal.toString());
                    $("."+dataTableClassSet[i].toString()).hide();
                    $("."+dataTableClassSet[i].toString()).attr("id","dataTable-none");
                }
            }

            if (!flag)
            {
                baseUrl=baseUrl+elVal;
                $.get(baseUrl,function (data) {
                    //data.replace("class=\"table table-bordered\"","class=\"table table-bordered data-table-mine-"+elVal+"\"");
                    data=data.substring(0,data.indexOf("\"")+1)+"data-table-mine-"+elVal+" "+data.substring(data.indexOf("\"")+1,data.length);
                    dataTableClassSet.push("data-table-mine-"+elVal);
                    console.log("classSet2:"+JSON.stringify(dataTableClassSet));
                    $(".table-data-container").append(data);
                    getDataByType(elVal);
                });
            }
        }
        else
        {
            $("#excel-btn").attr("href","");
            $("#excel-btn").hide();
        }
    }


    /*
     * 手动刷新页面数据
     */
    function flushData()
    {
        console.log("flush-data:"+$("#choice-val").val());
        //清除对应表下 tbody的tr
        $(".data-table-mine-"+$("#choice-val").val()+" tbody").empty();
        //通过隐藏字段来获取值
        getDataByType($("#choice-val").val());
    }


    function getDataByType(type) {
        //调用别的函数
        logData(type);
    }
    function logData(type)
    {
        let url=null;
        console.log("typeValue="+type);
        switch (type)
        {
            case "0":
                url="${springMacroRequestContext.contextPath}/api/log/query";
                break;
            case "1":
                url="${springMacroRequestContext.contextPath}/api/storage/query";
                //console.log("switch_1");
                break;
            case "2":
                url="${springMacroRequestContext.contextPath}/api/typecode/query";
                //console.log("switch_2");
                break;
            case "3":
                url="${springMacroRequestContext.contextPath}/api/supplier/query";
                //console.log("switch_3");
                break;
            case "4":
                url="${springMacroRequestContext.contextPath}/api/record/query";
                //console.log("switch_4");
                break;
            case "5":
                url="${springMacroRequestContext.contextPath}/api/sell/queryAll"
        }
        console.log("请求Url："+url);
        $.get(url,function (data) {
            if (data.code==='OK')
            {
                data=data.data;
                console.log("响应数据："+data);
                //let fatherEl=document.getElementsByClassName("data-table-mine-"+type);
                for (i=0;i<data.length;i++)
                {
                    let el = "<tr>";
                    for (let k of Object.keys(data[i]))
                    {
                        let str=data[i][k];
                        if (str==null)
                        {
                            continue;
                        }
                        el=el+"<td>"+str.toString()+"</td>";
                        console.log(k+":"+data[i][k].toString());
                    }
                    el=el+"</tr>";
                    console.log("el:"+el);
                    console.log("class是:"+"data-table-mine-"+type);
                    $(".data-table-mine-"+type+" tbody").append(el);
                }
            }
        })
    }

    /*
     * 选择后修改 excel 导出的url
     */
    function changeExcelUrl(type)
    {
        console.log("excel_type="+type);
        let excelUrl="${springMacroRequestContext.contextPath}/api/excel/";
        switch (type)
        {
            case "0":
                excelUrl=excelUrl+"log";
                break;
            case "1":
                excelUrl=excelUrl+"drugStorage";
                break;
            case "2":
                excelUrl=excelUrl+"typeCode";
                break;
            case "3":
                excelUrl=excelUrl+"suppliers";
                break;
            case "4":
                excelUrl=excelUrl+"purchaseRecord";
                break;
            case "5":
                excelUrl=excelUrl+"sellRecord";
                break;
            default:
                excelUrl="#";
        }
        console.log("excelUrl="+excelUrl);
        $("#excel-btn").show();
        $("#excel-btn").attr("href",excelUrl);
    }


</script>



<#--
    专供药物销售调用
-->
<script>

    /**
     * 添加药物行
     */
    function addDrugTr()
    {
        let htmlStr="<tr class=\"sell-drug-item sell-drug-item-stamp\"><td ><select class=\"drug-list\" onclick=\"getData()\"><option value=\"-1\">code:name:num:price</option></select></td><td><input type=\"text\" required=\"required\" class=\"sell-drug-num\"/></td></tr>";

        $("#drug-info-sell").append(htmlStr);

    }


    var GLOBAL_DATA=null;
    var DEALED_CLASS=[];
    function getData(){
        let drugUrl="http://localhost:8090/drugSystem/api/storage/query";
        if(GLOBAL_DATA==null)
        {
            $.get(drugUrl,function(data){
                if(data.code==="OK")
                {
                    data=data.data;
                    GLOBAL_DATA=data;
                    for(i=0;i<GLOBAL_DATA.length;i++)
                    {
                        let newEl="<option value=\""+GLOBAL_DATA[i].id+"\">"+GLOBAL_DATA[i].drugCode+":"+GLOBAL_DATA[i].drugName+":"+GLOBAL_DATA[i].drugNum+":"+GLOBAL_DATA[i].singlePrice+"</option>";
                        $(".drug-list").append(newEl);
                    }
                    $(".drug-list").addClass("drug-item");
                }
            });
        }
        else
        {
            let els=document.getElementsByClassName("drug-list");
            for(i=0;i<els.length;i++)
            {
                if(!els[i].classList.contains("drug-item"))
                {
                    for(i=0;i<GLOBAL_DATA.length;i++)
                    {
                        let newEl="<option value=\""+GLOBAL_DATA[i].id+"\">"+GLOBAL_DATA[i].drugCode+":"+GLOBAL_DATA[i].drugName+":"+GLOBAL_DATA[i].drugNum+":"+GLOBAL_DATA[i].singlePrice+"</option>";
                        $(".drug-list").append(newEl);
                    }
                    $(".drug-list").addClass("drug-item");
                }
            }

        }
    }


    function postSellData()
    {
        let operationUser=$("#sellRecord #operationUser").val();
        let tip=$("#sellRecord #tip").val();
        let items=document.getElementsByClassName("sell-drug-item");
        var drugDetails=[];
        let i;
        for (i=0;i<items.length;i++)
        {
            let item=items[i];
            let itemVal=item.getElementsByClassName("drug-list")[0];
            // if (itemVal.innerText==="code:name:num:price"||itemVal.value===-1)
            // {
            //     alert("请填写完数据");
            //     return;
            // }
            //alert(itemVal.innerText.toString());
            console.log("itemVal:"+itemVal.innerText);

            let targetStr=itemVal.options[itemVal.selectedIndex].text.split(":");
            //alert("目标数据："+targetStr.toString());
            for (j=0;j<targetStr.length;j++)
            {
                console.log("val_"+j+"_:"+targetStr[j]);
            }
            let drugCode=targetStr[0];
            let drugPrice=targetStr[3];
            let getNumDrug=item.getElementsByClassName("sell-drug-num")[0].value;

            if (getNumDrug>targetStr[2])
            {
                alert("该单销售超量！");
                return;
            }
            let itemData={
                drugCode:drugCode,
                drugNum:getNumDrug,
                drugPrice:drugPrice
            };
            drugDetails.push(itemData);
        }
        let totalPrice = 0;
        for (i=0;i<drugDetails.length;i++)
        {
            totalPrice=totalPrice+drugDetails[i].drugPrice*drugDetails[i].drugNum;
        }

        let postData={
            totalPrice:totalPrice,
            details:drugDetails
        };

        console.log("post数据："+JSON.stringify(postData));

        let postUrl="http://localhost:8090/drugSystem/api/sell/add";
        $.ajax({
            url:postUrl,
            type:"post",
            data:JSON.stringify(postData),      // 对象数组
            contentType: "application/json;charset=UTF-8",
            dataType:"json",
            success:function (data) {
                console.log("响应："+data);

                //提交过后清除数据
                $("#drug-info-sell .sell-drug-item-stamp").remove();
                GLOBAL_DATA=null;
            }
        });
    }

</script>