package org.mingle.banana.jsp.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.mingle.banana.jsp.beans.EmployeeBean;
import org.mingle.banana.jsp.beans.NewsBean;
import org.mingle.banana.jsp.beans.NewsItemBean;

/**
 * This class stores a new message in the Project Billboard application.
 *
 * @author <a href="mailto:jinminglei@yeah.net">mingle</a>
 * @date 2015年2月27日
 * @version 1.0
 */
public class StoreMsgAction extends Action {

	/**
	 * Creates a new NewsItemBean and sets its properties based on the
	 * "category" and "msg" request parameters, plus the firstName and lastName
	 * properties of the authenticated user (an EmployeeBean accessible as the
	 * "validUser" session attribute). The NewItemBean is then added to the
	 * NewsBean. This action is only performed for POST request. Before
	 * returning, the client is redirected to the main page, where the new
	 * message is displayed.
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
			String category = request.getParameter("category");
			String msg = request.getParameter("msg");
			if (category == null || msg == null) {
				throw new ServletException("Missing message info");
			}
			HttpSession session = request.getSession();
			EmployeeBean emp = (EmployeeBean) session.getAttribute("validUser");
			NewsItemBean item = new NewsItemBean();
			item.setCategory(category);
			item.setMsg(msg);
			item.setPostedBy(emp.getFirstName() + " " + emp.getLastName());
			NewsBean news = (NewsBean) servlet.getServletContext()
					.getAttribute("news");
			news.setNewsItem(item);
		}
		ActionForward nextPage = mapping.findForward("main");
		return nextPage;
	}
}
