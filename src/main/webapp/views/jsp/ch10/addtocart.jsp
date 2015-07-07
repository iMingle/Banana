<%@ page contentType="text/plain" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:useBean id="catalog" scope="application"
  class="org.mingle.banana.jsp.beans.shopping.CatalogBean"
/>

<%-- Get the specified ProductBean from the catalog --%>
<c:set var="product" value="${catalog.productsById[param.id]}" />

<jsp:useBean id="cart" scope="session"
  class="org.mingle.banana.jsp.beans.shopping.CartBean"/>

<%-- Add the product to the cart --%>
<c:set target="${cart}" property="product" value="${product}" />

<c:redirect url="catalog.jsp" />
