package com.service;

import com.bo.Response;
import com.model.User;

public interface LoginService {

	Response signUp(User user) throws Exception;

	Response login(User user) throws Exception;

}
