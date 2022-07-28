<%@taglib prefix="me" uri="/WEB-INF/template"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<me:bgpanel title="Register">
	<jsp:attribute name="content">
<form method="post">
<p>
<input type="text" class="form-control" placeholder="Full
Name"
					name="fullName">
</p>
<p>
<input type="email" class="form-control" placeholder="Email"
					name="email">
</p>
<p>
<input class="form-control" placeholder="Username" type="text"
					name="usr">
</p>
<p>
<input class="form-control" placeholder="Password" type="password"
					name="pwd">
</p>
<p>
<select name="gender">
<option value="0">Male</option>
<option value="1">Female</option>
<option value="2">Undefined</option>
</select>
</p>
<p>
<button class="btn btn-primary btn-
lg">Register</button>
</p>
<p class="center">
				<a href="${pageContext.request.contextPath}/auth/logon.html">Log On</a>
			</p>
<p class="center">
				<a href="${pageContext.request.contextPath}/auth/forgot.html">Forgot
				Password?</a>
			</p>
</form>
<c:if test="${not empty msg}">
<div class="error">${msg}</div>
</c:if>
</jsp:attribute>
</me:bgpanel>
