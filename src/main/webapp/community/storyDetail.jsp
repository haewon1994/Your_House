<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../common/header.jsp"/> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===================================================================================-->	
	<link rel="icon" type="image/png" href="${pageContext.request.contextPath}/images/icons/favicon.png"/>
<!--===================================================================================-->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===================================================================================-->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/fonts/iconic/css/material-design-iconic-font.min.css">
<!--===================================================================================-->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/fonts/linearicons-v1.0.0/icon-font.min.css">
<!--==================================================================================-->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/vendor/animate/animate.css">
<!--==================================================================================-->	
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/vendor/css-hamburgers/hamburgers.min.css">
<!--==================================================================================-->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/vendor/animsition/css/animsition.min.css">
<!--==================================================================================-->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/vendor/select2/select2.min.css">
<!--===================================================================================-->	
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/vendor/daterangepicker/daterangepicker.css">
<!--===================================================================================-->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/vendor/slick/slick.css">
<!--==================================================================================-->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/vendor/MagnificPopup/magnific-popup.css">
<!--==================================================================================-->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/vendor/perfect-scrollbar/perfect-scrollbar.css">
<!--=================================================================================-->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/util.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/reset.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
<!--================================================================================-->
<style type="text/css">
.zipfollowing {
	color: #5a8742; font-size: 20px; font-weight: bold; text-shadow: black;
}

.contents {
    max-width: 600px;	
}

#main_container {
	padding: 70px 0px;
}

.w-full
{padding-top: 60px;}
</style>
<script type="text/javascript" src="../js/jquery-3.6.1.js"></script>
<script type="text/javascript">
	$(function() {
		$("#replyInsert").click(function() {
			let storyCode = $("#story_code").val();
			let replyContent = $("#reply_content").val();
			
			$.ajax({
				url : "../ajax",
				type : "post",
				dataType : "text",
				data : {
					key:'reply',
					methodName :'insert',
					story_code : storyCode,
					reply_content : replyContent
				},
				success : function(result) {
					alert(result);
					
				},
				error : function() {
					
				}
			});
		});
	});
</script>
</head>
<body>	

<input type="hidden"id="story_code" value="${requestScope.story.storyCode}">
<section id="container">

  <div id="main_container">
     <section class="c_inner">
         <div class="contents_box">
             <article class="contents cont01">
                <img src="${pageContext.request.contextPath}/images/story001.jpg" 
                	alt="" style="width: 600px; height: 600px;">
             </article>
             <p>스토리 작성 내용을 출력합니다.</p>
         </div>
      
         <!-- 댓글 -->
	<div class="flex-w flex-t p-b-68">
	<div>
	    <div class="wrap-pic-s size-109 bor0 of-hidden m-r-18 m-t-6">
	        <img src="${pageContext.request.contextPath}/images/profile001.jpg" alt="USER001">
	    </div>
	
	    <div class="size-207">
	        <div class="flex-w flex-sb-m p-b-17">
	            <span class="mtext-107 cl2 p-r-20" alt="닉네임">
	                minj***
	            </span>
	        </div>
	
	        <p class="stext-102 cl6">
	            댓글내용입니다.
	        </p>
	    </div>
	    </div>
	</div>
	
	<!-- 댓글작성 -->
	<form class="w-full">
	    <p style="font-weight: bold;">
	        댓글작성
	    </p>
	
	    <div class="flex-w flex-m p-t-50 p-b-23">
	        <div class="wrap-pic-s size-109 bor0 of-hidden m-r-18 m-t-6">
	        <img src="${pageContext.request.contextPath}/images/profile001.jpg" 
	        alt="USER001_s">
	    	</div>
	    	
	    	<div class="size-207">
	        <div class="flex-w flex-sb-m p-b-17">
	            <span class="mtext-107 cl2 p-r-20" alt="닉네임">
	                minj***
	            </span>
	        </div>
	    </div>
	
	    </div>
	
	    <div class="row p-b-25">
	        <div class="col-12 p-b-5">
	            <input class="size-110 bor8 stext-102 cl2 p-lr-20 p-tb-10" id="reply_content" name="reply_content" 
	            placeholder="칭찬과 격려의 댓글은 작성자에게 큰 힘이 됩니다 :)" style="font-size: 12px;"></input>
	        </div>	
	    </div>
	
	        <button class="flex-c-m stext-101 cl0 size-112 bg7 bor11 hov-btn3 p-lr-15 trans-04 m-b-10" id="replyInsert">
	            등록
	        </button>
	    </form>
	 </div>
				
     </section>
  </div>
 
 
