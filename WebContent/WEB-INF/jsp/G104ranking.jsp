<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script> -->
<script type="text/javascript" src="../js.js"></script>
<link href="css/mm.css" rel="stylesheet" media="all">
<script type="text/javascript" src="/hidecon/js/javascript.js"></script>
<title>投票結果画面</title>
</head>
<body>
<div id="container">
		<jsp:include page="/WEB-INF/jsp/header.jsp"></jsp:include>

<div id="wrapper" class="clearfix">
			<div id="mainCol2">
				<div class="parent">
					<div class="inner">
						<div class="tablecell">

	<c:forEach var="works" items="${requestScope.rank}" varStatus="st">
		<c:if test="${status.first}">
			<tr>
		</c:if>

			<div style="text-align: center;">
				<p>
					<img border="0" width="300" height="300"
						src="./img/<c:out value="${works.path}"/>" style="padding: 15px">
				</p>
				<p>
					<c:out value="${works.works_name}" />
					&nbsp;
					&nbsp;
					<c:out value="${works.works_count}" />票
				</p>

			</div>

	</c:forEach>
	</div>
	</div>
	</div>
	</div>
	</div>
</div>



</body>
</html>