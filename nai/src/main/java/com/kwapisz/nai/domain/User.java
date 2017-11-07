package com.kwapisz.nai.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String name;
	private String surname;
	private int age;
	@OneToMany
	private List<RentedBook> rentedBooks;
	
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
	public List<RentedBook> getRentedBook() {
		return rentedBooks;
	}
	public void setRentedBook(List<RentedBook> rentedBook) {
		this.rentedBooks = rentedBook;
	}
	
	public void addRentedBook(RentedBook book){
		this.rentedBooks.add(book);
		book.setUser(this);
	}
}
