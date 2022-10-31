<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>

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
 
  
 
 
 
 </style>
 




</head>


<body>

   <jsp:include page="header.jsp"/>
     
    
   <form class="container"  style="border-radius: 4px ;margin-top:50px; height:400px; margin-bottom:200px" enctype="multipart/form-data" action="admin?key=adminProduct&methodName=insertTotalProduct" method="post">
     <h1 style="font-family: Verdana, Geneva, Arial, sans-serif; margin-top:30px; margin-bottom:40px ;font-size-adjust: 50px; color: blue ">상품 등록</h1>
     <div style="display:flex; text-align:center; margin-top:8px"> 
     <label class="label_d">카테고리명:</label>
       <div class="form-floating">
         <select class="form-select" name="categoryCode" id="floatingSelect"    aria-label="Floating label select example" style="height:40px; width:220px; "> 
          <c:forEach items="${categoryList}" var="cat">
             <option value="${cat.categoryCode}"> ${cat.categoryName} </option> 
          </c:forEach> 
        </select>
       </div>
      <label class="label_d">상품명:</label>
      <input class="form-control" name="productName" type="text" placeholder="Default input" aria-label="default input example" style="width:190px; ">
      <label class="label_d">가격:</label>
      <input class="form-control" name="price" type="text" placeholder="Default input" aria-label="default input example" style="width:190px; "> 
      <label class="label_d">재고량:</label>
      <input class="form-control" name="stock" type="text" placeholder="Default input" aria-label="default input example" style="width:190px;"> 
      <label class="label_d">색상:</label>
      <input class="form-control" name="colorName" type="text" placeholder="Default input" aria-label="default input example" style="width:190px;">  
    </div>
    <div class="mb-3" style="margin-left:5px" >
          <label for="formFileMultiple" class="form-label" style="font-size:18px; margin-top:5px;  ">대표 이미지</label>
          <input type="file" name="image">
   </div>
   <div class="mb-3" style="margin-left:5px">
          <label for="formFileMultiple" class="form-label" style="font-size:18px; margin-top:5px">추가 이미지</label>
          <input type="file" name="fileName">
   </div>
   <div class="mb-5" style="margin-left:5px; margin-bottom:3px ">
     <label for="exampleFormControlTextarea1" class="form-label" style="font-size:18px">상품 상세설명</label>
     <textarea class="form-control" name="productDetail" style="border:0.2px solid black;" id="exampleFormControlTextarea1" rows="5" style="margin-bottom:10px" ></textarea>
   </div>
    <button style="margin-top:0px" class="btn btn-outline-dark">등록</button>
 
 </form>

  
 
 <jsp:include page="footer.jsp"/>
 
 
</body>
</html>