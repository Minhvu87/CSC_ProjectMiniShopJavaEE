<%@taglib prefix="me" uri="/WEB-INF/template"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<me:bghome title="Check out">
	<jsp:attribute name="content">
<div class="page-header">
<div>Check Out</div>
</div>
<form method="post" class="form">
<p>
<label>Email</label>
<input placeholder="Email" value="npthanhthai@yahoo.com.vn" type="email"
					name="email">
</p>
<p>
<label>Tel</label>
<input type="tel" name="tel" value="1234234" placeholder="Tel">
</p>
<p>
<label>Address</label>
<input type="text" name="address" value="hcm" placeholder="Address">
</p>
<table class="table table-bordered">
<tr>
					<th>Title</th>
					<th>Quantity</th>
					<th>Price</th>
					<th>Image</th>
					<th>Delete</th>
				</tr>
<c:forEach items="${list}" var="o">
<tr>
<td>${o.title}</td>
<td><input type="number" value="${o.quantity}" class="qty"></td>
<td>${o.price}</td>
<td><img width="70px"
							src="${pageContext.request.contextPath}/upload/${o.imageUrl}"></td>
<td><img src="${pageContext.request.contextPath}/images/trash.png"></td>
</tr>
</c:forEach>
</table>
<p>
				<button class="btn btn-primary">Order</button>

		</form>
</jsp:attribute>
</me:bghome>