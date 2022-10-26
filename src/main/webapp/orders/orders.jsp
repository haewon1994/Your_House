<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>주문 결제</h1>
	<h3>배송지</h3>
	<hr>
	<table>
		<tr>
			<th>이름</th>
			<td><input type="text" id="delName" value="${loginUser.nickname}"></td>
		</tr>
		<tr>
			<th>휴대전화</th>
			<td><input type="text" id="delPhone" value="${loginUser.phone}"></td>
		</tr>
		<tr>
			<th>주소</th>
			<td><input type="text" id="delAddr" value="${loginUser.adress}"></td>
		</tr>
	</table>
	<h3>주문자</h3>
	<hr>
	<table>
		<tr>
			<th>이름</th>
			<td><input type="text" id="orderName" value="${loginUser.nickname}"></td>
		</tr>
		<tr>
			<th>이메일</th>
			<td><input type="text" id="orderEmail" value="${loginUser.email}"></td>
		</tr>
		<tr>
			<th>휴대전화</th>
			<td><input type="text" id="orderPhone" value="${loginUser.phone}"></td>
		</tr>
	</table>
	<h3>주문상품</h3>
	<hr>
	<div>총금액 : ${totalprice}</div>
	<h6><a href="test2.jsp">결제하기</a></h6>
</body>
</html>