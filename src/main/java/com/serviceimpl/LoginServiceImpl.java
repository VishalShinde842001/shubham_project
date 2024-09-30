package com.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bo.ErrorConstants;
import com.bo.Response;
import com.dao.LoginDao;
import com.model.User;
import com.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginDao loginDao;

	@Override
	public Response signUp(User user) throws Exception {
		Response response = new Response();
		try {
			if (null != user && null != user.getEmail() && null != user.getPassword()) {
				if (!loginDao.findUserByEmail(user.getEmail()).isPresent()) {
					loginDao.save(user);
					response.setResult(user);
					response.setStatus(ErrorConstants.SUCESS);
					response.setMessage("Sign Up Sucessfully...");
					;
				} else {
					response.setStatus(ErrorConstants.ALREADY_REPORTED);
					response.setMessage("Email Already Present...");
				}
			} else {
				response.setMessage(ErrorConstants.REQUIRED_FIELD_MISSING);
				response.setStatus(ErrorConstants.BAD_REQUEST);
			}
		} catch (Exception e) {
			throw e;
		}
		return response;
	}

	@Override
	public Response login(User user) throws Exception {
		Response response = new Response();
		try {
			if (null != user && null != user.getEmail() && null != user.getPassword()) {
				Optional<User> existingUser = loginDao.findUserByEmail(user.getEmail());
				if (existingUser.isPresent()) {
					if (user.getPassword().equals(existingUser.get().getPassword())) {
						response.setResult(existingUser.get());
						response.setStatus(ErrorConstants.SUCESS);
						response.setMessage("Login Sucessfully...");
					}else {
						response.setMessage("Email Or Password is Wrong...");
						response.setStatus(ErrorConstants.BAD_REQUEST);
					}
					;
				} else {
					response.setStatus(ErrorConstants.NOT_FOUND);
					response.setMessage("User Not Found");
				}

			} else {
				response.setMessage(ErrorConstants.REQUIRED_FIELD_MISSING);
				response.setStatus(ErrorConstants.BAD_REQUEST);
			}
		} catch (Exception e) {
			throw e;
		}
		return response;
	}

}
