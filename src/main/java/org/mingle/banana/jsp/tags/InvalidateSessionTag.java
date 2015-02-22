package org.mingle.banana.jsp.tags;

import javax.servlet.http.*;
import javax.servlet.jsp.tagext.*;

/**
 * This class is a custom action for invalidating a session, causing all session
 * scope variables to be removed and the session to be terminated (marked as
 * invalid).
 *
 * @author <a href="mailto:jinminglei@yeah.net">mingle</a>
 * @date 2015年2月22日
 * @version 1.0
 */
public class InvalidateSessionTag extends TagSupport {
	private static final long serialVersionUID = -6367792760469489748L;

	/**
	 * Invalidates the session.
	 */
	public int doEndTag() {
		HttpSession session = pageContext.getSession();
		if (session != null) {
			session.invalidate();
		}
		return EVAL_PAGE;
	}
}
