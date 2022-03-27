package com.project.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import com.project.vo.UserVO;

@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class UserAuthControllerTest {
	
	@LocalServerPort
    int randomServerPort;
	
	@Autowired
    private TestRestTemplate restTemplate;
	
	@Test
	public void contextLoads() throws Exception {
		assertThat(restTemplate).isNotNull();
	}
	
	@Test
	public void userRegTest() throws URISyntaxException {
		final String baseUrl = "http://localhost:"+randomServerPort+"/registerUser";
        URI uri = new URI(baseUrl);
        UserVO userVO = new UserVO();
        userVO.setUserID("test");
        userVO.setName("test");
        userVO.setEmailID("test"+Math.random()+"@gmail.com");
        userVO.setPassword("test");
        userVO.setPhoneNo("6006006006");
        userVO.setRetypePassword("test");
        userVO.setAddress("test");
        
         
        HttpHeaders headers = new HttpHeaders(); 
        HttpEntity<UserVO> request = new HttpEntity<>(userVO, headers);
         
        ResponseEntity<String> result = this.restTemplate.postForEntity(uri, request, String.class);
        System.out.println(result.getBody());
        
        assertEquals(201, result.getStatusCodeValue());
	}

}
