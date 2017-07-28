<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/mm.css" rel="stylesheet" media="all">
<script type="text/javascript" src="/hidecon/js/javascript.js"></script>
<title>投票の確認</title>
</head>
<body>
	<div id="container">
		<jsp:include page="/WEB-INF/jsp/header.jsp"></jsp:include>

		<h1 style="height: 200%">投票の確認をしてください</h1>
		<div id="wrapper" class="clearfix">

			<div id="mainCol3">
				<div class="parent">
					<div class="inner">
						<div class="tablecell">
							<img border="0" width="150%" height="250%"
								src="./img/<c:out value="${sessionScope.path}"/>">
							<div style="background-color: white;">
								<c:out value="${requestScope.work.works_name}" />
							</div>
						</div>
					</div>
				</div>
				投票しますか？
				<form action="Vote" method="post">

					<input type="hidden" value="<c:out value="${requestScope.id}"/>"
						name="works_id"> <input id="touhyou" type="submit"
						name="submit" value="投票する"> <input id="back" type="button"
						onClick='history.back();' value="戻る">
				</form>
				<form action="CommentAdd" method="get">
					<input type="submit" name="submit" value="コメントする">
				</form>


				<br> <br>

			</div>
		</div>
	</div>
</body>
</html>