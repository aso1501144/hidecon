<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/mm.css" rel="stylesheet" media="all">
<script type="text/javascript" src="/hidecon/js/javascript.js"></script>
<title>コメント</title>
</head>
<body>
	<div id="container">
		<jsp:include page="/WEB-INF/jsp/header.jsp"></jsp:include>

		<h1 style="height: 200%">コメントの一覧です</h1>
		<div id="wrapper" class="clearfix">
			<div id="mainCol">
				<div class="parent">
					<div class="inner">
						<div class="tablecell">
							<div style="text-align: center;">
								<p style="background-color: white;">
									<c:forEach var="comment" items="${requestScope.comment}">
										ユーザー名：<c:out value="${comment.user_name}" />さん
										<br>
										<c:out value="${comment.comment}" />
										<br>
									</c:forEach>
								</p>
							</div>
						</div>
					</div>
					<form action="CommentAdd" method="post">
						<input type="text" name="comment"> <input type="hidden"
							value="<c:out value="${sessionScope.works_id}"/>" name="works_id">
						<input type="hidden"
							value="<c:out value="${sessionScope.user.user_id}"/>"
							name="user_id">
						 <input type="submit" value="コメントする">
						 <br>
						 <br>
						 <input id="back" type="button"
						onClick='history.back();' value="戻る">
					</form>
					<!-- <a href="Return"><font style="color: white;">戻る</font></a> -->
				</div>
			</div>
		</div>
	</div>
</body>
</html>