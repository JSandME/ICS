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
		<h3 class="page-title" id="index-page-title">申请融资</h3>
		<ul class="page-breadcrumb breadcrumb" id="breadcrumb">
			<li><i class="fa fa-list-alt"></i> <a href="javascript:;"> 功能
			</a> <i class="fa fa-angle-right"></i>
			</li>
			<li><a href="javascript:;"> 申请融资 </a></li>
		</ul>
		<!-- END PAGE TITLE & BREADCRUMB-->
	</div>
</div>
<!-- END PAGE HEADER-->
<!-- BEGIN BODY-->
<div class="row">
	<div class="col-lg-12">
		<div class="white-pink">
				<h1>申请融资
					<span>申请融资</span>
				</h1>
				<div class="bd">
					<table style="width:70%;margin: 0 auto;">
						<tr>
							<td>融资人 :</td>
							<td><input id="name" type="text" name="pull" placeholder="" value="${userInfo.name}"/></td>
						</tr>
						<tr>
							<td>融资金额 :</td>
							<td><input id="appAmt" type="text" name="appAmt" placeholder=""></input></td>
						</tr>
						<tr>
							<td >用款日期 :</td>
							<td><input id="use_date" type="text" name="use_date" placeholder=""></input></td>
						</tr>
						<tr>
							<td >融资产品 :</td>
							<td><select id="products"></select></td>
						</tr>
					</table>
					<div class="ft">
						<a href="javascript:void(0)" class="btn btn-info"  onclick="save()">提交</a>
					</div>
				</div>
			</div>
	</div>
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