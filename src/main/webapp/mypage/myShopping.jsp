<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../common/header.jsp" />
<jsp:include page="navigation/title.jsp" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>네가 사는 그 집</title>
<style type="text/css">
ul {
	list-style-type: none;
}

li a {
	display: block;
	text-decoration: none;
}
</style>
</head>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-3.6.1.js"></script>
<script type="text/javascript">
	
</script>
<body>
	<!-- Shoping Cart -->
	<div class="bg0 p-t-75 p-b-85">
		<div class="container" style="margin-top: 50px;">
			<div class="row">
				<div class="col-lg-10 col-xl-7 m-lr-auto m-b-50">

					<div class="m-l-25 m-r--38 m-lr-0-xl">
						<div class="wrap-table-shopping-cart">

							<div>
								<table class="table-shopping-cart">
									<tr class="table_head">
										<th class="column-1" colspan="5">
											<span>
												<span>결제완료</span>
												<a href="#">1</a>
											</span>
										</th>
									</tr>

									<tr class="table_row">
										<td class="column-1">
											<div class="how-itemcart1">
												<img
													src="${pageContext.request.contextPath}/images/item-cart-04.jpg"
													alt="IMG">
											</div> <input type="hidden" value="" class="789456">
										</td>
										<td class="column-2">상품이름</td>
										<td class="column-3">₩ 120,000</td>
										<td class="column-4">
											<div class="wrap-num-product flex-w m-l-auto m-r-0">
												<div
													class="btn-num-product-down cl8 hov-btn3 trans-04 flex-c-m"></div>
												<input class="mtext-104 cl3 txt-center num-product"
													type="number" name="num-product1" value="">
												<div
													class="btn-num-product-up cl8 hov-btn3 trans-04 flex-c-m"></div>
											</div>
										</td>
										<td class="column-5">₩ 120,000</td>
									</tr>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
<jsp:include page="../common/footer.jsp" />