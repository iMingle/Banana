package org.mingle.banana.jsp.tags;

import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

/**
 * This class is a custom action for setting response headers that prevent the
 * page from being cached by a browser or proxy server.
 *
 * @author <a href="mailto:jinminglei@yeah.net">mingle</a>
 * @date 2015年2月22日
 * @version 1.0
 */
public class NoCacheTag extends TagSupport {
	private static final long serialVersionUID = 156417071235092705L;

	/**
	 * Sets "no cache" response headers
	 */
	public int doEndTag() throws JspException {
		HttpServletResponse response = (HttpServletResponse) pageContext
				.getResponse();
		response.addHeader("Pragma", "No-Cache");
		response.setHeader("Cache-Control",
				"no-cache, no-store, must-revalidate");
		response.addHeader("Cache-Control", "pre-check=0, post-check=0");
		response.setDateHeader("Expires", 0);
		return EVAL_PAGE;
	}
}
