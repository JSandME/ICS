$(function() {
	var Permission = function() {

		var handlePermissionTable = function() {
			
			$(function() {
				var url = "rest/adminUser/getDate";
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
						title : "用户名称",
						editable : {
							type : 'text',
							title : '用户名称',
							validate : function(v) {
								if (!v)
									return '用户账号不能为空';
							}
						}
					},{
						field : "username",
						title : "用户账号",
					}, {
						field : "password",
						title : "登陆密码",
						/*editable : {
							type : 'text',
							title : '登陆密码',
							validate : function(v) {
								if (!v)
									return '登陆密码不能为空';
							}
						}*/
					},{
						field : "role",
						title : "角色",
						editable : {
							type : 'select',
							title : '角色',
							source : function(){
								var result = [];
								$.ajax({
									type : "GET",
									async: false,
									cache : true,
									url : "rest/adminRole/getDate",
									data : {},
									dateType : 'JSON',
									success : function(data, status){
										$.each(eval(data), function(index, element){
											result.push({value : element.id, text : element.description});
										});
									}
								});
								return result;
							}
						}
					}, {
						field : "state",
						title : "状态",
						editable : {
							type : 'select',
							title : '状态',
							source : ""/*function(){
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
							}*/
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
						var str = JSON.stringify(row.password);
						if(typeof(str) !="undefined"){
	                    	row.permissions=JSON.stringify(sha256_digest(str.replace(/[^0-9a-zA-Z]/ig,"")));
						}
						$("#reportTable").bootstrapTable("resetView");
						$.ajax({
							type : "post",
							url : "rest/adminUser/updateUser",
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
		url : "rest/adminUser/deleteUser",
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
		url : "rest/adminUser/getUser",
		async : true,
		data : { id : id},
		cache : false,
		success : function(data ,status){
			$('#id').val(data.id);
			$('#name').val(data.name);
			$('#username').val(data.username);
			$('#password').val("******");
			$('#state').val(data.state);
		}
	});
	$('#light').css("display","block");
	$('#fade').css("display","block");
}

function save(){
	var id = $('#id').val();
	var name = $('#name').val();
	var username = $('#username').val();
	var password = $('#password').val();
	var state = $('#state').val();
	
	var datasource ={};
	datasource.name = name;
	datasource.username = username;
	datasource.state = state;
	if(password != "******"){
		password = sha256_digest($('#password').val());
		datasource.password = password;
	}
	
	
	if(username == "" || password == ""){
		alert("角色名和密码不能为空。");
		return ;
	}
	
	$.ajax({
		type : 'post',
		url : "rest/adminUser/updateUser",
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
				alert("保存失败，可能已存在改登录名。");
			}
		},
		error : function(data, status) {
			alert("保存失败。");
		},
	});
}

function newRow(){
	$('#id').val("");
	$('#name').val("");
	$('#username').val("");
	$('#password').val("");
	$('#state').val("");
	$('#light').css("display","block");
	$('#fade').css("display","block");
}

function getIdSelections() {
    return $.map($('#reportTable').bootstrapTable('getSelections'), function (row) {
        return row.id
    });
}