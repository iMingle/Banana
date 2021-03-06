<%@ page language="java" contentType="text/html"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%
  // Create an ArrayList with test data
  ArrayList<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
  Map<String, Object> author1 = new HashMap<String, Object>();
  author1.put("name", "John Irving");
  author1.put("id", new Integer(1));
  list.add(author1);
  Map<String, Object> author2 = new HashMap<String, Object>();
  author2.put("name", "William Gibson");
  author2.put("id", new Integer(2));
  list.add(author2);
  Map<String, Object> author3 = new HashMap<String, Object>();
  author3.put("name", "Douglas Adams");
  author3.put("id", new Integer(3));
  list.add(author3);
  pageContext.setAttribute("authors", list);
%>

<html>
<head>
<title>Search result: Authors</title>
</head>
<body bgcolor="white">
	Here are all authors matching your search critera:
	<table>
		<tr>
			<th>Name</th>
			<th>Id</th>
		</tr>
		<c:forEach items="${authors}" var="current">
			<tr>
				<td>${fn:escapeXml(current.name)}</td>
				<td>${fn:escapeXml(current.id)}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
