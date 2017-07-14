<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- <link href="css/tekkadan.css" rel="stylesheet" media="all"> -->
<link href="css/mm.css" rel="stylesheet" media="all">
<title>メインページ</title>
</head>
<body>
	<div id="container">
		<jsp:include page="/WEB-INF/jsp/header.jsp"></jsp:include>
		<h1>ログインしてクリー</h1>
		<br>

		<div id="wrapper" class="clearfix">

			<div id="mainCol">
				<div class="parent">
					<div class="inner">

						<form action="Login" style="padding: auto; width: auto;">
							<input type="submit" value="ログイン画面へ"
								style="padding: auto; width: auto;">
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>