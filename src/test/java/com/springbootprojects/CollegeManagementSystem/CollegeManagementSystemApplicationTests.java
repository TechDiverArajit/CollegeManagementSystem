package com.springbootprojects.CollegeManagementSystem;

import com.springbootprojects.CollegeManagementSystem.Entities.User;
import com.springbootprojects.CollegeManagementSystem.Services.JwtService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CollegeManagementSystemApplicationTests {

	@Autowired
	private JwtService jwtService;
	@Test
	void contextLoads() {

//		User user = User.builder()
//				.id(4L)
//				.emailID("Arijit@gmail.com")
//				.password("Proxy111")
//				.build();
//
//		String token = jwtService.GenerateJwt(user);
//		System.out.println(token);
//
//		Long id = jwtService.getUserIdWithToken(token);
//		System.out.println(id);





	}





}
