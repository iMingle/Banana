package org.mingle.banana.jsp.tags.xmp;

import java.io.IOException;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.jstl.core.LoopTag;
import javax.servlet.jsp.tagext.TagSupport;

import org.mingle.banana.jsp.util.StringFormat;

/**
 * This class is a custom action for creating an HTML checkbox
 * control, using status information exposed by the JSTL forEach 
 * action.
 *
 * @author <a href="mailto:jinminglei@yeah.net">mingle</a>
 * @date 2015年2月22日
 * @version 1.0
 */
public class BuildCheckboxTag extends TagSupport {
	private static final long serialVersionUID = -2717819002466871747L;
	
	private String name;
    private String[] selections;

    public void setName(String name) {
        this.name = name;
    }

    public void setSelections(String[] selections) {
        this.selections = selections;
    }

    @SuppressWarnings("rawtypes")
	public int doEndTag() throws JspException {
        LoopTag parent = (LoopTag) findAncestorWithClass(this, LoopTag.class);
        if (parent == null) {
            throw new JspTagException("buildCheckbox: invalid parent");
        }

        Map.Entry current = (Map.Entry) parent.getCurrent();
        String text = (String) current.getKey();
        String value = (String) current.getValue();
        JspWriter out = pageContext.getOut();
        StringBuffer checkbox = new StringBuffer("<input type=\"checkbox\"");
        checkbox.append(" name=\"").append(name).append("\"").
            append(" value=\"").append(value).append("\"");
        if (isSelected(value, selections)) {
            checkbox.append(" checked");
        }
        checkbox.append(">").append(text);
        try {
            out.write(checkbox.toString());
        }
        catch (IOException e) {}
        return EVAL_PAGE;
    }

    private boolean isSelected(String value, String[] selections) {
        return StringFormat.isValidString(value, selections, false); 
    }
}
