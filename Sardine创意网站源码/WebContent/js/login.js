$(function(){
	var a=0,b=0;
	$(".neirong").eq(0).focus(function(){
		$(".hint span").eq(0).html("用户名必须由字母开头，包含数字、$、下划线且不能低于6位");
		$(".hint").eq(0).addClass("hints");
		
		
	});
	
	$(".neirong").eq(0).blur(function(){
		var v = $(".neirong").eq(0).val();
		if(v==""){
			$(".hint span").eq(0).html("用户名不能为空");
		}else{
			var re = /^[a-zA-Z][a-zA-Z0-9$_]{5,}/;
			if(re.test(v)){
				a=1;
				$(".hint span").eq(0).html("");
				$(".hint").eq(0).removeClass("hints");
			}else{
				$(".hint span").eq(0).html("用户名输入不符合规范");
			}
		}
	});
	
	$(".neirong").eq(1).focus(function(){
		$(".hint span").eq(1).html("密码由数字、下划线、$组成，不能低于6位");
		$(".hint").eq(1).addClass("hints");
		
	});
	$(".neirong").eq(1).blur(function(){
		var v = $(".neirong").eq(1).val();
		if(v==""){
			$(".hint span").eq(1).html("密码不能为空");
		}else{
			var re = /[a-zA-Z0-9$_]{6,}/;
			if(re.test(v)){
				b=1;
				$(".hint span").eq(1).html("");
				$(".hint").eq(1).removeClass("hints");
			}else{
				$(".hint span").eq(1).html("密码输入不符合规范");
			}
		}
	});
	$(".button").click(function(){
		if(a!=1||b!=1){
			return false;
		}
	
		
	});
	
	
});