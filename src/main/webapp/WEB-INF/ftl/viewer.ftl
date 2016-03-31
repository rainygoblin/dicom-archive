<!DOCTYPE html>
<!--[if lt IE 7]>
<html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>
<html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>
<html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!-->

<!--suppress ALL -->
<html class="no-js">

<!--<![endif]-->
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no">
	<meta name="format-detection" content="telephone=no">
	<title>Goblin DICOM Viewer</title>

	<link rel="stylesheet" href="${request.contextPath}/resources/css/goblin.min.css"/>

</head>
<style>

	.container {
		height: 100%;
		width: 100%;
		overflow: auto;
	}

</style>
<body>

<div class="container">

	<!-- The DICOM Viewer Display-->
	<div class="row">
		<div class="viewerContainer" style="height: 700px;overflow:hidden;"/>
	</div>

	<div class="row">
		<div class="col-xs-6">
			This is the demo study load html
		</div>
		<div class="col-xs-6">
			Just for learn js DICOM Viewer
		</div>
	</div>
</div>

<script src="${request.contextPath}/resources/js/goblin.min.js"></script>

</body>
</html>