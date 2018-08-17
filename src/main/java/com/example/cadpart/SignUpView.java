package com.example.cadpart;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.Page;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

@Configurable
@SpringView(name = SignUpView.NAME)
public class SignUpView extends VerticalLayout implements View{

	
	@Autowired
	UserService userService;
	
	protected static final String NAME = "SignUpView";
	String[] formFields = {"email", "password", "firstname", "lastname"};
	
	public SignUpView () {
		
		setSizeFull();
		addStyleName("login-background"); 
		
		Panel panel = new Panel("Sign Up");
		panel.setWidth("800px");
		panel.setHeight("600px");
		
		FormLayout content = new FormLayout();
		String width = "250px";
		ArrayList<LblTfComponent> formFieldList = new ArrayList<LblTfComponent>();
		
		for(int i = 0; i < formFields.length; i++) {
			LblTfComponent field = new LblTfComponent(formFields[i], width);
			formFieldList.add(field);
			content.addComponent(field);
			System.out.println(i);
		}
		
		Button signUp = new Button("SignUp");
		signUp.addClickListener(new ClickListener() {
			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				
				CADPartUserBean user = new CADPartUserBean(
								formFieldList.get(0).textField.getValue().toString(),
								formFieldList.get(1).textField.getValue().toString(),
								0);
				
				user.setFirstName(formFieldList.get(2).textField.getValue().toString());
				user.setLastName(formFieldList.get(3).textField.getValue().toString());
				
				userService.insertNewUser(user);
				
				getUI().getNavigator().navigateTo(LoginView.NAME);
				Page.getCurrent().setUriFragment("!"+LoginView.NAME);

				
			}
			
		});
		
		content.addComponent(signUp);
		panel.setContent(content);
		addComponent(panel);
		setComponentAlignment(panel,  Alignment.MIDDLE_CENTER);
}

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}
	
}
