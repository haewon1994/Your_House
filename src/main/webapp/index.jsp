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
	
		<a href="user/login.jsp">로그인</a>
	<a href="${pageContext.request.contextPath}/front?key=user&methodName=logout">로그아웃</a>
	
	<a href="signup.html">회원가입</a>	
	
	<a href="admin/adminlogin.jsp">admin로그인</a>
	
	<a href="${pageContext.request.contextPath}/front?key=admin&methodName=adminlogout">admin로그아웃</a>
	
	<a href="admin/adminlogin.jsp">akd</a>
	
</body>
</html>