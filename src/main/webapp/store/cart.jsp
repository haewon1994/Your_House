<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../common/header.jsp"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>네가 사는 그 집</title>

</head>
<body>

	<!-- Shoping Cart -->
	<form class="bg0 p-t-75 p-b-85">
		<div class="container">
			<div class="row">	
				<div class="col-lg-10 col-xl-7 m-lr-auto m-b-50">
				
					<div class="m-l-25 m-r--38 m-lr-0-xl">
						<div class="wrap-table-shopping-cart">
						<img src="${pageContext.request.contextPath}/images/icons/shopping-cart.png" style="width: 30px; padding-right: 10px;">
						<span style="padding-left:-18px; font-weight: bold; color: #1049af;">장바구니</span>				
							<table class="table-shopping-cart">
								<tr class="table_head">
									<th class="column-1">상품</th>
									<th class="column-2"></th>
									<th class="column-3">가격</th>
									<th class="column-4">수량</th>
									<th class="column-5">결제금액</th>
								</tr>

								<tr class="table_row">
									<td class="column-1">
										<div class="how-itemcart1">
											<img src="${pageContext.request.contextPath}/images/item-cart-04.jpg" alt="IMG">
										</div>
									</td>
									<td class="column-2">엘로벤, 모니터스탠드+서랍</td>
									<td class="column-3">￦29,900</td>
									<td class="column-4">
										<div class="wrap-num-product flex-w m-l-auto m-r-0">
											<div class="btn-num-product-down cl8 hov-btn3 trans-04 flex-c-m">
												
											</div>

											<input class="mtext-104 cl3 txt-center num-product" type="number" name="num-product1" value="1">

											<div class="btn-num-product-up cl8 hov-btn3 trans-04 flex-c-m">
												
											</div>
										</div>
									</td>
									<td class="column-5">￦29,900</td>
								</tr>

								<tr class="table_row">
									<td class="column-1">
										<div class="how-itemcart1">
											<img src="${pageContext.request.contextPath}/images/item-cart-05.jpg" alt="IMG">
										</div>
									</td>
									<td class="column-2">DEJSA 데이사, 탁상스탠드</td>
									<td class="column-3">￦49,900</td>
									<td class="column-4">
										<div class="wrap-num-product flex-w m-l-auto m-r-0">
											<div class="btn-num-product-down cl8 hov-btn3 trans-04 flex-c-m">
												
											</div>

											<input class="mtext-104 cl3 txt-center num-product" type="number" name="num-product2" value="1">

											<div class="btn-num-product-up cl8 hov-btn3 trans-04 flex-c-m">
												
											</div>
										</div>
									</td>
									<td class="column-5">￦49,900</td>
								</tr>
							</table>
						</div>

						<div class="flex-w flex-sb-m bor15 p-t-18 p-b-15 p-lr-40 p-lr-15-sm">
							<div class="cart_total" style="display: inline-block;">
								<span class="ctotal" style="text-align: left;"><b>총 주문금액</b></span>
								<span class="total_won" style="text-align: right;"><b>₩ 89,700</b></span>	
							
							</div>							
						</div>
					<div class="flex-c-m stext-101 cl2 size-119 bg8 bor13 hov-btn3 p-lr-15 trans-04 pointer m-tb-10">
							결제하기
					</div>
					</div>
				</div>
		</div>
	</div>
</form>
		
</body>
</html>
<jsp:include page="../common/footer.jsp"/>