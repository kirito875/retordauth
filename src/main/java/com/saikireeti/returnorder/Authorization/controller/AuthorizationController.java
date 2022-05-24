package com.saikireeti.returnorder.Authorization.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.saikireeti.returnorder.Authorization.JwtUtil;

@RestController
public class AuthorizationController {

	@Autowired
	private JwtUtil jwtToken;
	
	@GetMapping("/GenerateToken/{username}")
     public String getTokenForUser(@PathVariable String username) {
    	 
		return jwtToken.generateToken(username);
     }

	@GetMapping("/ValidateToken")
	public Boolean getValidationForToken(@RequestHeader("Authorization") String token) {
		Boolean valid=false;
		if(jwtToken.validateToken(token)) {
			valid=true;
		}
		else {
			valid=false;
		}
		return valid;
	}
}
