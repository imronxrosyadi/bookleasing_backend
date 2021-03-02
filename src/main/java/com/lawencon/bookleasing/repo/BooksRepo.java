package com.lawencon.bookleasing.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lawencon.bookleasing.model.Books;

/**
 * @author Imron Rosyadi
 */

@Repository
public interface BooksRepo extends JpaRepository<Books, Long> {

	Books findByBookCode(String bookCode) throws Exception;

}
