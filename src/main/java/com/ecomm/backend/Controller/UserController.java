package com.ecomm.backend.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecomm.backend.Payload.UserDto;
import com.ecomm.backend.Service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/createUser")
	public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
		UserDto user = this.userService.createUser(userDto);
		return new ResponseEntity<UserDto>(user, HttpStatus.CREATED);
	}

	@GetMapping("/getUser")
	public ResponseEntity<List<UserDto>> getUser() {
		List<UserDto> lt = this.userService.getUser();
		return new ResponseEntity<List<UserDto>>(lt, HttpStatus.ACCEPTED);
	}

	@GetMapping("/getUserById/{userId}")
	public ResponseEntity<UserDto> getUserById(@PathVariable int userId) {
		UserDto userDto = this.userService.getUserById(userId);
		return new ResponseEntity<UserDto>(userDto, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/deleteUser/{userId}")
	public ResponseEntity<String> deleteUser(@PathVariable int userId) {
		String str = this.userService.deleteUser(userId);
		return new ResponseEntity<String>(str, HttpStatus.ACCEPTED);
	}

	@PutMapping("/updateUser/{userId}")
	public ResponseEntity<UserDto> updateUser(@PathVariable int userId, @RequestBody UserDto userDto) {
		UserDto updatedUserDto = this.userService.updateUser(userId, userDto);
		return new ResponseEntity<UserDto>(updatedUserDto, HttpStatus.ACCEPTED);
	}
}
