package org.mingle.banana.jsp.servlets;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

/**
 * This is a simple servlet example that shows the main request methods.
 *
 * @author <a href="mailto:jinminglei@yeah.net">mingle</a>
 * @date 2015年2月27日
 * @version 1.0
 */
public class HelloYou extends HttpServlet {

	private static final long serialVersionUID = -5512728100510762723L;

	/**
	 * This method writes the most commonly used request information to the
	 * response body, such as the User-Agent header, the various paths
	 * associated with the request, and the request parameters.
	 */
	@SuppressWarnings("unchecked")
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("name");
		if (name == null) {
			name = "you";
		}
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<h1>Hello " + name + "</h1>");

		out.println("I see that:<ul>");
		String userAgent = request.getHeader("User-Agent");
		out.println("<li>your browser is: " + userAgent);
		String requestURI = request.getRequestURI();
		out.println("<li>the URI for this page is: " + requestURI);
		String contextPath = request.getContextPath();
		out.println("<li>the context path for this app is " + contextPath);
		String servletPath = request.getServletPath();
		out.println("<li>this servlet is mapped to: " + servletPath);
		String pathInfo = request.getPathInfo();
		out.println("<li>the remaining path is: " + pathInfo);
		Map<String, String[]> parameters = request.getParameterMap();
		out.println("<li>you sent the following params:<ul>");
		Iterator<String> i = parameters.keySet().iterator();
		while (i.hasNext()) {
			String paramName = (String) i.next();
			out.println("<li><b>" + paramName + "</b>:");
			String[] paramValues = (String[]) parameters.get(paramName);
			for (int j = 0; j < paramValues.length; j++) {
				if (j != 0) {
					out.print(", ");
				}
				out.print(paramValues[j]);
			}
		}
		out.println("</ul></ul></body></html>");
	}
}
