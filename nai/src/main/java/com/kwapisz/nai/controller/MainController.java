package com.kwapisz.nai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kwapisz.nai.domain.RentedBook;
import com.kwapisz.nai.domain.User;
import com.kwapisz.nai.repository.UserRepository;

@Controller
@RequestMapping(path = "/demo")
public class MainController {
	@Autowired
	private UserRepository userRepository;

	@GetMapping(path = "/add")
	public @ResponseBody String addNewUser(@RequestParam String name, @RequestParam String surname,
			@RequestParam int age, @RequestParam List<RentedBook> rentedBook) {
		User user = new User();
		user.setName(name);
		user.setSurname(surname);
		user.setAge(age);
		user.setRentedBook(rentedBook);
		userRepository.save(user);
		return "Saved";
	}

	@GetMapping(path = "/all")
	public @ResponseBody Iterable<User> getAllUsers() {
		return userRepository.findAll();
	}
}
