package com.avinash.book.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.avinash.book.entity.Book;

@Service
public class BookService1 {

	private static List<Book> list = new ArrayList<>();
	static {
//		list.add(new Book(1, "Marathi", "Avinash"));
//		list.add(new Book(2, "Math", "Vishal"));
//		list.add(new Book(3, "Science", "Kiran"));
//		list.add(new Book(4, "Geography", "Mayur"));
//		list.add(new Book(5, "Chemistry", "Laxman"));
	}

	// get all books
	public List<Book> getAllBooks() {
		return list;
	}

	public Book getBookById(int id) {
		Book book = null;
		try {
			book = list.stream().filter(e -> e.getId() == id).findFirst().get();
		} catch (Exception e) {
		}
		return book;
	}

	public Book createBook(Book book) {
		list.add(book);
		return book;
	}

	public Book updateBook(Book book, int id) {
//		list.set(id-1, book);

		list = list.stream().map(b -> {
			if (b.getId() == id) {
				b.setTitle(book.getTitle());
				b.setAuthor(book.getAuthor());
			}
			return b;
		}).collect(Collectors.toList());
		return book;
	}

	public void deleteBook(int id) {
//		list =list.stream().filter(book->{
//			if(book.getId()!=id) {
//				return true;
//			}else {
//				return false;
//			}
//		}).collect(Collectors.toList());
//		
		list = list.stream().filter(book -> book.getId() != id).collect(Collectors.toList());

//		list.remove(id-1);
	}

}
