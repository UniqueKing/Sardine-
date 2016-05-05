$(function(){
	if($('#gla')){
		$('.gla_inbox').corner('8px');
		$('#gla_box>ul').roundabout({
			minOpacity:1,
			btnNext: ".next",
			duration: 1000,
			reflect: true,
			btnPrev: '.prev',
			autoplay:true,
			autoplayDuration:5000,
			tilt:0,
			shape: 'figure8'
		});
	}
});