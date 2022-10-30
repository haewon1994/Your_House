<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
	crossorigin="anonymous"></script>
<script type="text/javascript" src="../js/jquery-3.6.1.min.js"></script>




<style>
.centers {
	width: 850px;
	height: 400px;
	margin-top: 150px;
	padding-right: 0px;
	padding-left: 0px;
}

.navi {
	width: 100%;
	height: 50px;
	margin-left: 0px;
	margin-right: 0px;
}

.img_in {
	height: 300px;
	width: 400px;
	margin-top: 50px;
	border-radius: 10px;
	border-radius: 7px;
}

.input_setting {
	width: 410px;
}

.fon {
	font-family: Georgia, "Malgun Gothic", serif;
	font-weight: 400;
	font-family: Lorem Ipsum Dolor;
}

.img_k {
	width: 100%;
	height: 100%;
	border-radius: 7px
}
</style>


<script type="text/javascript">
 
  

  
  $(function() {
	
		    document.
		    getElementById("imgBuff").
	        addEventListener("change",function(e){	
	         
	         let imgEle =document.getElementById("img_in");	 
	        	
	          if(!e.target.files[0]){
	        	  imgEle.src="../images/uploads.jpg" 
	        	  return;
	          }
	        	
	           let divEle  = document.getElementById("img_div")
	                   
	           let imgFile	 =e.target.files[0]; 
	           let url  =URL.createObjectURL(imgFile);  
	           imgEle.src=url;
	      
	        },false); 
 
  
  
  })
 
 
   
  
  
  
 
 
 </script>

</head>
<body>
	<jsp:include page="../common/header.jsp" />

	<form name=updateForm method=post enctype="multipart/form-data" action="${path}/front?key=story&methodName=insert" onSubmit="return checkValid()">
   
 글입력:<textarea name="s toryLiter" cols="50" rows="10"></textarea>
        <input type=file>
      <input type="submit" value="수정하기">
</form>







</body>

</html>