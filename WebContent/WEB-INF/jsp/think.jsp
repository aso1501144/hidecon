<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- <link rel="stylesheet" href="bootstrap-3.3.7/css/bootstrap.css" />
<link href="css/tekkadan.css" rel="stylesheet" media="all"> -->
<link href="css/mm.css" rel="stylesheet" media="all">
<title>投票ページ</title>
</head>
<body>
	<div id="container">
		<jsp:include page="/WEB-INF/jsp/header.jsp"></jsp:include>

		<h1 style="height: 200%">ありがとナスー</h1>
		<div id="wrapper" class="clearfix">

			<div id="mainCol">
				<div class="parent">
					<div class="inner">
						ありがとなす
						<a href="Rank">ランキングなす</a>
					</div>
				</div>
				<form name="form1" action="Vote" method="get">
					<input type="hidden" name="id" value="">
					<input type="hidden" name="path" value="">
				</form>
			</div>
		</div>
	</div>
</body>
</html>