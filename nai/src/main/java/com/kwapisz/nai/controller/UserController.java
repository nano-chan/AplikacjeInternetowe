package com.kwapisz.nai.controller;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kwapisz.nai.domain.User;
import com.kwapisz.nai.dto.UserDto;
import com.kwapisz.nai.service.UserService;


@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;

	@Autowired
	private ModelMapper modelMapper;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ModelAndView getUser(@PathVariable("id") Long id, ModelAndView mav) {
		User user = userService.getUser(id);
		mav.setViewName("editUser");
		mav.addObject("user", convertToDto(user));
		return mav;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView allUsers(ModelAndView mav) {
		List<User> listOfUsers = userService.allUsers();
		List<UserDto> dtos = new ArrayList<>();
		for (int i = 0; i < listOfUsers.size(); i++) {
			dtos.add(convertToDto(listOfUsers.get(i)));
		}
		mav.setViewName("user");
		mav.addObject("users", dtos);
		return mav;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView addUser(@ModelAttribute UserDto userDto, ModelAndView mav) {

		userService.addUser(convertToEntity(userDto));

		List<User> listOfUsers = userService.allUsers();
		List<UserDto> dtos = new ArrayList<>();
		for (int i = 0; i < listOfUsers.size(); i++) {
			dtos.add(convertToDto(listOfUsers.get(i)));
		}
		mav.setViewName("user");
		mav.addObject("users", dtos);
		return mav;
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	public ModelAndView editUser(@ModelAttribute UserDto userDto, ModelAndView mav) {
		User user = convertToEntity(userDto);
		userService.updateUser(user);
		List<User> listOfUsers = userService.allUsers();
		List<UserDto> dtos = new ArrayList<>();
		for (int i = 0; i < listOfUsers.size(); i++) {
			dtos.add(convertToDto(listOfUsers.get(i)));
		}
		mav.setViewName("user");
		mav.addObject("users", userDto);
		return new ModelAndView("redirect:/user");
	}
	
	@RequestMapping(value="/delete", method = RequestMethod.POST)
	public ModelAndView  deleteUser(@RequestParam(value="id", required=true) Long id, ModelAndView mav){
		userService.removeUser(id);
		List<User> listOfUsers = userService.allUsers();
		List<UserDto> dtos = new ArrayList<>();
		for (int i = 0; i < listOfUsers.size(); i++) {
			dtos.add(convertToDto(listOfUsers.get(i)));
		}
		mav.setViewName("user");
		mav.addObject("user", dtos);
		return new ModelAndView("redirect:/user");
	}

	private UserDto convertToDto(User user) {
		return modelMapper.map(user, UserDto.class);
	}

	private User convertToEntity(UserDto userDto){
		return modelMapper.map(userDto, User.class);
	}
}
