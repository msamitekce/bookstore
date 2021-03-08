package com.samitekce.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import com.samitekce.bookstore.domain.Book;
import com.samitekce.bookstore.domain.BookRepository;
import com.samitekce.bookstore.domain.Category;
import com.samitekce.bookstore.domain.CategoryRepository;
import com.samitekce.bookstore.domain.User;
import com.samitekce.bookstore.domain.UserRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	@Bean
	public CommandLineRunner demo(BookRepository repository, CategoryRepository crepository, UserRepository urepository) {
	return (args) -> {
		crepository.save(new Category("IT"));
		crepository.save(new Category("Business"));
		crepository.save(new Category("Law"));
		repository.save(new Book("Good Book 1", "Amy C", "1990" , "isbn11", "20.99", crepository.findByName("IT").get(0))); 
		repository.save(new Book("Better Book 2", "Jack B", "1996" , "isbn22", "10.99", crepository.findByName("Law").get(0))); 
		repository.save(new Book("Best Book 3", "John A", "2012" , "isbn33", "50.99", crepository.findByName("Business").get(0))); 
		
		
		User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
		User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
		urepository.save(user1);
		urepository.save(user2); 
	};
}
}