package com.lawencon.bookleasing.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lawencon.bookleasing.model.BookDetails;

/**
 * @author Imron Rosyadi
 */

@Repository
public interface BookDetailsRepo extends JpaRepository<BookDetails, Long> {

	BookDetails findByBookDtlCode(String bookDtlCode) throws Exception;

	@Query("SELECT bh.id, bh.bookCode, bd.bookDtlCode, a.authorName, l.langName, r.rackCode, p.profileName "
			+ " FROM BookDetails as bd INNER JOIN bd.bookId as bh INNER JOIN bd.authorId as a "
			+ " INNER JOIN bd.languageId as l INNER JOIN bd.rackId as r INNER JOIN bd.profileId as p"
			+ " WHERE bh.bookCode = ?1")
	List<Object[]> findByBookCode(String bookCode) throws Exception;

}
