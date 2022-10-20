<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../js/jquery-3.6.1.js"></script>
</head>
<body>
	<a href="front">목록</a>
	<c:forEach items="${list}" var="product">
		${product.productName}
	</c:forEach>
</body>
</html>