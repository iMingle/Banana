package org.mingle.banana.jsp.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
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
 * This class updates a user profile in the Project Billboard application.
 *
 * @author <a href="mailto:jinminglei@yeah.net">mingle</a>
 * @date 2015年2月27日
 * @version 1.0
 */
public class UpdateProfileAction extends Action {

	/**
	 * Updates the projects property of an authenticated user, represented by
	 * the "validUser" session attribute, using the EmployeeRegistryBean. This
	 * action is only performed for POST requests. Before returning, the client
	 * is redirected to the main page, where the new set of projects are
	 * displayed.
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

		if (request.getMethod().equals("POST")) {
			String[] projects = request.getParameterValues("projects");
			if (projects == null) {
				projects = new String[0];
			}
			HttpSession session = request.getSession();
			EmployeeBean emp = (EmployeeBean) session.getAttribute("validUser");
			emp.setProjects(projects);
			EmployeeRegistryBean empReg = (EmployeeRegistryBean) getServlet()
					.getServletContext().getAttribute("empReg");
			try {
				empReg.saveEmployee(emp);
			} catch (SQLException e) {
				throw new ServletException("Database error", e);
			}
		}
		ActionForward nextPage = mapping.findForward("main");
		return nextPage;
	}
}
