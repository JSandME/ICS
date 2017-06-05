$(function() {
	var ApplyInfo = function() {

		var handleApplyInfoTable = function() {
			
			$(function() {
				var url = "rest/downstreamFirms/getApproveInfo";
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
						title : "申请人",
					}, {
						field : "app_amt",
						title : "融资金额",
					}, {
						field : "rate",
						title : "日利率(‱) ",
					}, {
						field : "use_date",
						title : "用款期限(天)",
					},{
						field : "app_date",
						title : "申请日期",
					}, {
						field : "state",
						title : "流程状态 ",
					}],
				});
				$("#reportTable tr th").css("background-color", "#ddd"); //改变table表头背景色 
				$("#reportTable tr th").css("color", "#000000");//改变table表头字体颜色	
				$("#reportTable tr th").css("font-family", "#Microsoft Yahei");//改变table表头字体样式		
				
				//set进table之前进行数据处理
				function responseHandler(res)
				{
					$.each(res, function(index, element){
						switch (res[index].state) {
						case "0":
							res[index].state = "申请中";
							break;
						case "1":
							res[index].state = "申请通过,已放款.";
							break;
						case "9":
							res[index].state = "申请不通过。";
							break;

						default:
							res[index].state = "未知状态。";
							break;
						}
					});
					return res;
				}
				
				$('#reportTable').on('check.bs.table uncheck.bs.table ' +
		                'check-all.bs.table uncheck-all.bs.table', function () {
		            $('#remove').prop('disabled', !$('#reportTable').bootstrapTable('getSelections').length);

		            selections = getIdSelections();
		        });
				
				$('#remove').click(function () {
		            var ids = getIdSelections();
		            /*$('#reportTable').bootstrapTable('remove', {
		                field: 'id',
		                values: ids
		            });*/
		            $('#remove').prop('disabled', true);
		        });
				
			});
			
		};

		return {
			init : function() {
				handleApplyInfoTable();
			}

		};
	}();
	ApplyInfo.init();
	
});
