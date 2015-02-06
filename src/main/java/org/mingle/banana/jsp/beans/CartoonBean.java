package org.mingle.banana.jsp.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CartoonBean implements Serializable {
	
	private static final long serialVersionUID = 8047870078729100303L;
	
	private static int index = -1;
	private List<String> fileNames;
	
	public CartoonBean() {
		initFileList();
	}
	
	public String getFileName() {
		index++;
		if (index > fileNames.size() - 1) {
			index = 0;
		}
		
		return fileNames.get(index);
	}
	
	private void initFileList() {
		fileNames = new ArrayList<String>();
		fileNames.add("dilbert2001113293109.gif");
		fileNames.add("dilbert2001166171101.gif");
		fileNames.add("dilbert2001166171108.gif");
		fileNames.add("dilbert2731150011029.gif");
	}
	
}
