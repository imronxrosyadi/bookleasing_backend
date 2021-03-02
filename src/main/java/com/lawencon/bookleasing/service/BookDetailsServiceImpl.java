package com.lawencon.bookleasing.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lawencon.bookleasing.dao.BookDetailsDao;
import com.lawencon.bookleasing.model.Authors;
import com.lawencon.bookleasing.model.BookDetails;
import com.lawencon.bookleasing.model.Books;
import com.lawencon.bookleasing.model.Languages;
import com.lawencon.bookleasing.model.Profiles;
import com.lawencon.bookleasing.model.Racks;

/**
 * @author Imron Rosyadi
 */

@Service
@Transactional
public class BookDetailsServiceImpl extends BaseService implements BookDetailsService {

	private BookDetailsDao bookDtlDao;
	private BooksService booksService;
	private AuthorsService authorsService;
	private LanguagesService languagesService;
	private RacksService racksService;
	private ProfilesService profilesService;

	@Autowired
	public void setBooksService(BooksService booksService) {
		this.booksService = booksService;
	}

	@Autowired
	public void setAuthorsService(AuthorsService authorsService) {
		this.authorsService = authorsService;
	}

	@Autowired
	public void setLanguagesService(LanguagesService languagesService) {
		this.languagesService = languagesService;
	}

	@Autowired
	public void setRacksService(RacksService racksService) {
		this.racksService = racksService;
	}

	@Autowired
	public void setProfilesService(ProfilesService profilesService) {
		this.profilesService = profilesService;
	}

	@Autowired
	@Qualifier(value = "bookDetailJpa")
	public void setBookDtlDao(BookDetailsDao bookDtlDao) {
		this.bookDtlDao = bookDtlDao;
	}

	@Override
	public List<BookDetails> getListBookDetails() throws Exception {
		return bookDtlDao.getListBookDetails();
	}

	@Override
	public BookDetails findByCode(String code) throws Exception {
		return bookDtlDao.findByCode(code);
	}

	@Override
	public BookDetails insertBookDetails(BookDetails bookDtl) throws Exception {
		Books bk = booksService.findByCode(bookDtl.getBookId().getBookCode());
		Authors aut = authorsService.findByCode(bookDtl.getAuthorId().getAuthorCode());
		Languages lang = languagesService.findByCode(bookDtl.getLanguageId().getLangCode());
		Racks rck = racksService.findByCode(bookDtl.getRackId().getRackCode());
		Profiles pro = profilesService.findByCode(bookDtl.getProfileId().getProfileCode());
		bookDtl.setBookId(bk);
		bookDtl.setAuthorId(aut);
		bookDtl.setLanguageId(lang);
		bookDtl.setRackId(rck);
		bookDtl.setProfileId(pro);
		BookDetails bd = bookDtlDao.insertBookDetails(bookDtl);
		return bd;
	}

	@Override
	public void deleteById(Long id) throws Exception {
		bookDtlDao.deleteById(id);
	}

	@Override
	public void updateBookDetail(BookDetails bookDtl) throws Exception {
		bookDtlDao.updateBookDetail(bookDtl);
	}

	@Override
	public List<BookDetails> findByBookCode(String bookCode) throws Exception {
		return bookDtlDao.findByBookCode(bookCode);
	}

}
