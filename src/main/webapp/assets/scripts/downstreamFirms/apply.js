$(function(){
	var apply = function(){
		$('#appAmt').change(function(){
			var appAmt = $('#appAmt').val();
			if(appAmt > parseFloat($('#valid_money').text())){
				alert("输入金额超过可贷金额，请重新确认。");
				return;
			}
			$('#products').empty();
			if(appAmt == ""){
				return;
			}
			$.ajax({
				type : "get",
				url : "rest/downstreamFirms/getProducts",
				data : {appAmt : appAmt},
				dataType : 'JSON',
				success : function(data, status) {
					if(status == "success"){
						if(data == ""){
							alert("当前申请金额无法匹配到融资产品。");
						}
						$.each(data, function(index, element){
							$("#products").append("<option value="+element.id+">"+element.productName + "日利率（‱):"+ element.rate + "，用款日期:" + element.useDate  +"</option>");
						});
					}
				},
				error : function(data, status) {
					alert("请求失败。");
				},
				complete : function() {

				}
			});
		});
		
		return {
			init : function(){
				
			}
		};
	}();
	apply.init();
	
});

function save(){
	var name = $('#name').val();
	var appAmt = $('#appAmt').val();
	var use_date = $('#use_date').val();
	var productId = $('#products option:selected').val();
	
	return;
	$('#btn_save').attr("disabled","disabled");
	$.ajax({
		type : "get",
		url : "rest/downstreamFirms/apply",
		data : {productId : productId, appAmt : appAmt, useDate : use_date},
		dataType : 'JSON',
		success : function(data, status) {
			$('#btn_save').removeAttr("disabled");
			if(status == "success"){
				if(data=='success'){
					alert("请求成功。");
				}else{
					alert(data);
				}
			}
		},
		error : function(data, status) {
			$('#btn_save').removeAttr("disabled");
			alert("请求失败。");
		},
		complete : function() {

		}
	});
}