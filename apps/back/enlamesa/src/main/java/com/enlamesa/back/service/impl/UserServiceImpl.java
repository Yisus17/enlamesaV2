package com.enlamesa.back.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.enlamesa.back.model.User;
import com.enlamesa.back.repository.UserRepository;
import com.enlamesa.back.service.UserService;



@Service
public class UserServiceImpl implements UserService, UserDetailsService {

	private static Logger LOG = LoggerFactory.getLogger(UserService.class);

	@Lazy
	@Autowired
	public BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> getUsers() {
		return userRepository.findAll();
	}

	@Override
	public User getUser(Long id) throws Exception{
		Optional<User> usertOpt = userRepository.findById(id);
		User result = null;
		if(usertOpt.isPresent()) {
			return usertOpt.get();
		}else {
			throw new Exception("User "+ id+" not found");
		}
	}

	@Override
	public User createUser(User user) throws Exception {
		String pass = passwordEncoder.encode(user.getPassword());
		if(!usernameExist(user)) {
			user.setPassword(pass);
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
			
			//En caso de añadir mas campos en BD, hay que añadirlos al final
			if(user.getUsername() != null)
				userToUpdate.setUsername(user.getUsername());
			if(user.getEmail() != null)
				userToUpdate.setEmail(user.getEmail());
			if(user.getEnabled() != null)
				userToUpdate.setEnabled(user.getEnabled());
			if(user.getName() != null)
				userToUpdate.setName(user.getName());
			if(user.getRoles() != null)
				userToUpdate.setRoles(user.getRoles());
			if(user.getLastName() != null)
				userToUpdate.setLastName(user.getLastName());
			if(user.getPassword() != null) 		
				userToUpdate.setPassword(passwordEncoder.encode(user.getPassword())); //encoder de contraseña
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
	//Metodo de SpringSecurity
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User usuario = userRepository.findByUsername(username);
		
		if(usuario == null) {
			LOG.error("Login error : Usuario no encontrado, username: "+username);
			throw new UsernameNotFoundException("Login error : Usuario no encontrado, username: "+username);
		}
		
		//tomar la lista de roles de nuestra clase, a los roles (authorities de spring security) con map.
		List<GrantedAuthority> authorities = usuario.getRoles()
				.stream()
				.map(role -> new SimpleGrantedAuthority(role.getName()))
				.peek(authority -> LOG.info("Role: "+ authority.getAuthority()))
				.collect(Collectors.toList());
		
		return new org.springframework.security.core.userdetails.User(username, usuario.getPassword(), usuario.getEnabled(),
				true, true, true, authorities);
	}

	
	public String passwordGenerator(String password) {
		return passwordEncoder.encode(password);
	}

}
