<%@ page import="java.util.Date" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:parseDate value="${param.birthDate}" pattern="yyyy-MM-dd" var="birthDate" />
<jsp:useBean id="birthDate" class="java.util.Date" />

<%
	out.println(birthDate);	//脚本变量的值赋为作用域变量的值
%>
