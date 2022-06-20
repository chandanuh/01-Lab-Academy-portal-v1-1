package com.service;

import com.bean.*;

public class LoginService {

	// method to validate Admin user name and pwd

	public String validateAdmin(Login l) {

		if (l.getTypeOfUser().equals("Admin")) {

			// this is hard coded
			// ideally this can be done dynamic way
			if (l.getEmail().equals("Admin@gmail.com") && l.getPassword().equals("admin")) {
				return "Valid_Admin";
			} else {
				return "Invalid_Admin";
			}

		} else {
			return "NOT_AN_ADMIN";
		}

	}

}
