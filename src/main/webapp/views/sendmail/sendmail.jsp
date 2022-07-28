<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="me" uri="/WEB-INF/template"%>
<me:bg title="Send Email">
	<jsp:attribute name="content">
<h3 class="page-header">Send Email</h3>
<form method="post" class="form">
<p>
<label>Email</label>
<input type="email" name="email" class="col-7">
</p>
<p>
<label>Subject</label>
<input type="text" name="subject" class="col-7">
</p>
<p>
<label>Content</label>
<textarea rows="5" cols="20" name="content" class="col-7"></textarea>
</p>
<p>
<button class="btn btn-primary">Send mail</button>
</p>
</form>
<c:if test="${not empty msg }">
<div class="error">${msg}</div>
</c:if>
</jsp:attribute>
</me:bg>
