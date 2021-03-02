package com.lawencon.bookleasing.dao;

import java.util.List;

import com.lawencon.bookleasing.model.BookDetails;

/**
 * @author Imron Rosyadi
 */

public interface BookDetailsDao {

	List<BookDetails> getListBookDetails() throws Exception;

	BookDetails findByCode(String code) throws Exception;

	BookDetails insertBookDetails(BookDetails bookDtl) throws Exception;

	void deleteById(Long id) throws Exception;

	void updateBookDetail(BookDetails bookDtl) throws Exception;

	List<BookDetails> findByBookCode(String bookCode) throws Exception;

}
