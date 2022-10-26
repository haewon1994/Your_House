<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-3.6.1.js"></script>
<script type="text/javascript">
	$(function() {
		$("#btn").click(function() {
			alert($(this).val());
			$.ajax({
				url : "ajax", // 서버의 주소
				type : "get", // 요청방식(method방식 = post, get, put, delete 등등)
				dataType : "text", // 서버가 보내온 데이터타입(디폴트 text, html, xml, json)
				data : {
					productCode : $(this).val(),
					odrerQty : 2,
					colorName : "노란색",
					key : $("#key").val(),
					methodName : $("#methodName").val()
				}, // 서버에게 보낼 parameter 정보
				success : function(result) {
					location.href="basket/basket.jsp";
				},
				error : function(err) {
					// 서버의 요청결과가 실패했을 때 콜백함수	
				}
			});
		});
	});
</script>
</head>
<body>
	<a href="front">전체검색</a><p>
		<c:forEach items="${list}" var="product">
		<input type="hidden" id="key" value="basket">
		<input type="hidden" id="methodName" value="insert">
		${product.productName} <button id="btn" value="${product.productCode}">장바구니 담기</button>
	</c:forEach>
	
	<hr>
	
	<form action="front?key=product&value=selectByProductCode">
		상품코드 : <input type="text" name="productCode" id="productCode">
		<input type="submit">
	</form>
	<h6>번호검색 : ${product.productName}</h6>
	
	<hr>
	
	<a href="basket/basket.jsp">장바구니</a>
</body>
</html>