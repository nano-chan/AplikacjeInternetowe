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
	public void removeRentedbook(User user, Long rentedBookId) {
		if(user.getRentedBook().size()>1){
			for(int i=0; i<user.getRentedBook().size(); i++){
				if(user.getRentedBook().get(i).getId().equals(rentedBookId)){
					user.getRentedBook().remove(i);
				}
			}
		}else{
			user.getRentedBook().clear();
		}
		userRepository.save(user);
		
	}

}
