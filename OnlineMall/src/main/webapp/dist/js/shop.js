window.onload=function(){
  //图片的轮播
alert('请点击图片跳转到【详情页面】')

  var lunbo1=function () {
        $('.zh1 .sh  img').attr('src','images/cn/5.jpg')
        $('.zh1 .zh ').html('奥维尼非凡系列电脑包 12.5/13.3英寸防水笔记本内胆包 联想华硕苹果')
        $('.zh1 .jg ').html('￥59.90')

        $('.zh2 .o1  img').attr('src','images/cn/6.jpg')
        $('.zh2 .o2').html('三星（SAMSUNG）110S1K-K02 11.6英寸超薄笔记本（N3050 4G 128GSSD 高清屏 核芯显卡 Win10）粉色')
        $('.zh2 .o3 ').html('￥2599.00')

        $('.zh3 .p1  img').attr('src','images/cn/7.jpg')
        $('zh3 .p2').html('联想（Lenovo）小新310经典版 14英寸笔记本电脑（i7-6500U 4G 500G 2G');
        $('zh3 .p3').html('￥4399.00')

        $('.zh4 .q1  img').attr('src','images/cn/8.jpg')
        $('.zh4 .q2').html('华硕（ASUS）R417SA/E402SA 14英寸512G纯固态办公学习笔记本电脑便')
        $('.zh4 .q3').html('￥29.90');

        $('.cnbj .cn .cn4 ul li').removeClass('bg')
        $('.cnbj .cn .cn4 ul li').eq(1).addClass('bg');
  }
  var lunbo2= function(){
        $('.zh1 .sh  img').attr('src','images/cn/9.jpg')
        $('.zh1 .zh ').html('联想（Lenovo）Flex311.6英寸超极本笔记本电脑PC平板二合一360度翻转触')
        $('.zh1 .jg ').html('￥2359.90')

        $('.zh2 .o1  img').attr('src','images/cn/10.jpg')
        $('.zh2 .o2').html('联想(Lenovo)小新Air 13.3英寸超轻薄笔记本电脑（I5-6200U 8G 256G PCIE ')
        $('.zh2 .o3 ').html('￥5999.00')

        $('.zh3 .p1  img').attr('src','images/cn/11.jpg')
        $('zh3 .p2').html('联想S41-35 14英寸笔记本电脑 AMD四核A10-8700 超薄S41-75升级 S41-');
        $('zh3 .p3').html('￥2999.00')

        $('.zh4 .q1  img').attr('src','images/cn/12.jpg')
        $('.zh4 .q2').html('联想 S436升级版 S435 14.0英寸 手提笔记本电脑超薄本 四核A8 500G硬盘')
        $('.zh4 .q3').html('￥2499.90');

        $('.cnbj .cn .cn4 ul li').removeClass('bg')
        $('.cnbj .cn .cn4 ul li').eq(2).addClass('bg');
  }
  var lunbo3=function(){
        $('.zh1 .sh  img').attr('src','images/cn/1.jpg')
        $('.zh1 .zh ').html('thinkPad 31P7410 USB光电鼠标')
        $('.zh1 .jg ').html('￥39.00')

        $('.zh2 .o1  img').attr('src','images/cn/2.jpg')
        $('.zh2 .o2').html('戴尔（DELL）MS111光电鼠标FWCMD USB')
        $('.zh2 .o3 ').html('￥69.00')

        $('.zh3 .p1  img').attr('src','images/cn/3.jpg')
        $('zh3 .p2').html('联想（Lenovo）小新310经典版 14英寸笔记本电脑（i7-6500U 4G 500G 2G');
        $('zh3 .p3').html('￥39.90')

        $('.zh4 .q1  img').attr('src','images/cn/4.jpg')
        $('.zh4 .q2').html('联想鼠标有线m120电脑鼠标有线usb光电 通用鼠标 台式机笔记本USB鼠标')
        $('.zh4 .q3').html('￥29.90');
        
        $('.cnbj .cn .cn4 ul li').removeClass('bg')
        $('.cnbj .cn .cn4 ul li').eq(0).addClass('bg');

  }
  $('.zh').mouseover(function(){
      $('.prev').show();
      $('.next').show();
    }).mouseout(function(){
      $('.prev').hide();
      $('.next').hide();
    })
  $('button').toggle(function(){
      lunbo1();
    },function(){
      lunbo2();
    },function(){
      lunbo3();
    });

    $('.cnbj .cn .cn4 ul li').eq(1).mouseover(function(){
      lunbo1();
    })
    $('.cnbj .cn .cn4 ul li').eq(2).mouseover(function () {

      lunbo2();
    })
    $('.cnbj .cn .cn4 ul li').eq(0).mouseover(function (){
      lunbo3();
    })

//全选 取消
  $('#kz').click(function(){
     var loves = document.getElementsByName('love[]');
    for(var i=0;i<loves.length;i++){
      loves[i].checked = this.checked; 
    }
      
   })
$('#zk').click(function(){
 var loves = document.getElementsByName('love[]');
for(var i=0;i<loves.length;i++){
  loves[i].checked = this.checked; 
}
  
   })
//全部商品
$('.jsbj .js .js5 .js6').click(function(){
    $('.jsbj .js5 .sjb').toggle();
    $('.jsbj .js5 .js6 .sj2').toggle('transform','rotate(360deg)');
  })

//配送至北京朝阳区
$('.cybj').mouseover(function(){
  $('.cy').css('display','block');
    
  })
$('.cybj').mouseout(function(){
    $('.cy').css('display','none');
    
  })




$('#s0').click(function(){

  $(this).css('borderColor','#EDD28B');
  $(this).css('borderWidth','2px');
  $(this).css('borderBottomColor','#FFF')
  $(this).css('borderBottomWidth','3px');

  $('#s1').css('borderColor','#CCC');
  $('#s1').css('borderWidth','1px');
  $('#s1').css('borderBottomColor','#FFF');
  $('#s1').css('borderBottomWidth','1px');

  $('#s2').css('borderColor','#CCC');
  $('#s2').css('borderWidth','1px');
  $('#s2').css('borderBottomColor','#FFF');
  $('#s2').css('borderBottomWidth','1px');

  $('.content').show();
  $('.content2').hide();
  $('.content1').hide();
})

$('#s1').click(function(){
  $('#s0').css('borderColor','#CCC');
  $('#s0').css('borderWidth','1px');
  $('#s0').css('borderBottomColor','#FFF');
  $('#s0').css('borderBottomWidth','3px');

  $('#s2').css('borderColor','#CCC');
  $('#s2').css('borderWidth','1px')
  $('#s2').css('borderBottomColor','#FFF');
  $('#s2').css('borderBottomWidth','2px');
  
  
  $(this).css('borderColor','#EDD28B');
  $(this).css('borderWidth','2px');
  $(this).css('borderBottomColor','#FFF')
  $(this).css('borderBottomWidth','3px');

  $('.content').hide();
  $('.content2').hide();
  $('.content1').show();
})
$('#s2').click(function(){
  $('#s1').css('borderColor','#CCC');
  $('#s1').css('borderWidth','1px')
  $('#s1').css('borderBottomColor','#FFF');
  $('#s1').css('borderBottomWidth','2px');
  

  $('#s0').css('borderColor','#CCC');
  $('#s0').css('borderWidth','1px')
  $('#s0').css('borderBottomColor','#FFF');
  $('#s0').css('borderBottomWidth','2px');
  



  $(this).css('borderColor','#EDD28B');
  $(this).css('borderWidth','2px');
  $(this).css('borderBottomColor','#FFF')
  $(this).css('borderBottomWidth','3px');

  $('.content').hide()
  $('.content1').hide()
  $('.content2').show()
})

//加 减
  var j=1;
  $('.z3').click(function(){
    var res=$(this).prev().val(++j);
    $('.zytp>#danji').val(j*3358);
    $('.y4>#zong').val(j*3358);
  })
  $('.z1').click(function(){
    $(this).next().val(--j);
    $('.zytp>#danji').val(j*3358);
    $('.y4>#zong').val(j*3358);
    if(j<1){
    $('.zytp>#danji').val(3358);
    $('.y4>#zong').val(3358);
      j=1;
      $(this).next().val(j);
    }
  })

$('.zytq .z5').click(function(){
  if($(this).closest('.zyt').children('.input1').find('#in').attr('checked')){
    $(this).closest('.midbj').remove()
  }
})
$('.zh .zh1').click(function(){
  $(this).siblings().css('borderColor','#CCC')
  $(this).css('borderColor','red')
  $(this).css('borderStyle','solid')

})

$('.zh .zh2').click(function(){
 
  $(this).siblings().css('borderColor','#CCC')
  $(this).css('borderColor','red')
  $(this).css('borderStyle','solid')
 
})
$('.zh .zh3').click(function(){
 
  $(this).siblings().css('borderColor','#CCC')
  $(this).css('borderColor','red')
  $(this).css('borderStyle','solid')
 
})
$('.zh .zh4').click(function(){
 
  $(this).siblings().css('borderColor','#CCC')
  $(this).css('borderColor','red')
  $(this).css('borderStyle','solid')
 
})



// --------------------------
// 地址
$("#city").click(function (e) {
  SelCity(this,e);
});

}
  