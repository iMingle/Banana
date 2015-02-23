package org.mingle.banana.jsp.tags.xmp;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.tagext.TagSupport;

import org.mingle.banana.jsp.util.CookieUtils;

/**
 * This class is a custom action for adding a cookie header to the response.
 *
 * @author <a href="mailto:jinminglei@yeah.net">mingle</a>
 * @date 2015年2月22日
 * @version 1.0
 */
public class ClassicAddCookieTag extends TagSupport {
	private static final long serialVersionUID = 9060387562800653856L;

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
	public int doEndTag() throws JspException {
		int maxAge = -1;
		if (maxAgeString != null) {
			try {
				maxAge = Integer.valueOf(maxAgeString).intValue();
			} catch (NumberFormatException e) {
				throw new JspTagException("Invalid maxAge", e);
			}
		}
		CookieUtils.sendCookie(name, value, maxAge,
				(HttpServletResponse) pageContext.getResponse());
		return EVAL_PAGE;
	}

	/**
	 * Releases all instance variables.
	 */
	public void release() {
		name = null;
		value = null;
		maxAgeString = null;
		super.release();
	}
}
