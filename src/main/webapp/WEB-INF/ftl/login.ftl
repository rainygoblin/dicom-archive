<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no">
    <meta name="format-detection" content="telephone=no">
    <link rel="apple-touch-icon-precomposed" sizes="57x57" href="${request.contextPath}/resources/image/desktop_logo-57.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="${request.contextPath}/resources/image/desktop_logo-72.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="${request.contextPath}/resources/image/desktop_logo-114.png">
    <title>100%喜帖</title>
    <link rel="stylesheet" href="${request.contextPath}/resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="${request.contextPath}/resources/css/style.css">
</head>
<body>

<div class="container-fluid" style="background-color: #828282">
    <div class="row">
        <div id="loign-wrapper" class="col-xs-12">
            <div id="login-layout">
               <div class="login_header">
                   <h4>登录 LOGIN</h4>
                   <a href="${request.contextPath}/register">注册</a>
               </div>
                <form action="${request.contextPath}/login" method="post" style="margin-top: 30px" class="login-form">
                    <div class="form-group" style="margin-bottom: 30px;">
                        <input type="text" class="form-control reste_input" id="userName" name="userName" placeholder="用户名 NAME" datatype="*" nullmsg="请输入用户名！">
						<div class="Validform_checktip"></div>
                    </div>
                    <div class="form-group" style="margin-bottom: 30px;">
                        <input type="password" class="form-control reste_input" id="password" name="password" placeholder="密码 PASSWORD" datatype="*" nullmsg="请输入密码！" >
						<div class="Validform_checktip"></div>
                    </div>
                    <div style="margin: 20px auto;width: 135px;">
                        <button type="submit" class="login_btn">确  认</button>
                    </div>
                    <div class="login_span"></div>
                </form>
            </div>
        </div>
    </div>
</div>

<script src="${request.contextPath}/resources/js/jquery-2.1.4.min.js"></script>
<script src="${request.contextPath}/resources/js/bootstrap.min.js"></script>
<script src="${request.contextPath}/resources/js/Validform_v5.3.2_min.js"></script>
<script>
    $(function(){
        $(".login-form").Validform({
            tiptype:function(msg,o,cssctl){
                if(!o.obj.is("form")){
                    var objtip=o.obj.siblings(".Validform_checktip");
                    cssctl(objtip,o.type);
                    objtip.text(msg);
                }
            }
        });
    })
</script>
</body>
</html>