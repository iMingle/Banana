package org.mingle.banana.jsp.tags;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.jstl.core.ConditionalTagSupport;

/**
 * This class is a custom action for testing if the current (authenticated)
 * user belongs to the specified security role.
 * If he/she is, the body is evaluated. If a var attribute is provided, 
 * the result is also saved as a Boolean variable in the specified 
 * scope, or in the page if no scope is specified.
 *
 * @author <a href="mailto:jinminglei@yeah.net">mingle</a>
 * @date 2015年2月15日
 * @version 1.0
 */
public class IfUserInRoleTag extends ConditionalTagSupport {
	private static final long serialVersionUID = -4545331271946128426L;
	
	private String value;

    public void setValue(String value) {
        this.value = value;
    }

    public boolean condition() throws JspTagException {
        HttpServletRequest request = 
            (HttpServletRequest) pageContext.getRequest();
        return request.isUserInRole(value);
    }
}
