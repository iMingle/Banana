package org.mingle.banana.jsp.tags;

import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.jstl.core.ConditionalTagSupport;

import org.mingle.banana.jsp.util.StringFormat;

/**
 * This class is a custom action for testing if a string value is in the format
 * of a valid SMTP email address. If it is, the body is evaluated. If a var
 * attribute is provided, the result is also saved as a Boolean variable in the
 * specified scope, or in the page if no scope is specified.
 *
 * @author <a href="mailto:jinminglei@yeah.net">mingle</a>
 * @date 2015年2月15日
 * @version 1.0
 */
public class IfValidEmailAddrTag extends ConditionalTagSupport {
	private static final long serialVersionUID = 6882315192036392826L;

	private String value;

	public void setValue(String value) {
		this.value = value;
	}

	public boolean condition() throws JspTagException {
		return StringFormat.isValidEmailAddr(value);
	}
}
