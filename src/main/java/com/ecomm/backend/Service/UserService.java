package com.ecomm.backend.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ecomm.backend.Model.User;
import com.ecomm.backend.Payload.UserDto;
import com.ecomm.backend.Repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private ModelMapper mapper;

	public UserDto createUser(UserDto userDto) {
		Date date = new Date();
		userDto.setDate(date);
		User user = this.mapper.map(userDto, User.class);
		String pass = user.getPassword();
		String encodedPass = this.passwordEncoder.encode(pass);
		user.setPassword(encodedPass);
		User saveUser = this.userRepository.save(user);
		UserDto saveUserDto = this.mapper.map(saveUser, UserDto.class);
		return saveUserDto;
	}

	public List<UserDto> getUser() {
		List<User> lt = this.userRepository.findAll();
		List<UserDto> ltDto = lt.stream().map(user -> this.mapper.map(user, UserDto.class))
				.collect(Collectors.toList());
		return ltDto;
	}

	public UserDto getUserById(int userId) {
		User user = this.userRepository.findById(userId);
		UserDto userDto = this.mapper.map(user, UserDto.class);
		return userDto;
	}

	public String deleteUser(int userId) {
		this.userRepository.deleteById(userId);
		return "deleted Successfully";
	}

	public UserDto updateUser(int userId, UserDto userDto) {
		User user = this.userRepository.findById(userId);
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		;
		user.setAddress(userDto.getAddress());
		user.setPassword(userDto.getPassword());
		user.setPhone(userDto.getPhone());
		;
		user.setGender(userDto.getGender());
		user.setActive(userDto.isActive());
		User save = this.userRepository.save(user);
		UserDto saveDto = this.mapper.map(save, UserDto.class);
		return saveDto;
	}

}
