package com.ubb.gymapp.controller;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ubb.gymapp.model.Client;
import com.ubb.gymapp.model.User;
import com.ubb.gymapp.model.User.UserType;
import com.ubb.gymapp.security.JwtAuthenticationRequest;
import com.ubb.gymapp.security.JwtAuthenticationResponse;
import com.ubb.gymapp.security.JwtTokenUtil;

@RestController
public class AuthenticationRestController {

    @Value("${jwt.header}")
    private String tokenHeader;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @RequestMapping(value = "${jwt.route.authentication.path}", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtAuthenticationRequest authenticationRequest) throws AuthenticationException {

        // Perform the security
        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticationRequest.getUsername(),
                        authenticationRequest.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Reload password post-security so we can generate token
        final User user = (User) authentication.getPrincipal();
        final String token = jwtTokenUtil.generateToken(user);

        long start = 0;
        if (user.getUserType().equals(UserType.CLIENT)) {
        	Date dat = new Date();
        	dat = ((Client) user).getStart();
        	Calendar cal = Calendar.getInstance();
        	cal.setTime(dat);
        	cal.add(Calendar.DAY_OF_YEAR, ((Client) user).getSubscription().getDuration());
        	start = cal.getTimeInMillis();
        }
        // Return the token
        return ResponseEntity.ok(new JwtAuthenticationResponse(token, user.getUserType().toString(), start));
    }

}
