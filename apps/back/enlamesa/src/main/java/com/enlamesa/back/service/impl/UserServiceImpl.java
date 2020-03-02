package com.enlamesa.back.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enlamesa.back.EnlamesaApplication;
import com.enlamesa.back.model.User;
import com.enlamesa.back.repository.UserRepository;
import com.enlamesa.back.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	private static Logger LOG = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> getUsers() {
		return userRepository.findAll();
	}

	@Override
	public User createUser(User user) throws Exception {
		if(!usernameExist(user)) {
			 return userRepository.save(user);
		}else {
			throw new Exception("Duplicate username"); 
		}
	}

	@Override
	public User updateUser(User user, Integer id) {
		User userToUpdate = new User();
		
		if(userRepository.existsById(id)) {
			userToUpdate = userRepository.getOne(id);
		}else {
			LOG.info("El usuario con id "+ id+" no existe. Creando usuario nuevo");
		}
		//En caso de añadir mas campos en BD, hay que añadirlos aquí
		userToUpdate.setUsername(user.getUsername());
		userToUpdate.setPassword(user.getPassword());
		return userRepository.save(userToUpdate);
	}

	@Override
	public void deleteUser(int idUser) {
		if(userRepository.existsById(idUser)) {
			userRepository.deleteById(idUser);
		}
	}
	
	
	private boolean usernameExist(User user) {
		User userAux = userRepository.findByUsername(user.getUsername());
		
		if(userAux!=null) 
			return true;
		else
			return false;
		
	}
	
	
}
