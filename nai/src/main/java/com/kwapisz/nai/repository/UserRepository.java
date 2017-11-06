package com.kwapisz.nai.repository;

import org.springframework.data.repository.CrudRepository;

import com.kwapisz.nai.domain.User;

public interface UserRepository extends CrudRepository<User, Long>{

}
