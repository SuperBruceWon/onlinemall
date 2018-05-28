window.onload=function(){

	// 产品介绍

	// $('#counm ul li').click(function(){
		 
	// 	$('#counm ul li').removeClass('hover')
	// 	$(this).addClass('hover')
		 
			
	// 	$('#counm>div').hide();
	// 	$('#counm>div').eq($(this).index()).show();
	// 	var T=$('#counm>div').eq($(this).index()).offset().top;
	// 	var H=$('#counm>div').eq($(this).index()).height();

	// 	$('.cont .right .rightb1').css({top:H+T})
	// })
	// $('#counm ul li').eq(6).mouseover(function(){

	// })




	$('#counm ul li').click(function(){
		 
		$('#counm ul li').removeClass('hover')
		$(this).addClass('hover')
		 
			
		$('#chang-tu>div').hide();
		$('#chang-tu>div').eq($(this).index()).show();
		var T=$('#chang-tu>div').eq($(this).index()).offset().top;
		var H=$('#chang-tu>div').eq($(this).index()).height();

		$('.cont .right .rightb1').css({top:H+T})
	})
	$('#counm ul li').eq(6).mouseover(function(){

	})
// ----------------------------------------------------------------
	//推荐配件
	$('.mt #yh').click(function(){
		$('.mt #yh').removeClass('hovermt')
		$(this).addClass('hovermt')
		 
	})
	// --------------------------------------------------------------
	// 滚动条移动永远不隐藏
	 // var a = $(document).scrollTop();

	  $(document).scroll(function(){
	  	var a=$(this).scrollTop();
	    if(a>=1154){
	    $('#counm .ul1').show();
	    $('#counm .ul1').css({top:a});
	    var b=$('#counm .ul1').offset().top;
	   
	    $('.cont .apple1').show();	
	  	$('.cont .apple').css({top:a});
	  	var c=$('.cont .apple').offset().top;
	  	console.log(a+'--'+b+'--'+c );
	  	 
	  	 

	  }else{
	  	 $('#counm .ul1').css({top:0});	
	  	$('.cont .apple').css({top:1153});
	  }
	 });
	 


// ----------------------------------------------------------------
	// 放大镜
	


	$('.big-img').mouseover(function(){

		$('.shade').show();
		
		var bigO=$(this).offset();
		var bigM=$(this).attr('MarginTop');
		
		var bigW=$(this).width();
		$('.show').css({left:bigW+27,top:bigM})
		$('.show').show();

	}).mouseout(function(){
		$('.shade').hide();
		$('.show').hide();
	}).mousemove(function(e){
		var bigW=$(this).width();
		//获取小图的位置 
		var bigO=$(this).offset();

		var smallLeft=e.pageX-bigO.left;
		var smallTop=e.pageY-bigO.top;
		//阴影的宽度 
		var shadeW=$('.shade').width();
		//阴影的定位是：
		var Left=smallLeft-shadeW/2;
		var Top=smallTop-shadeW/2;

		$('.shade').css({left:Left,top:Top})

		//展示的定位是阴影的2.286倍
		$('.show').scrollTop(smallTop*2.286-200).scrollLeft(smallLeft*2.286-200);
		//判断阴影的边界问题
		if(Left<14){
			Left=14;

		}
		if(Left>204){
			Left=204
		}
		if(Top<15){
			Top=15
		}
		if(Top>204){
			Top=204
		}
		 
		$('.shade').css({left:Left,top:Top});


	});


	$('.smallimg').mouseover(function(){
		$(this).css({'border-color':'red' });
		 
		 
	}).mouseout(function(){
		$(this).css({'border-color':'#fff' });
	})
	$('.smallimg').eq(0).click(function(){
		 
		$('.big-img').find('img').attr('src','images/big-img/b1.jpg')
		$('.show img').attr('src','images/big-img/show1.jpg')
	})
	$('.smallimg').eq(1).click(function(){
		 
		$('.big-img').find('img').attr('src','images/big-img/b2.jpg')
		$('.show img').attr('src','images/big-img/show2.jpg')
	})
	$('.smallimg').eq(2).click(function(){
		 
		$('.big-img').find('img').attr('src','images/big-img/b3.jpg')
		$('.show img').attr('src','images/big-img/show3.jpg')
	})


//--------------------------

	// 选择属性
	var colorspan = document.getElementById('xzcolor').getElementsByTagName('span');
	var pzspan = document.getElementById('pz').getElementsByTagName('span');
	var zzbzspan = document.getElementById('zzbz').getElementsByTagName('span');
	var xztzspan = document.getElementById('xztz').getElementsByTagName('span');
	// 所有的span
	var Span = document.getElementById('shuxing1').getElementsByTagName('span');

	var xzcolor=document.getElementById('xzcolor')
	var pz=document.getElementById('pz')	

	 colorspan[0].className="on"
	 pzspan[0].className="on"
	 zzbzspan[0].className="on"
	 xztzspan[0].className="on"

	for(var i=0;i<Span.length;i++){
	 	Span[i].onclick=function(){
	 		 //alert()
	 		var siblings = this.parentNode.children;
	 		// console.log(siblings.length)
	 		for(var j=0;j<siblings.length;j++){

	 			siblings[j].className='';

	 		}
	 		this.className='on';
	 		if ( this.parentNode == xzcolor || this.parentNode == pz )
				{
					price();
				}
				 
	 	}
	}
	var p1 = 9288;
	function price(){
		
		console.log(p1)
		for (var i=0;i<pzspan.length;i++ )
		{
			// console.log(pzspan.length)
			if ( pzspan[i].className == 'on' )
			{
				p1 = i?11288:9288;
				break;
			};


		};
		 
		// console.log(p1)
			 
		$('#p').html(p1)
	};


// ------------------------------------------结束


//数量变化
 
	 	// var f;
		var i = $('.num input').val();	
		//点击减少的按钮时候：
		$('.dec').on('click',function(){
			i--;

			if(i<1) i=1;

			 onchange(i)

			 

			 
			 	
			 	// $(this).off('click')
		     $('#p').html(p1*i)
			  
		})
		//点击增加到按钮时候：
		$('.add').on('click',function(){

			onchange(++i)

			$('#p').html(p1*i)
		})
		 
		//数量变化的函数 
		function onchange(){
	
			$('.num input').val(i)
			 		 
		}
		//鼠标离开时blur
		$('.num input').blur(function(){
			i = $('.num input').val();
			$('.num input').attr('value',i)
		 
			onchange();

		});

 	  
// --------------------------
// 地址
$("#city").click(function (e) {
	SelCity(this,e);
});



		 
	 

		 
		 
		


}