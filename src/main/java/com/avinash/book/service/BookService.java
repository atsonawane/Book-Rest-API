package com.avinash.book.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avinash.book.dao.BookRepository;
import com.avinash.book.entity.Book;

@Service
public class BookService {
	
	@Autowired
	BookRepository repository;

	public List<Book> getAllBooks() {
		return this.repository.findAll();
	}

	public Optional<Book> getBookById(int id) {
		return this.repository.findById(id);
	}

	public Book createBook(Book book) {
		return this.repository.save(book);
	}

	public Book updateBook(Book book, int id) {
		return this.repository.save(book);
	}

	public void deleteBook(int id) {
		this.repository.deleteById(id);
	}
}
