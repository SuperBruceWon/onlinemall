				var index = -1;
				var Play = null;
				$(".button li").mouseover(function() {
					clearInterval(Play);//禁止定时器
					index = $(this).index();
					
					$(this).addClass("hover").siblings().removeClass("hover");
					$(".flash img").eq(index).show().siblings("img").hide();
				}).mouseout(function() {//鼠标移开之后
					autoPlay();
				});

				function autoPlay() {
					Play = setInterval(function() {//设置定时器
						
						index++;
						if (index > 3) {
							index = -1;
						} else {
							$(".button li").eq(index).addClass("hover")
									.siblings().removeClass("hover");
							$(".flash img").eq(index).show().siblings("img")
									.hide();
						}
					}, 1500);
					index++;
					$(".button li").eq(index).addClass("hover").siblings()
							.removeClass("hover");
					$(".flash img").eq(index).show().siblings("img").hide();
				}
				autoPlay();