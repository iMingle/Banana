<html>
  <head>
    <title>A dose of Dilbert</title>
  </head>
  <body bgcolor="white">
    <h1>A dose of Dilbert</h1>

    <jsp:useBean id="cartoon" 
      class="org.mingle.banana.jsp.beans.CartoonBean" />

    <img src="images/<jsp:getProperty name="cartoon" 
      property="fileName" />">

  </body>
</html>
