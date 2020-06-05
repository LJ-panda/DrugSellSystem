<!DOCTYPE html>
<html lang="en">

<head>



  <title>SB Admin 2 - Tables</title>

  <#include "common/header.ftl"/>

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

        <!-- Begin Page Content -->
        <div class="container-fluid">

          <!--除了下面这句，其余已经是公共部分-->
          <#include "common/pageTable.ftl"/>

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
