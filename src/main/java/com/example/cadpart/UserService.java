package com.example.cadpart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.cadpart.CADPartUserBean;

import java.util.List;

@Component
public class UserService {

	@Autowired
	private JdbcTemplate jdbcTemplate;


	public List<CADPartUserBean> getUserData(String emailAddr) {
		List <CADPartUserBean> list = jdbcTemplate.query("SELECT email, token, logins from fingerprint.userdata WHERE email = '" + emailAddr + "';", (rs,
				rowNum) -> new CADPartUserBean(rs.getString("email"), rs.getString("token"), rs.getInt("logins")));
		return list;
	}
	
	public void insertNewUser (CADPartUserBean user) {
		jdbcTemplate.update("INSERT INTO fingerprint.userdata (email, token, logins, firstname, lastname )VALUES (?,?,?,?,?);",
						user.getUserName(), user.getToken(), 0, user.getFirstName(), user.getLastName());
	}
	

}