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

<div class="container-fluid">
    <div class="row">
        <div style="text-align: center; width: 10rem; height: 10rem; margin: 5rem auto; overflow: hidden;">
            <img style="width: 100%" src="${request.contextPath}/resources/image/404.png"/>
        </div>
        <div style="text-align: center">
            <h4>${errorMsg}</h4>
        </div>
        <div style="text-align: center">
            <a href="${request.contextPath}/templates">返回首页</a>
        </div>
    </div>
</div>

<script src="${request.contextPath}/resources/js/jquery-2.1.4.min.js"></script>
<script src="${request.contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>