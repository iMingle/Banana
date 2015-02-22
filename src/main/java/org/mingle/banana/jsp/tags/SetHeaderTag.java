package org.mingle.banana.jsp.tags;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * This class is a custom action for setting response header values.
 *
 * @author <a href="mailto:jinminglei@yeah.net">mingle</a>
 * @date 2015年2月22日
 * @version 1.0
 */
public class SetHeaderTag extends SimpleTagSupport {
	private String name;
	private String value;

	/**
	 * Sets the name attribute.
	 *
	 * @param name
	 *            the parameter name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Sets the value attribute from a String.
	 *
	 * @param value
	 *            the parameter String value
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * Sets the header specified by the name property to the value specified by
	 * the value property.
	 */
	public void doTag() throws JspException {
		if (value.length() == 0 || name.length() == 0) {
			throw new JspTagException("setHeader: "
					+ "one of the attributes is not set");
		}
		PageContext pageContext = (PageContext) getJspContext();
		HttpServletResponse response = (HttpServletResponse) pageContext
				.getResponse();
		response.setHeader(name, value);
	}
}
