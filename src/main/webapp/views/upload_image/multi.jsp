<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@taglib prefix="me" uri="/WEB-INF/template"%>  
<me:bg title="Mini Shop">
	<jsp:attribute name="content">

  <div class="main">
    <h2>Upload Multi Image</h2>
    <hr>
    <form method="post" class="form" enctype="multipart/form-data">
      <div>
        <label>Choose Image</label> 
        <input type="file" multiple="multiple" name="f">
      </div>
      <div>
        <button class="btn btn-primary">Upload</button>
      </div>
    </form>
    <c:if test="${not empty list}">
      <c:forEach var="img" items="${list}">
        <img width="70" src="${pageContext.request.contextPath}/upload/${img}">
      </c:forEach>
    </c:if>
  </div>
</jsp:attribute>
</me:bg>
