<!DOCTYPE html>
<html lang="en">

<head>


    <title>SB Admin 2 - Tables</title>

    <#include "common/header.ftl"/>
    <#--
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <
    <link href="${springMacroRequestContext.contextPath}/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">


    <link href="${springMacroRequestContext.contextPath}/css/sb-admin-2.min.css" rel="stylesheet">


    <link href="${springMacroRequestContext.contextPath}/vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">
    -->
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

            <script>
                function t()
                {
                    let el=document.getElementById("choice");
                    alert("val:"+el.value)
                }
            </script>
            <!-- Begin Page Content -->
            <div class="container-fluid">

                <!-- Page Heading -->

                <!-- DataTales Example -->
                <div class="card shadow mb-4">
                    <div class="card-header py-3">
                        <h6 class="m-0 font-weight-bold text-primary">DataTables Example</h6>

                        <form>
                            <label for="choice">选择数据类型：</label>
                            <select id="choice" onchange="t()">
                                <option value="-1">待选择</option>
                                <option value="0">日志数据</option>
                                <option value="1">库存数据</option>
                                <option value="2">类型代码</option>
                                <option value="3">供应商数据</option>
                                <option value="4">采购记录</option>
                                <option value="5">销售记录</option>
                            </select>
                            <!--
                            <label for="student">Student:</label><input id="student" name="choice" type="radio"/>&nbsp;&nbsp;
                            <label for="teacher">Teacher:</label><input id="teacher" name="choice" type="radio"/>&nbsp;&nbsp;
                            <label for="admin">Admin:</label><input id="admin" name="choice" type="radio"/>
                            -->
                            <a class="btn btn-primary" href="#">导出Excel</a>
                        </form>
                    </div>
                    <div class="card-body">
                        <div class="table-responsive">
                            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                <thead>
                                <tr>
                                    <th>Name</th>
                                    <th>Position</th>
                                    <th>Office</th>
                                    <th>Age</th>
                                    <th>Start date</th>
                                    <th>Salary</th>
                                </tr>
                                </thead>
                                <tfoot>
                                <tr>
                                    <th>Name</th>
                                    <th>Position</th>
                                    <th>Office</th>
                                    <th>Age</th>
                                    <th>Start date</th>
                                    <th>Salary</th>
                                </tr>
                                </tfoot>
                                <tbody>
                                <tr>
                                    <td>Tiger Nixon</td>
                                    <td>System Architect</td>
                                    <td>Edinburgh</td>
                                    <td>61</td>
                                    <td>2011/04/25</td>
                                    <td>$320,800</td>
                                </tr>

                                <tr>
                                    <td>Michael Bruce</td>
                                    <td>Javascript Developer</td>
                                    <td>Singapore</td>
                                    <td>29</td>
                                    <td>2011/06/27</td>
                                    <td>$183,000</td>
                                </tr>

                                </tbody>
                            </table>


                        </div>
                    </div>
                </div>

            </div>
            <!-- /.container-fluid -->

        </div>
        <!-- End of Main Content -->

        <!-- Footer -->
        <footer class="sticky-footer bg-white">
            <div class="container my-auto">
                <div class="copyright text-center my-auto">
                    <span>Copyright &copy; Your Website 2019</span>
                </div>
            </div>
        </footer>
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
<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
            </div>
            <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
            <div class="modal-footer">
                <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                <a class="btn btn-primary" href="login.html">Logout</a>
            </div>
        </div>
    </div>
</div>


<#--
<script src="${springMacroRequestContext.contextPath}/vendor/jquery/jquery.min.js"></script>
<script src="${springMacroRequestContext.contextPath}/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>


<script src="${springMacroRequestContext.contextPath}/vendor/jquery-easing/jquery.easing.min.js"></script>


<script src="${springMacroRequestContext.contextPath}/js/sb-admin-2.min.js"></script>


<script src="${springMacroRequestContext.contextPath}/vendor/datatables/jquery.dataTables.min.js"></script>
<script src="${springMacroRequestContext.contextPath}/vendor/datatables/dataTables.bootstrap4.min.js"></script>


<script src="${springMacroRequestContext.contextPath}/js/demo/datatables-demo.js"></script>

-->
<#include "common/buttonsrc.ftl"/>
</body>

</html>
