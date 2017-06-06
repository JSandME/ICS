$(function() {
	var Permission = function() {

		var handlePermissionTable = function() {
			
			$(function() {
				var url = "rest/repaymentPlan/getRepaymentPlanbyUserName";
				$("#reportTable").bootstrapTable({
					url : url,
					dataType:"JSON", 	//返回JSON格式数据
					idField : "id",
					toolbar: '#toolbar',    //工具按钮用哪个容器
	                striped: true,      //是否显示行间隔色
	                cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
	                pagination: true,     //是否显示分页（*）
	                sortable: false,      //是否启用排序
	                sortOrder: "asc",     //排序方式
	                pageNumber:1,      //初始化加载第一页，默认第一页
	                pageSize: 10,      //每页的记录行数（*）
					pageList : [10, 25, 50, 100, 1000],
					showRefresh : true,	//是否显示刷新按钮
					search : true,
					singleSelect : true,
					clickToSelect : true,
					showExport: true,                     //是否显示导出
					exportDataType: "all",              //basic', 'all', 'selected'.
					minimumCountColumns: 2,    //最少允许的列数
					responseHandler: responseHandler,
					//sidePagination: "server", //服务端处理分页
					queryParams : function(param) {
						return {};
					},
					columns : [ {
						checkbox : true
					}, {
						field : "name",
						title : "借款人",
					}, {
						field : "begin_date",
						title : "起始日期",
					}, {
						field : "end_date",
						title : "到期日期",
					},{
						field : "app_amt",
						title : "贷款金额",
					}, {
						field : "payed_corpus",
						title : "已偿还本金",
					}, {
						field : "unpay_corpus",
						title : "未偿还本金",
					}, {
						field : "repay_accrual",
						title : "预期利息",
					}, {
						field : "payed_accrual",
						title : "已回收利息",
					}, {
						field : "rate",
						title : "日利率",
					}, {
						field : "repay_state",
						title : "还款状态",
					}],
				});
				$("#reportTable tr th").css("background-color", "#ddd"); //改变table表头背景色 
				$("#reportTable tr th").css("color", "#000000");//改变table表头字体颜色	
				$("#reportTable tr th").css("font-family", "#Microsoft Yahei");//改变table表头字体样式		
				
				//set进table之前进行数据处理
				function responseHandler(res)
				{
					$.each(res, function(index, element){
						switch (res[index].repay_state) {
						case "0":
							res[index].repay_state = "未还清";
							break;
						case "1":
							res[index].repay_state = "已结清";
							break;
						case "2":
							res[index].repay_state = "已逾期";
							break;

						default:
							res[index].repay_state = "未知状态";
							break;
						}
					});
					return res;
				}
				
				$('#pay').change(function(){
					var row = getIdSelections();
		            row = row[0];
		            $('#pan_id').val(row.id);
		            var d1 = new Date((row.begin_date).replace(/\-/g, "\/"));  
		            var now = new Date();
		            var days = now.getTime() - d1.getTime(); 
		            var day = parseInt(days / (1000 * 60 * 60 * 24)); 
		            
		            var pay_accrual = day * row.app_amt * row.rate * 0.0001;
		            var pay_corpus = $('#pay').val() - pay_accrual;
		            if(pay_corpus + row.payed_accrual < 0){
		            	pay_accrual = 0;
		            	pay_corpus = $('#pay').val();
		            }
		            
		            $('#pay_corpus').val(pay_corpus);
		            $('#pay_accrual').val(pay_accrual);
		            
				});
				
				$('#reportTable').on('check.bs.table uncheck.bs.table ' +
		                'check-all.bs.table uncheck-all.bs.table', function () {
					row = getIdSelections();
					row = row[0];
					if(typeof(row) == "undefined"){
						return ;
					}
					if(row.repay_state == "未还清"){
						$('#repayment').prop('disabled', !$('#reportTable').bootstrapTable('getSelections').length);
						var d1 = new Date((row.end_date).replace(/\-/g, "\/"));  
						var now = new Date();
						if(d1 < now){
							$('#overDue').prop('disabled', !$('#reportTable').bootstrapTable('getSelections').length);
						}
					}
					
					if(row.repay_state == "已逾期"){
						
					}

		        });
				
				$('#repayment').click(function () {
		            var row = getIdSelections();
		            /*$('#reportTable').bootstrapTable('remove', {
		                field: 'id',
		                values: ids
		            });*/
		            $('#pan_id').val("");
		        	$('#pay').val("");
		        	$('#pay_corpus').val("");
		        	$('#pay_accrual').val("");
		            $('#light').css("display","block");
		        	$('#fade').css("display","block");
		            
		            $('#repayment').prop('disabled', true);
		        });
				
				$('#overDue').click(function () {
					var row = getIdSelections();
					
					var datasource ={};
					datasource.id = row[0].id;
					datasource.appId = row[0].app_id;
					datasource.repayState = '2';
					
					$.ajax({
						type : 'post',
						url : "rest/repaymentPlan/overDue",
						async : true,
						data : datasource,
						cache : false,
						success : function(data ,status){
							if(data != "error"){
								$('#light').css("display","none");
								$('#fade').css("display","none");
								alert("提交成功。");
								$('#reportTable').bootstrapTable('refresh');
							}else{
								alert("提交失败.");
							}
						},
						error : function(data, status) {
							alert("请求失败。");
						},
					});
					 $('#overDue').prop('disabled', true);
				});
				
			});
			
		};

		return {
			init : function() {
				handlePermissionTable();
			}

		};
	}();
	Permission.init();
	
});

function save(){
	var pan_id = $('#pan_id').val();
	var pay = $('#pay').val();
	var pay_corpus = $('#pay_corpus').val();
	var pay_accrual = $('#pay_accrual').val();
	
	var datasource ={};
	datasource.panId = pan_id;
	datasource.payCorpus = pay_corpus;
	datasource.payAccrual = pay_accrual;
	
	if(pay == ""){
		alert("不能有空。");
		return ;
	}
	$.ajax({
		type : 'post',
		url : "rest/repaymentPlan/repayment",
		async : true,
		data : datasource,
		cache : false,
		success : function(data ,status){
			if(data != "error"){
				$('#light').css("display","none");
				$('#fade').css("display","none");
				alert("提交成功。");
				$('#reportTable').bootstrapTable('refresh');
			}else{
				alert("提交失败.");
			}
		},
		error : function(data, status) {
			alert("请求失败。");
		},
	});
	
}

function getIdSelections() {
    return $.map($('#reportTable').bootstrapTable('getSelections'), function (row) {
        return row;
    });
}