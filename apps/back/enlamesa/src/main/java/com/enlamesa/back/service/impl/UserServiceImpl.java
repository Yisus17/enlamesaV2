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
	public User getUser(Long id) {

		Optional<User> opt = userRepository.findById(id);
		User user = opt.get();
		return user;
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
	public User updateUser(User user, Long id) throws Exception {
		User userToUpdate = new User();

		if(userRepository.existsById(id)) {
			userToUpdate = userRepository.getOne(id);
			//En caso de añadir mas campos en BD, hay que añadirlos aquí
			userToUpdate.setUsername(user.getUsername());
			userToUpdate.setPassword(user.getPassword());
		}else {
			String errormsg = "El usuario con id "+ id+" no existe.";
			LOG.info(errormsg);
			throw new Exception(errormsg); 
		}

		return userRepository.save(userToUpdate);
	}

	@Override
	public void deleteUser(Long idUser) {
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
