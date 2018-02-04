package com.kwapisz.nai.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kwapisz.nai.domain.User;
import com.kwapisz.nai.repository.UserRepository;
import com.kwapisz.nai.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User addUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User getUser(Long id) {
		return userRepository.findOne(id);
	}

	@Override
	public User updateUser(User user) {
		User changingUser = userRepository.findOne(user.getId());
		changingUser.setName(user.getName());
		changingUser.setSurname(user.getSurname());
		changingUser.setAge(user.getAge());
		return userRepository.save(changingUser);
	}

	@Override
	public void removeUser(Long id) {
		userRepository.delete(id);		
	}

	@Override
	public List<User> allUsers() {
		List<User> listOfUser = (List<User>) userRepository.findAll();
		return listOfUser;
	}

}
