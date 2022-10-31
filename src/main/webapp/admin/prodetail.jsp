<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

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
  
  
  
 
 </style>
 

</head>


<body>
  <jsp:include page="header.jsp"/>   
    
    <form class="container"   name="updateForm" style="border-radius: 4px ;margin-top:50px; height:400px; margin-bottom:270px" onsubmit="return check()" 
     enctype="multipart/form-data" action="admin?key=adminProduct&methodName=updateProductByProductCode" method="post">
     <h1 style="font-family: Verdana, Geneva, Arial, sans-serif; margin-top:30px; margin-bottom:40px ;font-size-adjust: 50px; ">상품 상세</h1>
     <div style="display:flex; text-align:center; margin-top:8px">   
        <label class="label_d">카테고리:</label> 
       <div id="category1">
             <input class="form-control update_value"  type="text"  aria-label="default input example" style="width:190px;" disabled>  
       </div>
       <div id="categorys" class="form-floating" style="display:none">  
             <select class="form-select update_value" name="categoryCode" aria-label="Floating label select example" style="height:40px; width:160px;">
             <option selected value="${product.categoryCode}">${product.categoryName}</option>
             <option>--카테고리 선택--</option>
                 	<c:forEach items="${categoryList}" var="cat">
             <option value="${cat.categoryCode}"> ${cat.categoryName} </option> 
          			</c:forEach> 
             </select>  
        </div>
       <input type="hidden" name="productCode" value="${product.productCode}" />
       <label class="label_d" >상품명:</label>
       <input class="form-control update_value"  name="productName"  type="text" aria-label="${product.productName}" style="width:190px;" disabled value="${product.productName}"    >
       <label class="label_d">가격:</label>
       <input class="form-control update_value"  name="price"  type="text" aria-label="${product.price}" style="width:190px;" disabled value="${product.price}" > 
       <label class="label_d">재고량:</label>
       <input class="form-control update_value"  name="stock"  type="text" aria-label="${product.stock}" style="width:190px;" disabled value="${product.stock}">   
       
           <label class="label_d" id="coror_l">색상:</label>
            <div id="colors" class="form-floating">
               <select class="form-select update_value"  aria-label="Floating label select example" style="height:40px; width:160px;">
                  <option selected value="${colorList[0].colorCode}">${colorList[0].colorName}</option>
                  <option> --색상을 확인해주세요-- </option>
                  <c:forEach items="${colorList}" var="col">
             <option value="${col.colorCode}"> ${col.colorName} </option> 
          			</c:forEach> 
             </select>  
         </div>
      
      </div> 
   
     <div id="uplaodedImage" style="margin-top:20px">
       <label style="font-size:18px">상품 이미지 파일명</label>
        <div   class="list-group" > 
           <a href="#" class="list-group-item list-group-item-action list-group-item-primary" >대표 이미지: ${product.image}</a> 
           <a href="#" class="list-group-item list-group-item-action list-group-item-success">보조 이미지: ${productImageList[0].fileName}</a>
         </div> 
      </div>
         <div id="uplaodImage" style="display:none"> 
           <div>
           <label for="formFileMultiple" class="form-label" style="font-size:18px; margin-top:5px;  ">대표 이미지: </label>
          </div>
         <div class="mb-3" style="margin-left:5px" >
            <input class="form-control" name="image" style="border:1px solid black;"  type="file" id="formFileMultiple">
         </div>
          <div>
             <label for="formFileMultiple" class="form-label" style="font-size:18px; margin-top:5px">추가 이미지</label>
         </div>
         <div class="mb-3" style="margin-left:5px"> 
             <input class="form-control" name="fileName"  style="border:1px solid black;" type="file" id="formFileMultiple" >
         </div>
         <div><input type="hidden" name="imageCode" value="${productImageList[0].imageCode}"> </div>
     </div>
        
   <div class="mb-5 mt-3" style="margin-left:5px; margin-bottom:3px ">
     <label for="exampleFormControlTextarea1" class="form-label" style="font-size:18px">상품 상세설명</label>
     <textarea class="form-control update_value" name="productDetail" style="border:0.2px solid black; width:1345px; height:200px; resize:none" id="exampleFormControlTextarea1" rows="5" style="margin-bottom:10px" disabled >${product.productDetail}</textarea>
   </div>
    <button type="button" id="ableBtn" class="btn btn-outline-success" style="margin-top:0px  ;height:50px; width:100px;  text-align: center; display:block"  >수정하기</button>
    <button type="submit" id="updateBtn" class="btn btn-outline-primary" style="display:none; height:50px; width:100px">수정완료</button>
   </form>
  
 
 
 
   <jsp:include page="footer.jsp"/>   
  
   <script type="text/javascript">
    
   $("#ableBtn").click(function() {  
	   $(".update_value").attr("disabled",false);
       $("h1").html("상품 수정"); 
       $("h1").css("color","blue")
       $(this).hide();//버튼 숨기기
   
       
       $("#uplaodedImage").css("display","none");//업로드 된 이미지 없애기
        
      
       //업로드 할 이미지 받기
       $("#updateBtn").css("display", "block");   
       $("#uplaodImage").css("display","block");
       
       
       $("label_d").eq(5).css("display","block");   
      
       //카테고리스가
            
       $("#category1").css("display","none");
       $("#categorys").css("display","block");
       
    
       $("#colors").css("display","none"); 
       $("#color1").css("display","block"); 
       $("#coror_l").css("display","none");
   
   
   
   })
   
 
   
   /*
   
   
    <div class="mb-3" style="margin-left:5px">
    <div class="mb-3" style="margin-left:5px" >
      <label for="floatingTextarea" style="font-size:18px">대표 이미지명</label>
      <textarea class="form-control" placeholder="Leave a comment here" id="floatingTextarea" style="height:40px; width:500px; resize:none"><a>ssss</a></textarea>
      </div>   
      <div class="mb-3" style="margin-left:5px; margin-bottom: 5px">
      <label for="formFileMultiple" class="form-label" style="font-size:18px; margin-top:5px">추가 이미지</label>
       <textarea class="form-control" placeholder="Leave a comment here" id="floatingTextarea" style="height:40px; width:500px; resize:none"></textarea>
     </div>
   
   
   
   
   
   */
   
   
   
   
   
   </script>
  
  
</body>
</html>