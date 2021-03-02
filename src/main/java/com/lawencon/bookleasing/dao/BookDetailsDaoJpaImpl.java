package com.lawencon.bookleasing.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lawencon.bookleasing.model.Authors;
import com.lawencon.bookleasing.model.BookDetails;
import com.lawencon.bookleasing.model.Books;
import com.lawencon.bookleasing.model.Languages;
import com.lawencon.bookleasing.model.Profiles;
import com.lawencon.bookleasing.model.Racks;
import com.lawencon.bookleasing.repo.BookDetailsRepo;

/**
 * @author Imron Rosyadi
 */

@Repository(value = "bookDetailJpa")
public class BookDetailsDaoJpaImpl extends BaseDao implements BookDetailsDao {

	@Autowired
	private BookDetailsRepo bookDetailsRepo;

	@Override
	public List<BookDetails> getListBookDetails() throws Exception {
		return bookDetailsRepo.findAll();
	}

	@Override
	public BookDetails findByCode(String code) throws Exception {
		return bookDetailsRepo.findByBookDtlCode(code);
	}

	@Override
	public BookDetails insertBookDetails(BookDetails bookDtl) throws Exception {
		return bookDetailsRepo.save(bookDtl);
	}

	@Override
	public void deleteById(Long id) throws Exception {
		bookDetailsRepo.deleteById(id);
	}

	@Override
	public void updateBookDetail(BookDetails bookDtl) throws Exception {
		bookDetailsRepo.save(bookDtl);
	}

	@Override
	public List<BookDetails> findByBookCode(String bookCode) throws Exception {
		List<BookDetails> listBookDetails = new ArrayList<>();
		List<Object[]> listObj = bookDetailsRepo.findByBookCode(bookCode);
		listObj.forEach(objArr -> {
			Books book = new Books();
			book.setId((Long) objArr[0]);
			book.setBookCode((String) objArr[1]);
			BookDetails bookDtl = new BookDetails();
			bookDtl.setBookDtlCode((String) objArr[2]);
			Authors author = new Authors();
			author.setAuthorName((String) objArr[3]);
			Languages lang = new Languages();
			lang.setLangName((String) objArr[4]);
			Racks rack = new Racks();
			rack.setRackCode((String) objArr[5]);
			Profiles profile = new Profiles();
			profile.setProfileName((String) objArr[6]);

			bookDtl.setBookId(book);
			bookDtl.setAuthorId(author);
			bookDtl.setLanguageId(lang);
			bookDtl.setRackId(rack);
			bookDtl.setProfileId(profile);

			listBookDetails.add(bookDtl);
		});
		return listBookDetails;
	}

}
