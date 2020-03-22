package com.enlamesa.back.auth;

import java.util.Map;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import com.enlamesa.back.model.User;
import com.enlamesa.back.repository.UserRepository;


@Component
public class TokenAditionalInfo implements TokenEnhancer{

	//Con el userRepository podemos meter toda la info adicional que queramos en el token
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		User user = userRepository.findByUsername(authentication.getName());
		
		
		Map<String, Object> info = new HashMap<>();
		info.put("user_aditional_data_name: ", user.getId().toString()+"-"+user.getUsername());
		info.put("user_aditional_data_email: ", user.getId().toString()+"-"+user.getEmail());
		
		((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(info);
		return accessToken;
	}

}
