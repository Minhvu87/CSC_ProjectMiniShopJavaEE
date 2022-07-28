<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="me" uri="/WEB-INF/template"%>
<me:bg title="Mini Shop">
	<jsp:attribute name="content">
  <div class="main">
    <h2>Upload Image</h2>
    <hr>
    <form method="post" class="form" enctype="multipart/form-data">
      <p><label>Choose Image</label> <input type="file" name="f"></p>
      <p>
        <button class="btn btn-primary">Upload</button>
      </p>
    </form>
    <c:if test="${not empty img}">
      <img width="200" src="${pageContext.request.contextPath}/upload/${img}">
    </c:if>
  </div>
</jsp:attribute>
</me:bg>
