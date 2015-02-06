package org.mingle.banana.jsp.tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.mingle.banana.jsp.beans.MixedMessageBean;

public class MixedMessageTag extends SimpleTagSupport {
	private MixedMessageBean mmb = new MixedMessageBean();
	
	private String category;

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public void doTag() throws JspException, IOException {
		mmb.setCategory(category);
		JspWriter out = this.getJspContext().getOut();
		out.println(mmb.getMessage());
	}
	
}
