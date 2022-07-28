<%@taglib prefix="me" uri="/WEB-INF/template"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<me:bghome title="Cart">
	<jsp:attribute name="content">
<div class="page-header">
<div>Your Cart</div>
</div>

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
<td><input type="number" value="${o.quantity}" name="qty"
						class="qty"></td>
<td>${o.price}</td>
<td><img width="70px"
						src="${pageContext.request.contextPath}/upload/${o.imageUrl}"></td>
<td><img src="${pageContext.request.contextPath}/images/trash.png"></td>
</tr>
</c:forEach>

</table>

<p>
			<a href="${pageContext.request.contextPath}/cart/checkout.html"
				class="btn btn-primary">Check Out</a>
		</p>
</jsp:attribute>
</me:bghome>
<script type="text/javascript">
	var qties = document.getElementsByClassName("qty");
	for (var i = qties.length - 1; i >= 0; i--) {
		qties[i].onclick = function() {
			var qty = this.value;
			var id = this.getAttribute("data-id");
			var xhr = new XMLHttpRequest();
			xhr.onload = function() {
				alert(xhr.response);
			}
			xhr.open("POST","${pageContext.request.contextPath}/cart/edit.html");
			xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
			xhr.send("id=" + id + "&qty=" + qty);
		}
	}
</script>

