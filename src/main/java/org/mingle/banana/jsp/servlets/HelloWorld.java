package org.mingle.banana.jsp.servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 * This is a simple Hello World servlet example to show the main servlet
 * methods.
 *
 * @author <a href="mailto:jinminglei@yeah.net">mingle</a>
 * @date 2015年2月27日
 * @version 1.0
 */
public class HelloWorld extends HttpServlet {
	private static final long serialVersionUID = -3957457147343680664L;

	private String greeting;

	/**
	 * This method is called once by the container when the servlet is
	 * initialized, before any requests are delivered to the servlet.
	 *
	 * In this example, the method reads a servlet init parameter value and
	 * saves it in an instance variable. If the parameter is not found, a
	 * default value is saved instead.
	 */
	public void init() {
		ServletConfig config = getServletConfig();
		greeting = config.getInitParameter("greeting");
		if (greeting == null) {
			greeting = "Hello World!";
		}
	}

	/**
	 * This method is called by the container for each GET request.
	 *
	 * In this example, the method writes a line of text to the response body.
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		out.println(greeting);
	}

	/**
	 * This method is called once by the container just before the servlet is
	 * taken out of service.
	 *
	 * In this example, the method resets the servlet instance variable.
	 */
	public void destroy() {
		greeting = null;
	}
}
