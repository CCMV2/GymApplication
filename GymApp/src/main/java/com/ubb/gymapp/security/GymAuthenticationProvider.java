package com.ubb.gymapp.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.ubb.gymapp.model.Administrator;
import com.ubb.gymapp.model.User;
import com.ubb.gymapp.model.User.UserType;
import com.ubb.gymapp.service.UserService;

@Component
public class GymAuthenticationProvider implements AuthenticationProvider  {
	
	@Autowired
	private UserService userService;
	
	public static final String SUPER_ADMIN_USER = "admin";
	public static final String SUPER_ADMIN_PASSWORD = "admin";

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = authentication.getName();
		String password = (String) authentication.getCredentials();

		if (username.equals(SUPER_ADMIN_USER) && password.equals(SUPER_ADMIN_PASSWORD)) {
			User admin = new Administrator(SUPER_ADMIN_PASSWORD, SUPER_ADMIN_USER, SUPER_ADMIN_USER, SUPER_ADMIN_USER, "");
			admin.setUserType(UserType.ADMIN);
			return new UsernamePasswordAuthenticationToken(admin, null, admin.getAuthorities());
		} else {
			User foundUser = userService.findUserByEmail(username);
			if (foundUser != null) {
				String dbPassword = foundUser.getPassword();
				BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
				
				// aici verificam daca:
				// 1. parola encodata e corecta - pt admini si traineri
				// 2. parola simpla (aka cnp) e coreacta - pt clienti
				if (passwordEncoder.matches(password, dbPassword) || password.equals(dbPassword)){
					return new UsernamePasswordAuthenticationToken(foundUser, null, foundUser.getAuthorities());
				} else {
					throw new BadCredentialsException("Wrong username or password");
				}
			} else {
				throw new BadCredentialsException("Wrong username or password");
			}
		}
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return true;
	}

}
