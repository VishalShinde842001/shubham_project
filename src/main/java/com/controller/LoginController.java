package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bo.ErrorConstants;
import com.bo.Response;
import com.model.User;
import com.service.LoginService;

@RestController
@CrossOrigin
@RequestMapping("/rest/")
public class LoginController {

	@Autowired
	private LoginService loginService;

	@PostMapping("sign-up")
	public Response signUp(@RequestBody User user) {
		Response response = new Response();
		try {
			return loginService.signUp(user);
		} catch (Exception e) {
			response.setStatus(ErrorConstants.INTERNAL_SERVER_ERROR);
			response.setMessage(e.getMessage());
		}
		return response;
	}

	@PostMapping("login")
	public Response login(@RequestBody User user) {
		Response response = new Response();
		try {
			return loginService.login(user);

		} catch (Exception e) {
			response.setStatus(ErrorConstants.INTERNAL_SERVER_ERROR);
			response.setMessage(ErrorConstants.INTERNAL_SERVER_ERROR_MESSAGE);
		}
		return response;
	}
	
	
	
	
	
	

}
