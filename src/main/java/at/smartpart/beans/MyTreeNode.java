package at.smartpart.beans;

import javax.swing.tree.DefaultMutableTreeNode;

public class MyTreeNode extends DefaultMutableTreeNode {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5728504476345569941L;
	
	private String name;
	private String version;
	

	public MyTreeNode(String name) {
		this.name = name;

	}

	public String getFileName() {
		return name;
	}

	public void setVersion(String version) {

		this.version=version;
		
	}

	public String getVersion() {
		return version;
	}
	

}
