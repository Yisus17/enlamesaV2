package com.enlamesa.back.service;

import java.util.List;

import com.enlamesa.back.model.User;

public interface UserService {

	List<User> getUsers();

	User createUser(User user) throws Exception;

	User updateUser(User user, Integer id);
	
	void deleteUser(int idUser);
	
}
