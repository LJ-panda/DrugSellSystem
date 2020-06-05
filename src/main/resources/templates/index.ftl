<!DOCTYPE html>
<html lang="en">

<head>



  <title>SB Admin 2 - Dashboard</title>
  <#include "common/header.ftl"/>

  <script src="${springMacroRequestContext.contextPath}/js/jquery-3.4.1.js"></script>

  <script>
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
  </script>
</head>

<body id="page-top">

  <!-- Page Wrapper -->
  <div id="wrapper">

    <!-- Sidebar -->
    <#include "common/sidebar.ftl"/>
    <!-- End of Sidebar -->

    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">

      <!-- Main Content -->
      <div id="content">

        <!-- Topbar -->
        <#include "common/nav.ftl"/>
        <!-- End of Topbar -->

        <!-- Begin Page Content -->
        <div class="container-fluid">

          <button type="button" onclick="postRecord()" class="btn-block btn-primary">点击发送数据</button>
          <!-- Page Heading -->
          <!--
          <div class="d-sm-flex align-items-center justify-content-between mb-4">
            <h1 class="h3 mb-0 text-gray-800">Dashboard</h1>
            <a href="#" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i class="fas fa-download fa-sm text-white-50"></i> Generate Report</a>


          </div>
          -->

          <!-- Content Row -->


        </div>
        <!-- /.container-fluid -->

      </div>
      <!-- End of Main Content -->

      <!-- Footer -->
      <#include "common/footer.ftl"/>
      <!-- End of Footer -->

    </div>
    <!-- End of Content Wrapper -->

  </div>
  <!-- End of Page Wrapper -->

  <!-- Scroll to Top Button-->
  <a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
  </a>

  <!-- Logout Modal-->
  <#include "common/buttonLogoutModal.ftl"/>

  <!-- Bootstrap core JavaScript-->
  <#include "common/buttonsrc.ftl"/>

</body>

</html>
