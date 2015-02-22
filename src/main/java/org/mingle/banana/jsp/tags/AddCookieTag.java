package org.mingle.banana.jsp.tags;

import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

import org.mingle.banana.jsp.util.CookieUtils;

/**
 * This class is a custom action for adding a cookie header to the response.
 *
 * @author <a href="mailto:jinminglei@yeah.net">mingle</a>
 * @date 2015年2月22日
 * @version 1.0
 */
public class AddCookieTag extends SimpleTagSupport {
	private String name;
	private String value;
	private String maxAgeString;

	/**
	 * Sets the cookie name attribute.
	 *
	 * @param name
	 *            the name of the cookie
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Sets the cookie value attribute.
	 *
	 * @param value
	 *            the value of the cookie
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * Sets the cookie maxAge attribute.
	 *
	 * @param maxAgeString
	 *            the max age (in seconds) of the cookie
	 */
	public void setMaxAge(String maxAgeString) {
		this.maxAgeString = maxAgeString;
	}

	/**
	 * Creates a cookie and adds it to the response
	 */
	public void doTag() throws JspException {
		int maxAge = -1;
		if (maxAgeString != null) {
			try {
				maxAge = Integer.valueOf(maxAgeString).intValue();
			} catch (NumberFormatException e) {
				throw new JspTagException("Invalid maxAge", e);
			}
		}
		PageContext pageContext = (PageContext) getJspContext();
		HttpServletResponse response = (HttpServletResponse) pageContext
				.getResponse();
		CookieUtils.sendCookie(name, value, maxAge, response);
	}
}
