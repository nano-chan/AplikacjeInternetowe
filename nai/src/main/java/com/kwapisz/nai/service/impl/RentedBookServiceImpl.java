package com.kwapisz.nai.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kwapisz.nai.domain.RentedBook;
import com.kwapisz.nai.domain.User;
import com.kwapisz.nai.repository.RentedBookRepository;
import com.kwapisz.nai.repository.UserRepository;
import com.kwapisz.nai.service.RentedBookService;

@Service("rentedBookService")
public class RentedBookServiceImpl implements RentedBookService{

	@Autowired
	private RentedBookRepository rentedBookRepository;
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void addRentedBook(User user, RentedBook rentedBook) {
		rentedBook.setUser(user);
		rentedBookRepository.save(rentedBook);
	}

	@Override
	public void removeRentedbook(Long userId, Long rentedBookId) {
		User user = userRepository.findOne(userId);
		if(user.getRentedBooks().size()>1){
			for(int i=0; i<user.getRentedBooks().size(); i++){
				if(user.getRentedBooks().get(i).getId().equals(rentedBookId)){
					user.getRentedBooks().remove(i);
				}
			}
		}else{
			user.getRentedBooks().clear();
		}
		userRepository.save(user);
		
	}

}
