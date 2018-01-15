package com.kwapisz.nai.service;

import com.kwapisz.nai.domain.RentedBook;
import com.kwapisz.nai.domain.User;

public interface RentedBookService {
	public void addRentedBook(User user, RentedBook rentedBook);
	public void removeRentedbook(User user, Long rentedBookId);
}
