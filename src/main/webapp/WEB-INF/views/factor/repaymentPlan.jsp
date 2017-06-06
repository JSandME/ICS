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
		<h3 class="page-title" id="index-page-title">还款情况</h3>
		<ul class="page-breadcrumb breadcrumb" id="breadcrumb">
			<li><i class="fa fa-list-alt"></i> <a href="javascript:;"> 功能
			</a> <i class="fa fa-angle-right"></i>
			</li>
			<li><a href="javascript:;"> 还款情况 </a></li>
		</ul>
		<!-- END PAGE TITLE & BREADCRUMB-->
	</div>
</div>
<!-- END PAGE HEADER-->
<!-- BEGIN BODY-->
<div class="row">
	<div id="toolbar">
        <button id="repayment" class="btn btn-primary" disabled>
            <i class="glyphicon glyphicon-plus"></i> 还款
        </button>
        <button id="overDue" class="btn btn-primary" disabled>
            <i class="glyphicon glyphicon-plus"></i> 逾期等登记
        </button>
    </div>
	<div class="col-lg-12">
		<table id="reportTable" class="table-striped">
		</table>
	</div>
		<div id="light" class="white-pink white_content box-shadow-3">
			<div class="divcontext">
				<h1>还款
					<span>还款详细信息</span>
				</h1>
				<div class="bd">
					<table>
						<tr style="display: none;">
							<td><input id="pan_id" type="text"/></td>
						</tr>
						<tr>
							<td class="tb">还款金额：</td>
							<td class="text"><input id="pay" type="text" name="pay" placeholder="" /></td>
						</tr>
						<tr>
							<td class="tb">还款的本金 :</td>
							<td class="text"><input id="pay_corpus" type="text" name="pay_corpus" placeholder="" disabled/></td>
							<td class="tb">还款的利息 :</td>
							<td class="text"><input id="pay_accrual" type="text" name="pay_accrual" placeholder="" disabled/></td>
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
<script src="assets/scripts/factor/repaymentPlan.js" type="text/javascript"></script>

<script src="app/lib/security/sha256.js" type="text/javascript"></script>