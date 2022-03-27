package com.project.service;

import java.util.Calendar;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.exceptions.OHISBusinessException;
import com.project.model.UserDetails;
import com.project.repository.UserDetailsRepository;
import com.project.vo.AppResponse;
import com.project.vo.LoginVO;
import com.project.vo.UserVO;

@Service
public class UserAuthService {

	@Autowired
	private UserDetailsRepository userRepository;

	public AppResponse saveUser(UserVO user) {
		UserDetails userDetails = new UserDetails();
		String userId = getUserId();
		userDetails.setUserid(userId);
		userDetails.setName(user.getName());
		userDetails.setEmail_id(user.getEmailID());
		userDetails.setAddress(user.getAddress());
		userDetails.setDateOfReg(user.getRegDate());
		userDetails.setPh_no(user.getPhoneNo());
		userDetails.setUser_pass(user.getPassword());
		
		//select * from UserDetails where emails_id = 'test@gmail.com'
		Optional<UserDetails> existingUserDetails =
				userRepository.findByEmailId(user.getEmailID());
		
		if (existingUserDetails.isPresent()) {
			throw new OHISBusinessException("EMail ID already registered", "501");
		}
		
		if (!user.getPassword().equalsIgnoreCase(user.getRetypePassword())) {
			throw new OHISBusinessException("Password and Confirm Password should match", "502");
		}
		

		try {
			userRepository.save(userDetails); //INsert 
			AppResponse appResponse = new AppResponse();
			appResponse.setMessage("Successfully created User");
			appResponse.setUserId(userId);
			return appResponse;
		} catch (Exception ex) {
			AppResponse appResponse = new AppResponse();
			appResponse.setMessage("User creation failed");
			return appResponse;
		}
	}

	private String getUserId() {
		Random random = new Random();
		int threeDigitNumber = random.nextInt(900) + 100; //generates three digit random number

		Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR) % 100;
		return "U-" + threeDigitNumber + "/" + year;
	}

	public ResponseEntity<String> loginUser(LoginVO loginVO) {
		//select * from UserDetails where email_id = 'test@gmail.com' and password = 'test123'
		Optional<UserDetails> existingUser = userRepository.findByEmailIdAndPassword(loginVO.getEmail(),
				loginVO.getPassword());
		if (existingUser.isPresent()) {
			return ResponseEntity.ok("Login Successfull");
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Login Failed");
		}
	}
}
