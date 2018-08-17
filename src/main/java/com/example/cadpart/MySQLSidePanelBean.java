package com.example.cadpart;

import java.io.InputStream;

public class MySQLSidePanelBean {
	
	private String prt_number = "";
	private String prt_version ="";
	private InputStream imageBinStream = null;

	public MySQLSidePanelBean(String prt_number , InputStream imageBinStream, String prt_version) {

		this.prt_number = prt_number;
		this.prt_version = prt_version;
		this.imageBinStream=imageBinStream;
		
	}
	
	
	public String getPrtNumber() {
		return prt_number;
	}
	
	public String getPrtVersion() {
		return prt_version;
	}
	
	public InputStream getImage() {		
		return imageBinStream;
	}

}
