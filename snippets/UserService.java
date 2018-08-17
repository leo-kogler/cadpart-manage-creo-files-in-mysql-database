package com.example.cadpart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
@Service("userService")
public class UserService {

	@Autowired
	private JdbcTemplate jdbcTemplate;


	public List<CADPartUserBean> getUserData(String emailAddr) {
		List <CADPartUserBean> list = jdbcTemplate.query("SELECT email, token, logins from fingerprint.userdata WHERE email = '" + emailAddr + "';", (rs,
				rowNum) -> new CADPartUserBean(rs.getString("email"), rs.getString("token"), rs.getInt("logins")));
		return list;
	}
	

}