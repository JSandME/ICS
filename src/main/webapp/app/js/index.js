$(function() {
    App.init();

    var Index = (function() {
        var me = {};

        // 处理一级菜单点击
        me.handleMenuClick = function() {
            $('#page-sidebar-menu > li').click(function(e) {
                var menu = $('#page-sidebar-menu');
                var li = menu.find('li.active').removeClass('active');
                

                // 添加选中 打开的样式
                // $(this).addClass('active');
            });
        };

        // 处理子菜单点击
        me.handleSubMenuClick = function() {
            $('#page-sidebar-menu li a').click(function(e) {
                e.preventDefault();
                var url = this.href;
                var text = this.text.trim();
                if (url != null && url != 'javascript:;') {
                    $.get(url, function(data) {
                    	//changeTitelAndBreadcrumb(text);
                        $('#main-content').html(data);
                    });
                }
            });
        };
        
     // 处理Breadcrumb点击
        me.handleBreadcrumbClick = function() {
            $('#breadcrumb a').click(function(e) {
                e.preventDefault();
                var url = this.href;
                //alert(url);
                if (url != null && url != 'javascript:;') {
                    $.get(url, function(data) {
                        $('#main-content').html(data);
                    });
                }
            });
        };
        //切换Breadcrumb page title
        function changeTitelAndBreadcrumb(text){
        	var selectMenu = $('#page-sidebar-menu > li.open a');
        	var selectSubMenu = $('#page-sidebar-menu > li.open ul.sub-menu');
        	selectSubMenu.find('li').each(function(){
        	    if($(this).text().trim() == text){
        	    	$('.page-breadcrumb, .breadcrumb > i.fa').html(selectMenu.html()).append('<i class="fa fa-angle-right"></i>').append($(this).html());
        	    	$('#index-page-title').html($(this).text());
        	    	return;
        	    }
        	    //alert(selectMenu.html());
        	    $('#breadcrumb').html(selectMenu.html());
    	    	//$('#index-page-title').html($(this).text());
        	});
        }

        me.init = function() {
            me.handleMenuClick();
            me.handleSubMenuClick();
            me.handleBreadcrumbClick();
        };

        return me;
    })();

    Index.init();

    $('#btn-dashboard').trigger("click");
});