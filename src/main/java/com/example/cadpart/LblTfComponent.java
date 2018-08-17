package com.example.cadpart;

import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;

public class LblTfComponent extends HorizontalLayout{

	TextField textField;

	public LblTfComponent(String name, String width) {

		Label lblCaption = new Label(name);
		lblCaption.setWidth(width);
		textField = new TextField();
		textField.setWidth(width);

		addComponent(lblCaption);
		addComponent(textField);


	}


	public String getTfData() {
		return textField.getData().toString();
	}

}
