package com.lawencon.bookleasing.dao;

import java.util.List;

import com.lawencon.bookleasing.model.Books;

/**
 * @author Imron Rosyadi
 */

public interface BooksDao {

	List<Books> getListBooks() throws Exception;

	Books findByCode(String code) throws Exception;

	Books insertBook(Books book) throws Exception;

	void deleteById(Long id) throws Exception;

	void updateBook(Books book) throws Exception;

}
