package com.samitekce.bookstore;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.assertj.core.api.Assertions.*;

import com.samitekce.bookstore.domain.Book;
import com.samitekce.bookstore.domain.BookRepository;
import com.samitekce.bookstore.domain.Category;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class BookFunctionTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void createwBook() {
	Book book = new Book("Test Book", "Test Author", "1232323-21", "1929", "10.0", new Category("Fiction"));
	bookRepository.save(book);
	assertThat(book.getId()).isNotNull();
    }

    @Test
    public void deleteBook() {
	long id = bookRepository.findByAuthor("Amy C").get(0).getId();
	bookRepository.deleteById(id);
	assertThat(bookRepository.findById(id)).isEmpty();
    }

    @Test
    public void findByISBN() {
	List<Book> book = bookRepository.findByIsbn("isbn22");
	assertThat(book).hasSize(1);
	assertThat(book.get(0).getTitle()).isEqualTo("Better Book 2");
    }

}
