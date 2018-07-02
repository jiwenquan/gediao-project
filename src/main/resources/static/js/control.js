function activeMe(el){
	//$("a", $("#topmenuul")).removeClass("ch4-active");
//	$(el).addClass("ch4-active").siblings().removeClass('ch4-active');
} 

function calculateLoginPageSize(){
	    var heightget = $(window).height();
		// var widthget = $(window).width();
		//登陆页宽高计算
		$('.loginbox').height(heightget);
		// $('.lgbox1').width(widthget-700+'px');
		var a = (heightget-461)/2;
//		$('.lg-mid').css('margin-top',a);
		//背景box min-height
		var b = heightget-60;
		$('.bgbox').css('min-height',b);
	/*	//项目面板 模块宽度计算
		var c = widthget-200-20-20-285-285-20;
		$('.dash2').width(c);*/
}
// JavaScript Document
$(document).ready(function(e) {

	calculateLoginPageSize();
	window.onresize = function(){calculateLoginPageSize();}

	//项目标签显示隐藏
//	$('.dashname2').hover(function(){
//		$('.ch3 ul').show();
//		},function(){
//			$('.ch3 ul').hide();
//	});
	//项目面板tab
	$('.dash-title2 ul li').click(function(){
		$(this).addClass('dash2-active').siblings().removeClass('dash2-active');
		var d = $(this).index();
		$('.dash2-c').eq(d).show().siblings('.dash2-c').hide();
	})
	// //br页面tab
	// $('.br-title ul li').click(function(){
	// 	$(this).addClass('br-title-active').siblings().removeClass('br-title-active');
		// var d = $(this).index();
		// $('.br-tabbox').eq(d).show().siblings('.br-tabbox').hide();
	// });
	$('.br-btn-dele').click(function(){
		$(this).parents('li').remove();
		});
	
	$('.lsxbox2 a').click(function(){
		$('.editbox').show();
		})
//	$('.lsx-btn a').click(function(){
//		$('.editbox').hide();
//		})
	$('.td-yq').click(function(){
		$('.editbox').show();
		})
//	$('.td-qx').click(function(){
//		$('.editbox').hide();
//		})
	
	//Sprint 项目成员  考勤tab跳转
	$('.br-title ul li').click(function(){
		$(this).addClass('br-title-active').siblings().removeClass('br-title-active');
		var d = $(this).index();
		$('.br-tabbox').eq(d).show().siblings('.br-tabbox').hide();
	});

	
	$('.closebutton').click(function(){
		$('.storyshow').hide();
	})
	$('.closepie').click(function(){
		$('.pieshow').hide();
	})
	$('.closeAssigneepie').click(function(){
		$('.pieAssignshow').hide();
	})
	

	//header菜单点击高亮
	$('.ch4 ul li').click(function(){
//		var d = $(this).index();
		$(this).addClass('ch4-active');
		$(this).siblings().removeClass('ch4-active');
	})

	
});



