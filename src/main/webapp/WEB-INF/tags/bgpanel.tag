<%@ tag language="java" pageEncoding="UTF-8"%>
<%@attribute name="title" required="true" %>
<%@attribute name="content" fragment="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${title}</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/css.css">
</head>
<body>
	<div class="panel-login">
		<div class="panel-heading">
			<h2 class="panel-title">${title}</h2>
		</div>
		<div class="panel-body">
		<jsp:invoke fragment="content" />
		</div>
	</div>
</body>
</html>
