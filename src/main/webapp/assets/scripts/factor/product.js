$(function() {
	var Permission = function() {

		var handlePermissionTable = function() {
			
			$(function() {
				var url = "rest/product/getDate";
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
						field : "productName",
						title : "产品名称",
						editable : {
							type : 'text',
							title : '产品名称',
							validate : function(v) {
								if (!v)
									return '产品名称不能为空';
							}
						}
					}, {
						field : "minAmt",
						title : "最小金额",
						editable : {
							type : 'text',
							title : '最小金额',
							validate : function(v) {
								if (!v)
									return '最小金额不能为空';
							}
						}
					}, {
						field : "maxAmt",
						title : "最大金额",
						editable : {
							type : 'text',
							title : '最大金额',
							validate : function(v) {
								if (!v)
									return '最大金额不能为空';
							}
						}
					},{
						field : "rate",
						title : "日利率(‱) ",
						editable : {
							type : 'text',
							title : '日利率(‱) ',
							validate : function(v) {
								if (!v)
									return '日利率不能为空';
							}
						}
					}, {
						field : "useDate",
						title : "最长用款期限（天） ",
						editable : {
							type : 'text',
							title : '最长用款期限（天）  ',
							validate : function(v) {
								if (!v)
									return '最长用款期限不能为空';
							}
						}
					},{
	                	title: '操作',
	                	field: 'id',
	                	align: 'center',
	                	formatter:function(value,row,index){  
	                	var e = '<a href="#" mce_href="#" onclick="editRow(\''+ row.id + '\')">编辑</a> ';  
	                	var d = '<a href="#" mce_href="#" onclick="delRow(\''+ row.id + '\');$(\'.rerefresh\').click()">删除</a> ';
	                        return e+d;  
	                    }
					}],
					onEditableSave : function(field, row, oldValue, $el) {
						$("#reportTable").bootstrapTable("resetView");
						$.ajax({
							type : "post",
							url : "rest/product/updateProduct",
							data : row,
							dataType : 'JSON',
							success : function(data, status) {
								if(status == "success"){
									alert("更新成功。");
									$('#reportTable').bootstrapTable('refresh');
								}
							},
							error : function(data, status) {
								alert(status);
								alert("更新失败。");
							},
							complete : function() {

							}

						});
					}
				});
				$("#reportTable tr th").css("background-color", "#ddd"); //改变table表头背景色 
				$("#reportTable tr th").css("color", "#000000");//改变table表头字体颜色	
				$("#reportTable tr th").css("font-family", "#Microsoft Yahei");//改变table表头字体样式		
				
				//set进table之前进行数据处理
				function responseHandler(res)
				{
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
				handlePermissionTable();
			}

		};
	}();
	Permission.init();
	
});

function delRow(id){
	$.ajax({
		type : 'post',
		url : "rest/product/deleteProduct",
		async : false,
		data : { id : id},
		cache : false,
		success : function(data ,status){
			alert("删除成功。");
			$('#reportTable').bootstrapTable('refresh');
		},
		error : function(data, status) {
			alert("删除失败。");
		},
	});
}

function editRow(id){
	$.ajax({
		type : 'post',
		url : "rest/product/getProduct",
		async : true,
		data : { id : id},
		cache : false,
		success : function(data ,status){
			$('#id').val(data.id);
			$('#productName').val(data.productName);
			$('#minAmt').val(data.minAmt);
			$('#maxAmt').val(data.maxAmt);
			$('#rate').val(data.rate);
			$('#useDate').val(data.useDate);
		}
	});
	$('#light').css("display","block");
	$('#fade').css("display","block");
}

function save(){
	var id = $('#id').val();
	var productName = $('#productName').val();
	var minAmt = $('#minAmt').val();
	var maxAmt = $('#maxAmt').val();
	var rate = $('#rate').val();
	var useDate = $('#useDate').val();
	
	var datasource ={};
	datasource.id = id;
	datasource.productName = productName;
	datasource.minAmt = minAmt;
	datasource.maxAmt = maxAmt;
	datasource.rate = rate;
	datasource.useDate = useDate;
	
	
	if(productName == "" || minAmt == "" || maxAmt == "" || rate == "" || useDate == ""){
		alert("不能有空。");
		return ;
	}
	
	$.ajax({
		type : 'post',
		url : "rest/product/updateProduct",
		async : true,
		data : datasource,
		cache : false,
		success : function(data ,status){
			if(data != "error"){
				$('#light').css("display","none");
				$('#fade').css("display","none");
				alert("保存成功。");
				$('#reportTable').bootstrapTable('refresh');
			}else{
				alert("保存失败.");
			}
		},
		error : function(data, status) {
			alert("保存失败。");
		},
	});
}

function newRow(){
	$('#id').val("");
	$('#productName').val("");
	$('#minAmt').val("");
	$('#maxAmt').val("");
	$('#rate').val("");
	$('#useDate').val("");
	$('#light').css("display","block");
	$('#fade').css("display","block");
}

function getIdSelections() {
    return $.map($('#reportTable').bootstrapTable('getSelections'), function (row) {
        return row.id
    });
}