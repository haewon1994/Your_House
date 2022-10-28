<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.6.1.min.js"></script>
<script type="text/javascript" src="js/jquery-3.6.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.form.min.js"></script>
<script type="text/javascript" src="js/jquery.form.min.js"></script>
</head>
<body>
<body>
	<a href="${pageContext.request.contextPath }/front?key=adminProduct&methodName=selectMainTotalProduct">
	상품목록 조회(전체/최근생성순)</a><br>
	<c:forEach items="${productList }" var="plist">
	${plist.productCode }///${plist.categoryCode}///${plist.productName }///${plist.image}///${plist.createdReg }///${plist.productDetail }///${plist.stock }///${plist.price }<br>
	</c:forEach>
	
	<p/>
	카테고리 리스트 출력<br>
	<c:forEach items="//${categoryList }" var="clist">
	${clist.categoryCode }//${clist.categoryName }<br>
	</c:forEach>
	
	<a href="${pageContext.request.contextPath }/front?key=adminProduct&methodName=selectMainTotalProduct">
	카테고리 </a><br>
	<c:forEach items="${productList }" var="plist">
	${plist.productCode }///${plist.categoryCode}///${plist.productName }///${plist.image}///${plist.createdReg }///${plist.productDetail }///${plist.stock }///${plist.price }<br>
	</c:forEach>
	<tr>
	<p/>
	
	<a href="${pageContext.request.contextPath }/front?key=adminProduct&methodName=selectDetailTotalProductByProductCode&productCode=5">
	상품번호(5)로 상품조회</a><br>
	${product.productCode }///${product.categoryCode}///${product.productName }///${product.image }//${product.createdReg }//${product.productDetail }//${product.stock }//${product.price }<br>
	<p/>
	카테고리 전체 리스트 출력<br>
	<c:forEach items="//${categoryList }" var="clist2">
	${clist2.categoryCode }//${clist2.categoryName }<br>
	</c:forEach>
	<p/>
	상품(5) 색상 리스트 출력<br>
	<c:forEach items="${colorList }" var="cllist">
	${cllist.colorCode }//${cllist.productCode }//${cllist.colorName }<br>
	</c:forEach>
	<p/>
	상품(5) 이미지 리스트 출력<br>
	<c:forEach items="${productImageList }" var="pilist">
	${pilist.imageCode }//${pilist.productCode }//${pilist.fileName }<br>
	</c:forEach>
	<p/>
	
	
	
	<p/>
	
	
	
</body>
</body>
</html>