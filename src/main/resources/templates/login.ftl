<!DOCTYPE html>
<html lang="en">

<head>



  <title>SB Admin 2 - Login</title>

  <#include "common/header.ftl"/>



  <script>
    function loginFun()
    {
      let loginUrl="${springMacroRequestContext.contextPath}/api/user/login";
      let toUrl="${springMacroRequestContext.contextPath}/view/user/index";
      let email=$("#email").val();
      let password=$("#password").val();
      if (!(email.length!==0&&password.length!==0))
      {
        alert("请如实填写 Email 和 Password！");
        return;
      }
      let postData={email:email,password:password};
      $.post(loginUrl,postData,function (data) {
        console.log("响应数据："+data);
        if (data.data===true)
        {
          console.log("login ok");
          window.location.href=toUrl;
        }
      });
    }
  </script>
</head>

<body class="bg-gradient-primary">

  <div class="container">

    <!-- Outer Row -->
    <div class="row justify-content-center">

      <div class="col-xl-10 col-lg-12 col-md-9">

        <div class="card o-hidden border-0 shadow-lg my-5">
          <div class="card-body p-0">
            <!-- Nested Row within Card Body -->
            <div class="row">
              <div class="col-lg-6 d-none d-lg-block bg-login-image"></div>
              <div class="col-lg-6">
                <div class="p-5">
                  <div class="text-center">
                    <h1 class="h4 text-gray-900 mb-4">Welcome Back!</h1>
                  </div>
                  <form class="user">
                    <div class="form-group">                                               <!--exampleInputEmail-->
                      <input type="email" name="email" class="form-control form-control-user" id="email" aria-describedby="emailHelp" placeholder="Enter Email Address...">
                    </div>
                    <div class="form-group">                                                <!--exampleInputPassword-->
                      <input type="password" name="password" class="form-control form-control-user" id="password" placeholder="Password">
                    </div>

                    <!--
                    <a href="index.ftl" class="btn btn-primary btn-user btn-block">
                      Login
                    </a>
                    -->
                    <button type="button" class="btn btn-primary btn-user btn-block" onclick="loginFun()">Login</button>
                    <hr>

                  </form>
                  <hr>
                  <div class="text-center">
                    <a class="small" href="forgot-password.ftl">Forgot Password?</a>
                  </div>

                </div>
              </div>
            </div>
          </div>
        </div>

      </div>

    </div>

  </div>

  <!-- Bootstrap core JavaScript-->
  <#include "common/buttonsrc.ftl"/>

</body>

</html>
