$(function(){
	var i = 5;
	var inter = window.setInterval(function(){
		i = i-1;
		if(i==0){
			window.location.href="/Sardine/regist.html";
			clearInterval(inter);
		}else{
			$(".time h1").html(i);
		}
		
	}, 1000);
});