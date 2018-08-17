package com.example.cadpart;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;

import java.util.Map;

import javax.swing.JTree;

public class PRT {

	private String fileName;
	private String localVersion;
	private String dbVersion;
	private String newVersion;
	private String child;
	private String parent;
	private String version;
	private JTree myAsm = null;// = new HashMap<String, JTree>();

	public PRT(String fileName, String version) {
		this.fileName = fileName;
		this.localVersion = version;
	}


	public PRT(String child, String parent, String fileName, String localVersion) {
		
		this.child = child;
		this.parent = parent;
		this.fileName = fileName;
		this.localVersion = localVersion;

	}
	
	@SuppressWarnings("unchecked")
	public PRT(String fileName, String version, Object object) {
		
		
		this.fileName=fileName;
		this.version=version;
		
		try {
			byte[] st = (byte[])object;
			ByteArrayInputStream boi = new ByteArrayInputStream(st);
			ObjectInputStream ois = new ObjectInputStream(boi);
			
			this.myAsm = (JTree) ois.readObject();
		} catch (ClassNotFoundException e) {
			
			System.out.println("//////////clnf\\\\\\\\\\");

			e.printStackTrace();
		} catch (IOException e) {
			
			System.out.println("//////////ioex\\\\\\\\\\");

			e.printStackTrace();
		}



	}

	public String getFileName() {
		return fileName;
	}

	public String getLocalVersion() {
		return localVersion;

	}
	
	public void setCurVersion (String dbVersion) {
		this.dbVersion = dbVersion;
	}
	
	public void setNewVersion (String newVersion) {
		this.newVersion = newVersion;
	}

	public String getCurVersion() {
		return dbVersion;
	}
	
	public String getNewVersion() {
		return newVersion;
	}

	
	public String getPRT() {
		return child;
	}

	public String getASM() {
		return parent;

	}


/*	public Map<String, JTree> getTreeList() {
		return this.myAsm;
	}
*/	
	public JTree getTree() {
		return this.myAsm;
	}

}
