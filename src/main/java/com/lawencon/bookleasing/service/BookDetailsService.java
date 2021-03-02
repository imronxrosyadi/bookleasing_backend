package com.lawencon.bookleasing.service;

import java.util.List;

import com.lawencon.bookleasing.model.BookDetails;

/**
 * @author Imron Rosyadi
 */

public interface BookDetailsService {

	List<BookDetails> getListBookDetails() throws Exception;

	BookDetails findByCode(String code) throws Exception;

	BookDetails insertBookDetails(BookDetails bookDtl) throws Exception;

	void deleteById(Long id) throws Exception;

	void updateBookDetail(BookDetails bookDtl) throws Exception;

	List<BookDetails> findByBookCode(String bookCode) throws Exception;

}
