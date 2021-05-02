package com.avinash.book.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.avinash.book.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer>{

	
}
