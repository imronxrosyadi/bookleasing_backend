package com.lawencon.bookleasing.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lawencon.bookleasing.model.Books;
import com.lawencon.bookleasing.repo.BooksRepo;

/**
 * @author Imron Rosyadi
 */

@Repository(value = "bookJpa")
public class BooksDaoJpaImpl extends BaseDao implements BooksDao {

	@Autowired
	private BooksRepo booksRepo;

	@Override
	public List<Books> getListBooks() throws Exception {
		return booksRepo.findAll();
	}

	@Override
	public Books findByCode(String code) throws Exception {
		return booksRepo.findByBookCode(code);
	}

	@Override
	public Books insertBook(Books book) throws Exception {
		return booksRepo.save(book);
	}

	@Override
	public void deleteById(Long id) throws Exception {
		booksRepo.deleteById(id);
	}

	@Override
	public void updateBook(Books book) throws Exception {
		booksRepo.save(book);
	}

}
