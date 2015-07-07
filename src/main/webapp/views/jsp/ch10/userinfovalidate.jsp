<%@ page contentType="text/plain" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:useBean id="userInfo" 
  scope="request"
  class="org.mingle.banana.jsp.beans.UserInfoBean">
  <jsp:setProperty name="userInfo" property="*" />
</jsp:useBean>

<c:choose>
  <c:when test="${userInfo.valid}">
    <jsp:forward page="userinfovalid.jsp" />
  </c:when>
  <c:otherwise>
    <jsp:forward page="userinfoinput.jsp" />
  </c:otherwise>
</c:choose>

