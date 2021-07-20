// <!-- top 스르르르르륵 올라가는거임 -->
$(document).ready(function() {
	$(window).scroll(function() {
		if ($(this).scrollTop() > 500){
			$('.top').fadeIn();
		}else
			$('.top').fadeOut();
	})

	$('.top').click(function() {
		$('html, body').animate({ scrollTop: 0 }, 200);
		return false;
	});

});


