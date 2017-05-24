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
		<h3 class="page-title" id="index-page-title">金融产品管理</h3>
		<ul class="page-breadcrumb breadcrumb" id="breadcrumb">
			<li><i class="fa fa-list-alt"></i> <a href="javascript:;"> 功能
			</a> <i class="fa fa-angle-right"></i>
			</li>
			<li><a href="javascript:;"> 金融产品管理 </a></li>
		</ul>
		<!-- END PAGE TITLE & BREADCRUMB-->
	</div>
</div>
<!-- END PAGE HEADER-->
<!-- BEGIN BODY-->
<div class="row">
	<div id="toolbar">
        <button id="add" class="btn btn-primary" onclick="newRow()">
            <i class="glyphicon glyphicon-plus"></i> 新增
        </button>
    </div>
	<div class="col-lg-12">
		<table id="reportTable" class="table-striped">
		</table>
	</div>
		<div id="light" class="white-pink white_content box-shadow-3">
			<div class="divcontext">
				<h1>用户管理
					<span>用户详细信息</span>
				</h1>
				<div class="bd">
					<table>
						<tr style="display: none;">
							<td><input id="id" type="text"/></td>
						</tr>
						<tr>
							<td class="tb">产品名称 :</td>
							<td class="text"><input id="productName" type="text" name="productName" placeholder="" /></td>
							<td class="tb">最小金额 :</td>
							<td class="text"><input id="minAmt" type="text" name="minAmt" placeholder=""></input></td>
						</tr>
						<tr>
							<td class="tb">最大金额 :</td>
							<td class="text"><input id="maxAmt" type="text" name="maxAmt" placeholder="" /></td>
							<td class="tb">日利率(‱) :</td>
							<td class="text"><input id="rate" type="text" name="rate" placeholder="" /></td>
						</tr>
						<tr>
							<td class="tb">最长用款期限（天） :</td>
							<td class="text"><input id="useDate" type="text" name="useDate" placeholder="" /></td>
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
<script src="assets/plugins/tableExport.js" type="text/javascript"></script>
<script src="assets/plugins/jquery.base64.js" type="text/javascript"></script>
<script src="assets/plugins/select2/select2.min.js" type="text/javascript"></script>
<script src="assets/scripts/factor/product.js" type="text/javascript"></script>

<script src="app/lib/security/sha256.js" type="text/javascript"></script>