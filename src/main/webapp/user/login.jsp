<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="jumbotron">
	<h1>Login</h1>
</div>
<c:choose>
	<c:when test="${empty loginUser}">
		<form class="form-horizontal" method="post" action="${pageContext.request.contextPath}/front">
			<input type="hidden" name="key" value = "user" /> <!-- Controller를 찾는 정보 -->
			<input type="hidden" name="methodName" value = "login" />  <!-- 메소드이름 -->
			<fieldset>
				<legend>Login</legend>
				<div class="form-group">
					<label for="email" class="col-lg-2 control-label">email</label>
					<div class="col-lg-10">
						<input type="text" class="form-control" id="email" name="email"
							placeholder="email">
					</div>
				</div>
				<div class="form-group">
					<label for="password" class="col-lg-2 control-label">password</label>
					.<div class="col-lg-10">
						<input type="password" class="form-control" id="password" name="password"
							placeholder="password">
					</div>
				</div>
				<div class="form-group">
					<div class="col-lg-10 col-lg-offset-2">
						<button type="submit" class="btn btn-primary">Submit</button>
						<button class="btn btn-default">Cancel</button>
					</div>
				</div>
			</fieldset>
		</form>
	</c:when>
</c:choose>
