package com.samitekce.bookstore;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.samitekce.bookstore.domain.Book;
import com.samitekce.bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	@Bean
	public CommandLineRunner demo(BookRepository repository) {
	return (args) -> {
		repository.save(new Book("Good Book 1", "Amy C", "1990" , "isbn11", "20.99")); 
		repository.save(new Book("Better Book 2", "Jack B", "1996" , "isbn22", "10.99")); 
		repository.save(new Book("Best Book 3", "John A", "2012" , "isbn33", "50.99")); 
		
	};
	}
}
