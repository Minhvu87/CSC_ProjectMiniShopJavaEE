<%@taglib prefix="me" uri="/WEB-INF/template"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<me:bgpanel title="Log On">
    <jsp:attribute name="content">
        <form method="post">
            <p>
                <input class = "form-control" placeholder="Username" 
                type="text" name="usr">
            </p>
            <p>
                <input class = "form-control" placeholder="Password"
                type="password" name="pwd">
            </p>
            <p>
                <label>
                    <input type="checkbox" name="remember"
                    value="1"> Remember me
                </label>
            </p>
            <p>
                <button class="btn btn-primary btn-lg">Log On</button>
            </p>
            <p class="center"><a 
            href="${pageContext.request.contextPath }/auth/register.html">Register an 
            Account</a></p>
            <p class="center"><a
            href="${pageContext.request.contextPath }/auth/forgot.html">Forgot
            Password?</a></p>
        </form>
        <c:if test="${not empty msg}">
            <div class ="error">${msg}</div>
        </c:if>
    </jsp:attribute>
</me:bgpanel>