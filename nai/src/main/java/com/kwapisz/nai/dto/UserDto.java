package com.kwapisz.nai.dto;

import java.util.List;

import com.kwapisz.nai.domain.RentedBook;

public class UserDto {
	private Long id;
	private String name;
	private String surname;
	private int age;
	private List<RentedBookDto> rentedBooks;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public List<RentedBookDto> getRentedBooks() {
		return rentedBooks;
	}
	public void setRentedBooks(List<RentedBookDto> rentedBooks) {
		this.rentedBooks = rentedBooks;
	}
}
