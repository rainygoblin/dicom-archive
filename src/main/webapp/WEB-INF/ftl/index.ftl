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
    <link rel="stylesheet" href="${request.contextPath}/resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="${request.contextPath}/resources/css/style.css">
</head>
<body>

<div class="container-fluid" style="background-color: #828282">
	<div class="row">
	    <div class="col-xs-3">
   		    <label style="width:130px">PatientName：</label>
   		    <input type="text" name="" id="code" placeholder=" PatientName" style="width:200px" >
		</div>
	    <div class="col-xs-3">
   		    <label style="width:130px">PatientID：</label>
   		    <input type="text" name="" id="code" placeholder=" PatientID" style="width:200px" >
		</div>
	    <div class="col-xs-3">
   		    <label style="width:130px">patientSex：</label>
   		    <input type="text" name="" id="code" placeholder=" patientSex" style="width:200px" >
		</div>
		<div class="col-xs-3">
		    <label class="form-label col-1">订单状态：</label>
				<select class="select" size="1" name="demo"  id="state">
					<option value="" selected>请选择</option>
					<option value="1">等待支付</option>
					<option value="2">等待发码</option>
					<option value="3">全部退款</option>
					<option value="4">全部消费</option>
					<option value="5">退款审核中</option>
					<option value="7">部分退款部分可消费</option>
					<option value="10">等待消费</option>
				</select>
		</div>
	</div>
	<div class="row">
	    <div class="col-xs-3">
   		    <label style="width:130px">institutionName：</label>
   		    <input type="text" name="" id="code" placeholder=" institutionName" style="width:200px" >
		</div>
	    <div class="col-xs-3">
   		    <label style="width:130px">accessionNumber：</label>
   		    <input type="text" name="" id="code" placeholder=" accessionNumber" style="width:200px" >
		</div>
	    <div class="col-xs-3">
   		    <label style="width:130px">modality：</label>
   		    <input type="text" name="" id="code" placeholder=" modality" style="width:200px" >
		</div>
	    <div class="col-xs-3">
		    <button name="btnSearch" id="" class="btn btn-success" type="button" onclick="refreshTable();">搜索</button>
		</div>
		</div>
	</div>
	<div class="mt-20">
		<table class="table table-border table-bordered table-bg table-hover table-sort">
		
		</table>
    </div>
</div>
<script src="${request.contextPath}/resources/js/jquery-2.1.4.min.js"></script>
<script src="${request.contextPath}/resources/js/bootstrap.min.js"></script>
<script src="${request.contextPath}/resources/js/datatables/1.10.0/jquery.dataTables.min.js"></script> 
<script>
$(function(){
	var ids=new Array();
	var index = 0;
	ids.push({ "targets": [index++], "title": "<input type='checkbox'></input>", "data":"_id","width": "1","orderable": false,"render": function ( data, type, full, meta ) {
		return '<input type="checkbox" name="checkboxlist" value='+data+'></input>';
	}});
	ids.push({ "targets": [index++], "title": "PatientName", "data":"patientName", "orderable": false});
	ids.push({ "targets": [index++], "title": "PatientID", "data":"patientID", "orderable": false});
	ids.push({ "targets": [index++], "title": "patientSex", "data":"patientSex", "orderable": false});
	ids.push({ "targets": [index++], "title": "patientBirthDate", "data":"patientBirthDate", "orderable": false});
	ids.push({ "targets": [index++], "title": "institutionName", "data":"institutionName", "orderable": false});
	ids.push({ "targets": [index++], "title": "accessionNumber", "data":"patientID", "orderable": false});
	ids.push({ "targets": [index++], "title": "modality", "data":"modality", "orderable": false});
	ids.push({ "targets": [index++], "title": "StudyDate", "data":"studyDate", "orderable": false});
	ids.push({ "targets": [index++], "title": "StudyDescription", "data":"studyDescription", "orderable": false});
	ids.push({ "targets": [index++], "title": "操作", "data":"id", "width": "5%","orderable": false, "render": function ( data, type, full, meta ) {
		return '${accountStaffOperations}';
						
	}});
	var dataTableConfig = {//jquery_datatable插件的默认参数皮质
		"stateSave": true, //是否把获得数据存入cookie
		"processing": true,
		"autoWidth":false,//自动宽度
		"serverSide": true,
		"ajax": searchStaff,
		"paging": true,  //是否分页。
		"searching": false,
		"pagingType": "full_numbers",      //分页样式
		"drawCallback": function( settings ) {
			$('#totalRecords').text(settings.fnRecordsTotal());
		},
		"lengthMenu": [
			[10, 25, 100],
			[10, 25, 100] // 更改每页显示记录数
		],
		"columnDefs": ids,
		"order": [
			[1, "asc"]
		] 
	};

	staffTable = $('.table-sort').dataTable(dataTableConfig);
});
	function searchStaff(data, callback, settings) {
		data.groupName=$("#searchField").val();
		$.ajax( {     
			type: "GET",
			url: "query",   
			dataType:"json",  
			data: data,
			success: function(data) {   
				//$("#url_sortdata").val(data.aaData);  
				callback(data); //服务器端返回的对象的returnObject部分是要求的格式     
			}     
		});    
	}
		
	$('#btnSearch').click(function(){ 
		staffTable.fnClearTable( 0 );
		staffTable.fnDraw();
	});
		
	/* 弹出 */
	function member_add(title,url,w,h){
		layer_show(title,url,w,h);
	}

	function refreshTable(){
		staffTable.fnClearTable( 0 );
		staffTable.fnDraw();
	}
	
	function powerset(title,url){
		var index = layer.open({
			type: 2,
			title: title,
			content: url
		});
		layer.full(index);
	}

	function authset(title,url,w,h){
		layer_show(title,url,w,h);
	}
</script> 
</script>
</body>
</html>