<%@ tag language="java" pageEncoding="UTF-8"%>
<%@attribute name="title" required="true"%>
<%@attribute name="content" required="true" fragment="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${title}</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/css.css">
</head>
<body>
	<div class="title">
		<div class="container">
			<div class="brand">
				<a href="${pageContext.request.contextPath}"> ProjectMiniShop Using JavaEE </a>
			</div>
		</div>
	</div>
	<div class="sidebar">
		<ul>
			<li><a href="/ProjectMiniShopJavaEE/upload.html">Upload Image</a></li>
			<li><a href="/ProjectMiniShopJavaEE/upload/multi.html">Multiple Upload Image</a></li>
			<li><a href="/ProjectMiniShopJavaEE/admin/author/list.html">Publisher</a>
			<li><a href="/ProjectMiniShopJavaEE/admin/publisher.html">Publisher</a>
			<li><a href="/ProjectMiniShopJavaEE/home.html">Home</a></li>
			<li><a href="/ProjectMiniShopJavaEE/auth/register.html">Register</a></li>
			<li><a href="/ProjectMiniShopJavaEE/auth/logon.html">Log On</a></li>
			<li><a href="/ProjectMiniShopJavaEE/invoice.html">Invoice</a></li>
		</ul>
	</div>
	<div class="main">
		<jsp:invoke fragment="content" />
	</div>
</body>
</html>