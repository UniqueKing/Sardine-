		$(function(){
			var u=0,p=0,rp=0,ph=0;
			//验证码
			$(".code").click(function(){
				$(this).attr("src","/Sardine/check?a="+new Date().getMilliseconds());	
			});
			
			//隐藏内容，或提示
			var username = '用户名必须由字母开头，包含数字、$、下划线且不能低于6位';
			var password = '密码由数字、下划线、$组成，不能低于6位';
			var repsd = '再次输入密码';
			var phone = '请输入手机号';
			var namek = '用户名不能为空';
			//用户名
			$(".tianxieneirong").eq(0).focus(function(){
				$(".check").eq(0).html("");
				$(".dui").eq(0).hide();
				$(".hint > div").eq(0).html(username);
			});
			$(".tianxieneirong").eq(0).blur(function(){
				$(".hint > div").eq(0).html("");
				if($(this).val()==""){
					$(".check").eq(0).html("用户名不能为空");
				}else{
					var user = $(this).val();
					var re = /^[a-zA-Z][a-zA-Z0-9$_]{5,}/;
					if(re.test(user)){
						u=2;
						$(".dui").eq(0).show();
					}else{
						$(".check").eq(0).html("用户名输入不符合规范");
					}
				}
			});
			//密码
			$(".tianxieneirong").eq(1).focus(function(){
				$(".check").eq(1).html("");
				$(".dui").eq(1).hide();
				$(".hint > div").eq(1).html(password);
			});
			$(".tianxieneirong").eq(1).blur(function(){
				$(".hint > div").eq(1).html("");
				if($(this).val()==""){
					$(".check").eq(1).html("密码不能为空");
				}else{
					var user = $(this).val();
					var re = /[a-zA-Z0-9$_]{6,}/;
					if(re.test(user)){
						p=2;
						$(".dui").eq(1).show();
					}else{
						$(".check").eq(1).html("密码输入不符合规范");
					}
				}
			});
			//再次输入密码
			$(".tianxieneirong").eq(2).focus(function(){
				$(".check").eq(2).html("");
				$(".dui").eq(2).hide();
				$(".hint > div").eq(2).html(repsd);
			});
			$(".tianxieneirong").eq(2).blur(function(){
				$(".hint > div").eq(2).html("");
				if($(this).val()==""){
					$(".check").eq(2).html("密码不能为空");
				}else{
					var user = $(this).val();
					var re = /[a-zA-Z0-9$_]{1,}/;
					if(re.test(user)){
						if($(this).val()==$(".tianxieneirong").eq(1).val()){
							rp=2;
							$(".dui").eq(2).show();
						}else{
							$(".check").eq(2).html("与上面输入的密码不一致");
						}
					}else{
						$(".check").eq(2).html("密码输入不符合规范");
					}
				}
			});
			//手机号
			$(".tianxieneirong").eq(3).focus(function(){
				$(".check").eq(3).html("");
				$(".dui").eq(3).hide();
				$(".hint > div").eq(3).html(phone);
			});
			$(".tianxieneirong").eq(3).blur(function(){
				$(".hint > div").eq(3).html("");
				if($(this).val()==""){
					$(".check").eq(3).html("手机号不能为空");
				}else{
					var user = $(this).val();
					var re = /[1][3,5,7,8]\d{9}$/;
					if(re.test(user)){
						ph=2;
						$(".dui").eq(3).show();
					}else{
						$(".check").eq(3).html("手机号输入不符合规范");
					}
				}
			});
			//验证码
			$(".tianxieneirong").eq(4).focus(function(){
				$(".hint > div").eq(4).html("请输入验证码");
			});
			$(".tianxieneirong").eq(4).blur(function(){
				$(".hint > div").eq(4).html("");
			});
			
			//注册按钮
			$(".zcbutton").click(function(){
				if($(".tianxieneirong").eq(4).val()==""){
					$(".hint > div").eq(4).html("验证码不能为空");
					return false;
				}
				if(u!=2||p!=2||rp!=2||ph!=2){
					return false;
				}
			});
			
			
		});
	