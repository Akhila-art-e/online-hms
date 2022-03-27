package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.service.UserAuthService;
import com.project.vo.AppResponse;
import com.project.vo.LoginVO;
import com.project.vo.UserVO;

@RestController
public class UserAuthController {
	
	@Autowired
	UserAuthService userAuthService;

	@PostMapping("/registerUser")
	public ResponseEntity<AppResponse> registerUser(
			@Validated @RequestBody UserVO user
	) {
		AppResponse response = userAuthService.saveUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> loginUser(
			@Validated @RequestBody LoginVO loginVO
	) {
		return userAuthService.loginUser(loginVO);
	}
	
}
