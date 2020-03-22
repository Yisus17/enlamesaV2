package com.enlamesa.back.service;

import java.util.List;

import com.enlamesa.back.model.User;

public interface UserService {

	List<User> getUsers();
	
	User getUser(Long id) throws Exception;

	User createUser(User user) throws Exception;

	User updateUser(User user, Long id) throws Exception;
	
	void deleteUser(Long idUser);
	
}
