<%@taglib prefix="me" uri="/WEB-INF/template"%>
<%@taglib prefix="frm" uri="/WEB-INF/form"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<me:bghome title="Mini Shop">
	<jsp:attribute name="content">
<form class="form-search" method="get"
			action="${pageContext.request.contextPath}/home/search.html">
<input type="text" placeholder="Search..." name="q">
<button class="btn btn-primary">Search</button>
</form>
<div class="page-header">
Products
</div>
<div class="products">
<c:forEach var="o" items="${list}">
<div class="col-3">
<div class="item">
<img alt="${o.title}"
							src="${pageContext.request.contextPath}/upload/${o.imageUrl}">
<div class="info">
<a href="${pageContext.request.contextPath}/home/detail.html?id=${o.id}">${o.title}</a>
						</div>

</div>
</div>
</c:forEach>

<div class="clear"></div>

</div>
<frm:pagination url="${pageContext.request.contextPath}/home.html?p=%s"
size="${n}" />
</jsp:attribute>
</me:bghome>
