<%@taglib prefix="me" uri="/WEB-INF/template"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<me:bghome title="Mini Shop">
	<jsp:attribute name="content">
<form class="form-search" method="get"
			action="${pageContext.request.contextPath}/home/search.html">
<input type="text" placeholder="Search..." name="q">
<button class="btn btn-primary">Search</button>
</form>
<div class="page-header">
Product Detail
</div>
<div class="products">
<div class="col-5">
<img src="${pageContext.request.contextPath}/upload/${o.imageUrl}">
</div>
<div class="col-7">
<h2>${o.title}</h2>
<p>ISBN: <b>${o.isbn}</b>
				</p>
<p>Pages: <b>${o.pages}</b>
				</p>
<p>Price: <b>${o.price}</b>
				</p>
<form method="post"
					action="${pageContext.request.contextPath}/cart.html">
<input type="hidden" value="${o.id}" name="id">
<input type="number" name="qty" value="1">
<button class="btn btn-primary">Add to
Cart</button>
</form>
</div>
</div>
</jsp:attribute>
</me:bghome>
