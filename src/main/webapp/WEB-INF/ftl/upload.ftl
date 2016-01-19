<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no">
    <meta name="format-detection" content="telephone=no">
    <link rel="apple-touch-icon-precomposed" sizes="57x57" href="${request.contextPath}/resources/image/desktop_logo-57.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="${request.contextPath}/resources/image/desktop_logo-72.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="${request.contextPath}/resources/image/desktop_logo-114.png">
    <title>DICOM Archive by MongoDB</title>
    <link rel="stylesheet" href="${request.contextPath}/resources/js/webuploader/0.1.5/webuploader.css">
</head>
<body>
<div class="uploader-list-container">
	<div class="queueList">
		<div id="dndArea" class="placeholder">
			<div id="filePicker-2"></div>
			<p>或将照片拖到这里，单次最多可选300张</p>
		</div>
	</div>
	<div class="statusBar" style="display:none;">
		<div class="progress"> <span class="text">0%</span> <span class="percentage"></span> </div>
		<div class="info"></div>
		<div class="btns">
			<div id="filePicker2"></div>
			<div class="uploadBtn">开始上传</div>
		</div>
	</div>
</div>
<script src="${request.contextPath}/resources/js/jquery-2.1.4.min.js"></script>
<script src="${request.contextPath}/resources/js/webuploader/0.1.5/webuploader.min.js"></script> 
<script src="${request.contextPath}/resources/js/upload.js"></script> 
</body>
</html>