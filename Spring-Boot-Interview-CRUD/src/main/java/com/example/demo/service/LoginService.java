package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class LoginService {
	public boolean validateUser(String userid, String password) {
		
		return userid.equalsIgnoreCase("b2metric")
				&& password.equalsIgnoreCase("2018");
	}
}
