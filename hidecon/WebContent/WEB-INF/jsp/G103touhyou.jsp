<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/mm.css" rel="stylesheet" media="all">
<title>確認</title>
</head>
<body>
	<div id="container">
		<jsp:include page="/WEB-INF/jsp/header.jsp"></jsp:include>

		<h1 style="height: 200%">投票してクリー</h1>
		<div id="wrapper" class="clearfix">

			<div id="mainCol">
				<div class="parent">
					<div class="inner">
						<div class="tablecell">
							<img border="0" width="285" height="285"
								src="./img/<c:out value="${requestScope.path}"/>">
						</div>
					</div>
				</div>
				<form name="form1" action="" method="get">
					<input type="hidden" name="id" value="">
				</form>
			</div>
		</div>
	</div>
</body>
</html>