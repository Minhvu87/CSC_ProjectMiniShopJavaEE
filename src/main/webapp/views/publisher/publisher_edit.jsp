<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="me" uri="/WEB-INF/template"%>
<me:bg title="Publsher">
	<jsp:attribute name="content">
<div class="page-header">Edit Publisher</div>
<form method="post" class="form">
<input type="hidden" name="id" value="${o.id}">
<div>
<label>Name</label>
<input type="text" name="name" value="${o.name}">
</div>
<div>
<button class="btn btn-primary">Save</button>
</div>
</form>
<c:if test="${not empty msg}">
<p class="error">${msg}</p>
</c:if>
</jsp:attribute>
</me:bg>