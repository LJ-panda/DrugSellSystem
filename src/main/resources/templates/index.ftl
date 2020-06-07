<!DOCTYPE html>
<html lang="en">

<head>



  <title>SB Admin 2 - Dashboard</title>
  <#include "common/header.ftl"/>


  <script src="${springMacroRequestContext.contextPath}/js/jquery-3.4.1.js"></script>



  <script>

    /**
     * 核心 SPA 代码
     * @type {*[]}   存储请求的碎片id和hash组合值
     */
    var hashSet=[];
    function hashChageFun()
    {
      let hash=window.location.hash.toString();
      hash=hash.substr(1,hash.length-1);
      let baseUrl="${springMacroRequestContext.contextPath}/view/part/";
      let flag=false;
      for (i=0;i<hashSet.length;i++)
      {
        if (hashSet[i].split("@")[0]===hash)
        {
          $("#"+hashSet[i].split("@")[1]).show();
          flag=true;
        }
        else
        {
          $("#"+hashSet[i].split("@")[1]).hide();
        }
      }
      if (!flag&&hash.length!==0)
      {
        console.log("请求Url："+baseUrl+hash);
        $.get(baseUrl+hash,function (data) {
          $("#father-div").append(data);
          hashSet.push(hash+"@"+data.substr(data.indexOf("id=\"")+4,data.indexOf(" class")-10).trim());
          console.log("id列表："+JSON.stringify(hashSet));
        });
      }


    }
  </script>
</head>

<body id="page-top" onhashchange="hashChageFun()">

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
        <div class="container-fluid" id="father-div">


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
