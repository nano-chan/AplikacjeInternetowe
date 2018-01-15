package com.kwapisz.nai.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kwapisz.nai.domain.RentedBook;
import com.kwapisz.nai.domain.User;
import com.kwapisz.nai.repository.RentedBookRepository;
import com.kwapisz.nai.repository.UserRepository;

@Controller
@RequestMapping(path = "/")
public class MainController {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RentedBookRepository rentedBookRepository;

	
	@GetMapping(path = "/download")
	public String ReadyData() {
		User user = new User();
		user.setName("Ola");
		user.setSurname("Kwiatkowska");
		user.setAge(15);
		List<RentedBook> rentedBook = new ArrayList<>();
		RentedBook r1 = new RentedBook();
		r1.setTitle("t1");
		r1.setUser(user);
		rentedBook.add(r1);
		
		user.setRentedBook(rentedBook);
		userRepository.save(user);
		rentedBookRepository.save(rentedBook);
		return "saved";
	}
}
