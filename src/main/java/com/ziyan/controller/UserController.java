package com.ziyan.controller;

import com.ziyan.domain.User;
import com.ziyan.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.io.IOException;

@Controller
@RequestMapping("/api")
public class UserController {

	@Resource
	private UserService userService;

	@GetMapping("/user")
	public ResponseEntity<User> selectUser(@RequestParam Long id) throws IOException {

		User user = this.userService.selectUser(id);
		return ResponseEntity.ok(user);
	}

}