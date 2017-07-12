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

		<h1 style="height: 200%">投票してクリー</h1>
		<div id="wrapper" class="clearfix">

			<div id="mainCol">
				<table>
					<c:forEach var="works" items="${requestScope.array}"
						varStatus="status">
						<c:if test="${status.first}">
							<tr>
						</c:if>
						<td>
							<div style="text-align: center;">
								<p>
									<a href="#"
										onclick="document.form1.aid.value = '${works}';
									document.form1.submit();return false;">
										<img border="0" width="100" height="100"
										src="./img/<c:out value="${works.path}"/>">
									</a>
								</p>
								<p>
									<c:out value="${works.works_name}" />
								</p>
								</p>
							</div>
						</td>
						<c:if test="${status.count % 3 == 0}">
							</tr>
							<tr>
						</c:if>
						<c:if test="${status.end}">
							</tr>
						</c:if>
					</c:forEach>



				</table>
				<form name="form1" action="Serch" method="post">
					<input type="hidden" name="aid" value=""> <input
						type="hidden" name="category" value="">
				</form>

				<a> <img src="./img/IMG_1971.jpg" width="30%" height="20%"
					style="float: left;"> <img src="./img/IMG_1995.jpg"
					width="30%" height="30%">
				</a>
			</div>
		</div>
	</div>
</body>
</html>