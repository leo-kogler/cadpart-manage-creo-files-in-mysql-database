package com.example.cadpart;


import java.io.InputStream;
import java.util.List;

import com.vaadin.server.StreamResource.StreamSource;

public class MySQLImageSource implements StreamSource {
	

	private static final long serialVersionUID = 34037210918985572L;
	
	private List<MySQLSidePanelBean> beanList;

	
	
	public MySQLImageSource  (List<MySQLSidePanelBean> beanList){
	
	this.beanList = beanList;
		
	}

	@Override
	public InputStream getStream() {
	/*	
		int i;
		byte[] imageByteArray = new byte[16384];
		ByteArrayOutputStream imageBuffer = new ByteArrayOutputStream();
		InputStream imageBinStream = beanList.get(1).getImage();
		
		
		while ((i = imageBinStream.read(imageByteArray, 0, imageByteArray.length)) != -1) {
			imageBuffer.write(imageByteArray, 0, i);
		}
		
		 imageBuffer.flush();
		 
		 return imageBuffer.toByteArray();
		*/
		System.out.println("Listsize = " + beanList.size());
		
		 return beanList.get(0).getImage();
		
		
	}

}
