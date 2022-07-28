<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="me" uri="/WEB-INF/template"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<me:bg title="Add Author">
	<jsp:attribute name="content">
<div class="page-header">
Add Author
</div>
<p>
			<a class="btn btn-info"
				href="${pageContext.request.contextPath}/admin/author/list.html">Back</a>
		</p>
<form method="post" class="form">
<div>
<label>Name</label>
<input type="text" name="name">
</div>
<div>
<button class="btn btn-primary">Save</button>
</div>
</form>
</jsp:attribute>
</me:bg>