$(function() {
	var Permission = function() {

		var handlePermissionTable = function() {
			
			$(function() {
				var url = "rest/adminPermission/getDate";
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
					showExport: false,                     //是否显示导出
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
						field : "permissionName",
						title : "权限名",
						editable : {
							type : 'text',
							title : '权限名',
							validate : function(v) {
								if (!v)
									return '权限名不能为空';
							}
						}
					}, {
						field : "permissionSign",
						title : "权限标识",
						editable : {
							type : 'select',
							title : '权限标识',
							source : function(){
								var result = [];
								$.ajax({
									type : "GET",
									async: false,
									cache : true,
									url : "rest/adminPermission/getPermissionName",
									data : {},
									dateType : 'JSON',
									success : function(data, status){
										$.each(eval(data), function(index, element){
											result.push({value : element.key, text : element.key});
										});
									}
								});
								return result;
							}
						}
					}, {
						field : "description",
						title : "权限描述",
						editable : {
							type : 'text',
							title : '权限描述',
							validate : function(v) {
								if (!v)
									return '角色描述不能为空';
							}
						}
					},
					{
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
							url : "rest/adminPermission/updatePermission",
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
				//alert($("#fixed-table-toolbar").html());
				/*$(".fixed-table-toolbar").append(
						'<div style="padding-top:10px">'+//
			        	'<a href="javascript:void(0)" onclick="" class="btn btn-info col-sm-1">新增</a>'+
		        	    '</div>');*/
				
				//set进table之前进行数据处理
				function responseHandler(res)
				{
					//alert(JSON.stringify(res));
					//var rows=res.rows;
					return res;
				}
				
				$.ajax({
					type : "GET",
					async: true,
					cache : true,
					url : "rest/adminPermission/getPermissionName",
					data : {},
					dateType : 'JSON',
					success : function(data, status){
						$.each(eval(data), function(index, element){
							$('#permissioSign').append("<option value='" + element.key + "'>" + element.key + "</option>");
						});
					}
				});
				
				$('#reportTable').on('check.bs.table uncheck.bs.table ' +
		                'check-all.bs.table uncheck-all.bs.table', function () {
		            $('#remove').prop('disabled', !$('#reportTable').bootstrapTable('getSelections').length);

		            // save your data, here just save the current page
		            selections = getIdSelections();
		            // push or splice the selections if you want to save all data selections
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
		url : "rest/adminPermission/deletePermission",
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
		url : "rest/adminPermission/getPermission",
		async : true,
		data : { id : id},
		cache : false,
		success : function(data ,status){
			$('#id').val(data.id);
			$('#permissionName').val(data.permissionName);
			$('#permissionSign').val(data.permissionSign);
			$('#description').val(data.description);
		}
	});
	$('#light').css("display","block");
	$('#fade').css("display","block");
}

function save(){
	var id = $('#id').val();
	var permissionName = $('#permissionName').val();
	var permissionSign = $('#permissionSign').val();
	var description = $('#description').val();
	
	if(permissionName == "" || permissionSign == ""){
		alert("权限名和权限标签不能为空。");
		return ;
	}
	
	$.ajax({
		type : 'post',
		url : "rest/adminPermission/updatePermission",
		async : true,
		data : {id:id, permissionName:permissionName,permissionSign:permissionSign,description:description},
		cache : false,
		success : function(data ,status){
			$('#light').css("display","none");
			$('#fade').css("display","none");
			alert("保存成功。");
			$('#reportTable').bootstrapTable('refresh');
		},
		error : function(data, status) {
			alert("保存失败。");
		},
	});
}

function newPermission(){
	$('#id').val("");
	$('#permissionName').val("");
	$('#permissioSign').val("");
	$('#description').val("");
	$('#light').css("display","block");
	$('#fade').css("display","block");
}

function getIdSelections() {
    return $.map($('#reportTable').bootstrapTable('getSelections'), function (row) {
        return row.id
    });
}