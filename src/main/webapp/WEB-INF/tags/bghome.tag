<%@ tag language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@attribute name="title" required="true" %>
<%@attribute name="content" required="true" fragment="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${title}</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/css.css">
</head>
<body>
	<div class="nav">
		<div class="container">
			<div class="brand"><a href="${pageContext.request.contextPath}">Mini Shop</a></div>
			<div class="nav-right">
				<ul>
					<li><a href="${pageContext.request.contextPath}/cart.html">Cart</a></li>
					<li><a href="${pageContext.request.contextPath}/auth/logon.html">Log On</a></li>
					<li><a href="${pageContext.request.contextPath}/auth/register.html">Register</a></li>
				</ul>
			</div>
			<div class="clear"></div>
		</div>
	</div>
	<div class="page">
		<div class="container">
			<div class="col-3">
				<ul>
					<c:forEach items="${categories}" var="o">
						<c:if test="${o.parent eq 0}">
							<li>${o.name}</li>
							<ul>
							<c:forEach items="${categories}" var="child">
								<c:if test="${child.parent eq o.id}">
									<li><a href="${pageContext.request.contextPath}/home/browse.html?id=${child.id}">${child.name}</a></li>
								</c:if>
							</c:forEach>
							</ul>
						</c:if>
					</c:forEach>
				</ul>
			</div>
			<div class="col-9">
				<jsp:invoke fragment="content"></jsp:invoke>
			</div>
			<div class="clear"></div>
		</div>
	</div>
</body>
</html>
