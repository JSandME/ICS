<%@ page language="java" pageEncoding="utf-8"%>
<link href="assets/plugins/bootstrap-table/css/bootstrap-table.min.css"
	rel="stylesheet" type="text/css" />
<link
	href="assets/plugins/bootstrap-editable/bootstrap-editable/css/bootstrap-editable.css"
	rel="stylesheet" type="text/css" />
<link href="assets/css/common/layui.css" rel="stylesheet" type="text/css" />
<style>
.error{
	color:red;
}
</style>
<!-- BEGIN PAGE HEADER-->
<div class="row">
	<div class="col-md-12">
		<!-- BEGIN PAGE TITLE & BREADCRUMB-->
		<h3 class="page-title" id="index-page-title">权限管理</h3>
		<ul class="page-breadcrumb breadcrumb" id="breadcrumb">
			<li><i class="fa fa-gears"></i> <a href="javascript:;"> 系统管理
			</a> <i class="fa fa-angle-right"></i>
			</li>
			<li><a href="javascript:;"> 权限管理 </a></li>
		</ul>
		<!-- END PAGE TITLE & BREADCRUMB-->
	</div>
</div>
<!-- END PAGE HEADER-->
<!-- BEGIN BODY-->
<div class="row">
	<div class="col-lg-12">
	<div id="toolbar">
        <button id="add" class="btn btn-primary" onclick="fun()">
            <i class="glyphicon glyphicon-plus"></i> 新增
        </button>
        <button id="remove" class="btn btn-danger" disabled>
            <i class="glyphicon glyphicon-remove"></i> 删除
        </button>
    </div>
		<table id="reportTable" class="table-striped">
		</table>
	</div>
		<div id="light" class="white-pink white_content box-shadow-3">
			<div class="divcontext">
				<h1>权限管理
					<span>权限详细信息</span>
				</h1>
				<div class="bd">
					<table>
						<tr style="display: none;">
							<td><input id="id" type="text"/></td>
						</tr>
						<tr>
							<td class="tb">权限名 :</td>
							<td class="text"><input id="permissionName" type="text" name="permissionName" placeholder="permissionName" /></td>
							<td class="tb">权限标识 :</td>
							<td class="text"><select id="permissioSign"></select></td>
						</tr>
						<tr>
							<td class="tb">权限描述 :</td>
							<td class="text"><input id="description" type="text" name="description" placeholder="description"></input></td>
						</tr>
					</table>
					<div class="ft">
						<a href="javascript:void(0)" class="btn btn-info"  onclick="save()">提交</a>
						<a href="javascript:void(0)" class="btn btn-info"  onclick="document.getElementById('light').style.display='none';document.getElementById('fade').style.display='none';">关闭</a>
					</div>
				</div>
			</div>
		</div>
	<div id="fade" class="black_overlay"></div> 
</div>
<!-- END BODY-->
<script src="assets/plugins/bootstrap-table/js/bootstrap-table.min.js"
	type="text/javascript"></script>
<script src="assets/plugins/bootstrap/js/bootstrap-table-zh-CN.js"
	type="text/javascript"></script>
<script
	src="assets/plugins/bootstrap-editable/bootstrap-editable/js/bootstrap-editable.min.js"
	type="text/javascript"></script>
<script
	src="assets/plugins/bootstrap-table/extensions/editable/bootstrap-table-editable.min.js"
	type="text/javascript"></script>
<script
	src="assets/plugins/bootstrap-table/extensions/export/bootstrap-table-export.min.js"
	type="text/javascript"></script>
<script src="assets/scripts/admin/permission.js" type="text/javascript"></script>
<script>
	function fun(){
								var result = [];
								$.ajax({
									type : "GET",
									async: false,
									cache : true,
									url : "rest/adminPermission/getDate",
									data : {},
									dateType : 'JSON',
									success : function(data, status){
										alert(data);
									}
								});
								return result;
							}
</script>