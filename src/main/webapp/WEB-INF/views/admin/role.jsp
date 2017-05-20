<%@ page language="java" pageEncoding="utf-8"%>
<link href="assets/plugins/bootstrap-table/css/bootstrap-table.min.css"
	rel="stylesheet" type="text/css" />
<link
	href="assets/plugins/bootstrap-editable/bootstrap-editable/css/bootstrap-editable.css"
	rel="stylesheet" type="text/css" />
<link
	href="assets/plugins/select2/select2.css"
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
		<h3 class="page-title" id="index-page-title">角色管理</h3>
		<ul class="page-breadcrumb breadcrumb" id="breadcrumb">
			<li><i class="fa fa-gears"></i> <a href="javascript:;"> 系统管理
			</a> <i class="fa fa-angle-right"></i>
			</li>
			<li><a href="javascript:;"> 角色管理 </a></li>
		</ul>
		<!-- END PAGE TITLE & BREADCRUMB-->
	</div>
</div>
<!-- END PAGE HEADER-->
<!-- BEGIN BODY-->
<div class="row">
	<div class="col-lg-12">
		<table id="reportTable" class="table-striped">
		</table>
	</div>
		<div id="light" class="white-pink white_content box-shadow-3">
			<div class="divcontext">
				<h1>角色管理
					<span>角色详细信息</span>
				</h1>
				<div class="bd">
					<table>
						<tr style="display: none;">
							<td><input id="id" type="text"/></td>
						</tr>
						<tr>
							<td class="tb">角色名 :</td>
							<td class="text"><input id="roleName" type="text" name="roleName" placeholder="roleName" /></td>
							<td class="tb">角色标识 :</td>
							<td class="text"><select id="roleSign"></select></td>
						</tr>
						<tr>
							<td class="tb">角色描述 :</td>
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
<script src="assets/plugins/select2/select2.min.js" type="text/javascript"></script>
<script src="assets/scripts/admin/role.js" type="text/javascript"></script>