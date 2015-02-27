package org.mingle.banana.jsp.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.mingle.banana.jsp.beans.EmployeeBean;
import org.mingle.banana.jsp.beans.EmployeeRegistryBean;

/**
 * This class performs authentication in the Project Billboard application.
 *
 * @author <a href="mailto:jinminglei@yeah.net">mingle</a>
 * @date 2015年2月27日
 * @version 1.0
 */
public class AuthenticateAction extends Action {

	/**
	 * Autheticates a user with help from the EmployeeRegistryBean, using the
	 * "userName" and "password" request parameters. If the user can be
	 * authenticated, the "validUser" session attribute is set to an instance of
	 * the EmployeeBean, to serve as an authentication token in this
	 * application.
	 * <p>
	 * Cookies with the user name and password are set or reset as specified by
	 * the "remember" request parameter.
	 *
	 * @param mapping
	 *            The ActionMapping used to select this instance
	 * @param form
	 *            The optional ActionForm bean for this request (if any)
	 * @param request
	 *            The HTTP request we are processing
	 * @param response
	 *            The HTTP response we are creating
	 *
	 * @exception IOException
	 *                if an input/output error occurs
	 * @exception ServletException
	 *                if a servlet exception occurs
	 */
	public ActionForward perform(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		String userName = request.getParameter("userName");
		String password = request.getParameter("password");

		ActionForward nextPage = mapping.findForward("main");

		EmployeeBean emp = null;
		try {
			EmployeeRegistryBean empReg = (EmployeeRegistryBean) getServlet()
					.getServletContext().getAttribute("empReg");
			emp = empReg.authenticate(userName, password);
		} catch (SQLException e) {
			throw new ServletException("Database error", e);
		}
		if (emp != null) {
			// Valid login
			HttpSession session = request.getSession();
			session.setAttribute("validUser", emp);
			setLoginCookies(request, response, userName, password);

			// Next page is the originally requested URL or main
			String next = request.getParameter("origURL");
			if (next != null && next.length() != 0) {
				nextPage = new ActionForward(next, true);
			}
		} else {
			// Invalid login. Redirect to the login page
			String loginPage = mapping.findForward("login").getPath();
			String loginURL = loginPage
					+ "?errorMsg=Invalid+User+Name+or+Password";

			/*
			 * Create a new ActionForward for the login page with the
			 * parameters.
			 */
			nextPage = new ActionForward(loginURL, true);
		}
		return nextPage;
	}

	/**
	 * Set or "delete" the login cookies, depending on the value of the
	 * "remember" parameter.
	 */
	private void setLoginCookies(HttpServletRequest request,
			HttpServletResponse response, String userName, String password) {

		Cookie userNameCookie = new Cookie("userName", userName);
		Cookie passwordCookie = new Cookie("password", password);
		// Cookie age in seconds: 30 days * 24 hours * 60 minutes * 60 seconds
		int maxAge = 30 * 24 * 60 * 60;
		if (request.getParameter("remember") == null) {
			// maxAge = 0 to delete the cookie
			maxAge = 0;
		}
		userNameCookie.setMaxAge(maxAge);
		passwordCookie.setMaxAge(maxAge);
		userNameCookie.setPath(request.getContextPath());
		passwordCookie.setPath(request.getContextPath());
		response.addCookie(userNameCookie);
		response.addCookie(passwordCookie);
	}
}
