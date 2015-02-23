package org.mingle.banana.jsp.tags.xmp;

import java.io.IOException;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.mingle.banana.jsp.beans.MixedMessageBean;

public class MixedMessageTag extends SimpleTagSupport {
	private MixedMessageBean mmb = new MixedMessageBean();

	// Attributes
	private String category;

	public void setCategory(String category) {
		this.category = category;
	}

	public void doTag() throws IOException {
		mmb.setCategory(category);
		JspWriter out = getJspContext().getOut();
		out.println(mmb.getMessage());
	}
}
