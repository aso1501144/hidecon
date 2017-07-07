<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/hover.css" rel="stylesheet" media="all">
<link href="css/tekkadan.css" rel="stylesheet" media="all">
<link href="css/main.css" rel="stylesheet" type=text/css>
<link rel="stylesheet" href="bootstrap-3.3.7/css/bootstrap.css" />
<title>ログイン画面</title>
</head>
<body id="user">
<jsp:include page="/WEB-INF/jsp/header.jsp"></jsp:include>

	<form action="<%=request.getContextPath()%>/userlogin" method="POST"
		onsubmit="return check(this)">
	<div class="parent">
  	<div class="inner">
    <div class="tablecell">

		<c:if test="${errorMassage != null }">
			<c:out value="${errorMassage}"></c:out>
		</c:if>
		<table class="table-design">
			<tr>
			<td colspan="2">ログイン</td>
			</tr>
			<tr>
				<td>学生ID:</td>
				<td><input type="text" name="s_id" style="ime-mode: disabled"></td>
			</tr>
			<tr>
				<td>パスワード:</td>
				<td><input type="password" name="pass"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="ログイン" onclick="check()" class="hvr-float"></td>
			</tr>
		</table>
	</div>
	</div>
	</div>
	</form>

</body>
</html>