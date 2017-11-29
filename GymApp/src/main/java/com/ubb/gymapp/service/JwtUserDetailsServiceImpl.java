package com.ubb.gymapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ubb.gymapp.model.User;
import com.ubb.gymapp.model.User.UserType;
import com.ubb.gymapp.repository.UserRepository;

@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	//FIXME add new method findByUsername in the repository
    	//        User user = userRepository.findByUsername(username);
    	// and replace the lines below with the right line
    	User user = null;
    	if(username.equals("admin")){
    		user = new User();
    		user.setEmail("admin");
    		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    		String hashedPassword = passwordEncoder.encode("admin");
    		user.setPassword(hashedPassword);
    		user.setUserType(UserType.ADMIN);
    		
    		
    	}
    	else
    	{
    		user = userRepository.findByEmail(username);
    		
    	}
        if (user == null) {
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
        } else {
            return user;
        }
    }
}
