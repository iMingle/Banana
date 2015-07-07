<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:useBean id="pollResult" scope="application"
  class="org.mingle.banana.jsp.beans.PollBean" />

<jsp:useBean id="answer" class="org.mingle.banana.jsp.beans.AnswerBean" >
  <jsp:setProperty name="answer" property="*" />
</jsp:useBean>

<c:choose>
  <c:when test="${answer.valid}" >
    <c:set target="${pollResult}" property="answer"
      value="${answer}" />
    <jsp:forward page="result.jsp" />
  </c:when>
  <c:otherwise>
    <jsp:forward page="poll.jsp" />
  </c:otherwise>
</c:choose>
