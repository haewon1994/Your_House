<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 상세페이지</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
<script type="text/javascript" src="../jquery-3.2.1.min.js"></script>
 <style type="text/css">
 
  .label_d{
  
   text-align:center;
   margin-top: 8px;
   margin-left:5px;
   margin-right:6px;
  }
 
  .div_E{
   
   margin-left:5px;
   
  }
 
  .shadow{
    box-shadow: 0 4px 5px rgba(1, 1, 1, 0.6);
  }
 
  .update_value{
  
   disabled:true;
  
  }
  
 hr{
 
  border: 1px solid black;
 
 }
 
 .Vdiv{
    margin-bottom:3px;
   
 
 }
 h5{
 
  margin-botton:2px;
 
 }
 
 </style>
      <script type="text/javascript">
    
    
       
       
   function checkValid(){
		
	 if($("input[name='noticeCategory']").val() =="")
		  alert("카테고리 값이 비었습니다");      
		  return false;
   
	 if($("input[name='isPrivate']").val() =="")
		 alert("배너 체크 여부 값이 비었습니다");      
		 return false;
  
	 if($("input[name='subject']").val() =="")
		 alert("제목 값이 비었습니다");   
		 return false;
      if($("input[name='noticeContent']").val()=="")
    	  alert("공지 내용이 비었습니다");    
    	  return false;
      
      
       return true;
	 
	 
	 /// if($("[name='notic']").val() =="")
       
      
   
   
   }
       
       
       
       
       
       
       
       
       
       
       
       
       
    
   
    
    
   
   </script>
  

          
 



</head>

    










<body>
  <jsp:include page="header.jsp"/>   
      
    <form class="container" name="updateForm"   style="border-radius: 4px ;margin-top:20px; height:300px; margin-bottom:350px;" enctype="multipart/form-data" onsubmit="return checkValid()" >
     <h1 style="font-family: Verdana, Geneva, Arial, sans-serif; margin-top:30px; margin-bottom:40px ;font-size-adjust: 50px; ">공지 등록</h1>       
      <div class="mb-3">
       <h5>공지 종류</h5> 
         <select  name="noticeCategory" class="form-select"> 
             <option value="0">--공지 종류--</option>
             <option value="공지" selected>공지</option>
             <option value="이벤트">이벤트</option>  
         </select>
      </div>   
      <div class="mb-3"> 
        <h5>공지 제목</h5>
        <input class="form-control"  name="subject" type="text"  >
      </div>
     <div class="mb-3">
      <h5 >파일 첨부</h5>
        <div class="mb-3">
           <input class="form-control"  name="noticeImage"  type="file" id="formFileMultiple" multiple >
       </div>
    </div>
    <div style="display:flex;">       
      <h5 >배너 설정</h5>
       <div class="form-check"> 
         <input class="form-check-input"  name="isPrivate"  type="checkbox" value="" id="defaultCheck1"  > 
       </div> 
     </div>
    <div class="mb-1 mt-3" style="margin-bottom:3px">
        <h5 style="margin-right:5px">공지 내용</h5>
       <textarea class="form-control update_value"  name="noticeContent"  style="border:0.2px solid black; height:200px ;width:1350px; resize:none"></textarea>
   </div>
    <button type="submit" id="submitBtn" class="btn btn-outline-dark" style="height:50px; width:100px">등록 </button>
   </form>
 
 
   
 
   
 
 
 
 
   <jsp:include page="footer.jsp"/>   
  
  
  
</body>
</html>