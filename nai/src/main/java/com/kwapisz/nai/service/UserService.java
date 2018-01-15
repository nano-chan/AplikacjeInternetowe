package com.kwapisz.nai.service;

import java.util.List;

import com.kwapisz.nai.domain.User;

public interface UserService {
	public User addUser(User user);
	public User getUser(Long id);
	public User updateUser(User user);
	public void removeUser(Long id);
	public List<User> allUsers();
}