</section>
				
<!--===============================================================================================-->	
	<script src="${pageContext.request.contextPath}/vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
	<script src="${pageContext.request.contextPath}/vendor/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
	<script src="${pageContext.request.contextPath}/vendor/bootstrap/js/popper.js"></script>
	<script src="${pageContext.request.contextPath}/vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->

	<script language=javascript>
		$(".js-select2").each(function(){
			$(this).select2({
				minimumResultsForSearch: 20,
				dropdownParent: $(this).next('.dropDownSelect2')
			});
		})
	</script>
<!--===============================================================================================-->
	<script src="${pageContext.request.contextPath}/vendor/daterangepicker/moment.min.js"></script>
	<script src="${pageContext.request.contextPath}/vendor/daterangepicker/daterangepicker.js"></script>
<!--===============================================================================================-->
	<script src="${pageContext.request.contextPath}/vendor/slick/slick.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/slick-custom.js"></script>
<!--===============================================================================================-->
	<script src="${pageContext.request.contextPath}/vendor/parallax100/parallax100.js"></script>
	<script>
        $('.parallax100').parallax100();
	</script>
<!--===============================================================================================-->
	<script src="${pageContext.request.contextPath}/vendor/MagnificPopup/jquery.magnific-popup.min.js"></script>
	<script>
		$('.gallery-lb').each(function() { // the containers for all your galleries
			$(this).magnificPopup({
		        delegate: 'a', // the selector for gallery item
		        type: 'image',
		        gallery: {
		        	enabled:true
		        },
		        mainClass: 'mfp-fade'
		    });
		});
	</script>
<!--===============================================================================================-->
	<script src="${pageContext.request.contextPath}/vendor/isotope/isotope.pkgd.min.js"></script>
<!--===============================================================================================-->
	<script src="${pageContext.request.contextPath}/vendor/sweetalert/sweetalert.min.js"></script>
	<script language=javascript>		
		/*장바구니*/
		$('.js-addcart').each(function(){
			var nameProduct = $(this).parent().parent().parent().parent().find('.js-name-detail').html();
			$(this).on('click', function(){
				swal(nameProduct, "장바구니에 담았습니다.", "success");
			});
		});
		
		/*---------------------------------------------*/
		/*구매하기*/
	
	</script>
<!--===============================================================================================-->
	<script src="${pageContext.request.contextPath}/vendor/perfect-scrollbar/perfect-scrollbar.min.js"></script>
	<script>
		$('.js-pscroll').each(function(){
			$(this).css('position','relative');
			$(this).css('overflow','hidden');
			var ps = new PerfectScrollbar(this, {
				wheelSpeed: 1,
				scrollingThreshold: 1000,
				wheelPropagation: false,
			});

			$(window).on('resize', function(){
				ps.update();
			})
		});
	</script>
<!--===============================================================================================-->
	<script src="${pageContext.request.contextPath}/js/main.js"></script>
	<script>
	    $('.btn-number-product-down').on('click', function(){
	        var numProduct = Number($(this).next().val());
	        if(numProduct > 0) $(this).next().val(numProduct - 1);
	    });
	
	    $('.btn-number-product-up').on('click', function(){
	        var numProduct = Number($(this).prev().val());
	        $(this).prev().val(numProduct + 1);
	    });
	</script>
<!--===============================================================================================-->


</body>
</html>
<jsp:include page="../common/footer.jsp"/>