<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" scr="../js/jquery-3.6.1.js"></script>
</head>
<body>
	<c:forEach items="${list }" var="notice">
	${notice.noticeCode }
	</c:forEach>
</body>
</html>