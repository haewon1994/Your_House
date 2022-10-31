<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>

</head>

<jsp:include page="header.jsp"/>
<body>
  <div style="height:600px; margin-top:20px; margin-bottom:30px " >
  <table class="table table-hover container">
        <thead>
          <tr>             
            <th>상품 카테고리</th>
            <th>상품코드</th>
            <th>상품이름</th>
            <th>등록일</th>
            <th>가격</th>
            <th>재고수량</th>
          </tr>
        </thead>
        <tbody>
        <c:forEach items="${productList}" var="plist">
          <tr>
            <td>${plist.categoryName}</td>
            <td><a href="${pageContext.request.contextPath}/admin?key=adminProduct&methodName=selectDetailTotalProductByProductCode&productCode=${plist.productCode}">
				${plist.productCode}</a></td>
            <td><a href="${pageContext.request.contextPath}/admin?key=adminProduct&methodName=selectDetailTotalProductByProductCode&productCode=${plist.productCode}">
            	${plist.productName}</a></td>
            <td>${plist.createdReg}</td>
            <td>${plist.price}</td>
            <td>${plist.stock}</td>
          </tr>
        </c:forEach>
        </tbody>
      </table>
    </div>
    <jsp:include page="footer.jsp"/>
</body>
</html>