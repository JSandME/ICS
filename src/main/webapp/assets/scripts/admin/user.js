$(function() {
	var Role = function() {

		var handleRoleTable = function() {
			
			$(function() {
				var url = "rest/admin/getDate";
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
						field : "roleName",
						title : "角色名",
						editable : {
							type : 'text',
							title : '角色名',
							validate : function(v) {
								if (!v)
									return '角色名不能为空';
							}
						}
					}, {
						field : "roleSign",
						title : "角色标识",
						editable : {
							type : 'select',
							title : '角色标识',
							source : function(){
								var result = [];
								$.ajax({
									type : "GET",
									async: false,
									cache : true,
									url : "rest/admin/getRoleName",
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
						title : "角色描述",
						editable : {
							type : 'text',
							title : '角色描述',
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
						$.ajax({
							type : "post",
							url : "rest/admin/updateRole",
							data : row,
							dataType : 'JSON',
							success : function(data, status) {
								if(status == "success"){
									alert("更新成功。");
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
				$(".fixed-table-toolbar").append(
						'<div style="padding-top:10px">'+//
			        	'<a href="javascript:void(0)" onclick="" class="btn btn-info col-sm-1">新增</a>'+
		        	    '</div>');
				
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
					url : "rest/admin/getRoleName",
					data : {},
					dateType : 'JSON',
					success : function(data, status){
						$.each(eval(data), function(index, element){
							$('#roleSign').append("<option value='" + element.key + "'>" + element.key + "</option>");
						});
					}
				});
				
			});
			
		};

		return {
			init : function() {
				handleRoleTable();
			}

		};
	}();
	Role.init();
	
});

function delRow(id){
	$.ajax({
		type : 'post',
		url : "rest/admin/deleteRole",
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
		url : "rest/admin/getRole",
		async : true,
		data : { id : id},
		cache : false,
		success : function(data ,status){
			$('#id').val(data.id);
			$('#roleName').val(data.roleName);
			$('#roleSign').val(data.roleSign);
			$('#description').val(data.description);
		}
	});
	$('#light').css("display","block");
	$('#fade').css("display","block");
}

function save(){
	var id = $('#id').val();
	var roleName = $('#roleName').val();
	var roleSign = $('#roleSign').val();
	var description = $('#description').val();
	$.ajax({
		type : 'post',
		url : "rest/admin/updateRole",
		async : true,
		data : {id:id, roleName:roleName,roleSign:roleSign,description:description},
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
