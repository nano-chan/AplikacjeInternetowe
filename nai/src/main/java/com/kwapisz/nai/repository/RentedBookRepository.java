package com.kwapisz.nai.repository;

import org.springframework.data.repository.CrudRepository;

import com.kwapisz.nai.domain.RentedBook;

public interface RentedBookRepository extends CrudRepository<RentedBook, Long>{

}
