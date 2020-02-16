package com.enlamesa.back.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enlamesa.back.model.User;
import com.enlamesa.back.repository.UserRepository;
import com.enlamesa.back.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
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
	public User updateUser(User user) {
		int idUser = user.getIdUser();
		Optional<User> userFromBDOptional = userRepository.findById(idUser);
		
		if(userFromBDOptional.isPresent()) {
			User userFromBD = userFromBDOptional.get();
			userFromBD.setUsername(user.getUsername());
			userFromBD.setPassword(user.getPassword());
			return userRepository.save(userFromBD);
		}else {
			return userRepository.save(user);
		}

	}

	@Override
	public void deleteUser(int idUser) {
		if(userRepository.existsById(idUser)) {
			userRepository.deleteById(idUser);
		}
	}
	
	
	private boolean usernameExist(User user) {
		User userAux = userRepository.findByUsername(user.getUsername());
		if(userAux.getUsername().equals(user.getUsername())) {
			return true;
		}
		return false;
	}
	
	
}
