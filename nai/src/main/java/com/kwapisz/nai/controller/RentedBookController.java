package com.kwapisz.nai.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kwapisz.nai.domain.RentedBook;
import com.kwapisz.nai.domain.User;
import com.kwapisz.nai.dto.RentedBookDto;
import com.kwapisz.nai.service.RentedBookService;
import com.kwapisz.nai.service.UserService;

@Controller
@RequestMapping("/rentedBook")
public class RentedBookController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private RentedBookService rentedBookService;
	
	@RequestMapping(value="/{id}", method = RequestMethod.POST)
	public ModelAndView addRentedBook(@PathVariable("id") Long id, @ModelAttribute RentedBookDto rentedBookDto, ModelAndView mav){
		User user = userService.getUser(id);
		System.out.println(user);
		RentedBook rentedBook = convertRentedBookToEnity(rentedBookDto);
		rentedBookService.addRentedBook(user, rentedBook);
	
		return new ModelAndView("redirect:/user/"+id);
	}
	
	@RequestMapping(value="/delete", method = RequestMethod.POST)
	public ModelAndView deleteRentedBook(@RequestParam(value="rentedBookId", required=true) Long rentedBookId, @RequestParam(value="userId", required=true) Long userId, ModelAndView mav){
		rentedBookService.removeRentedbook(userId, rentedBookId);
		return new ModelAndView("redirect:/user/"+userId);
	}
	
	private RentedBook convertRentedBookToEnity(RentedBookDto rentedBookDto){
		return modelMapper.map(rentedBookDto, RentedBook.class);
	}
}
