package com.lawencon.bookleasing.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lawencon.bookleasing.dao.BooksDao;
import com.lawencon.bookleasing.model.Books;
import com.lawencon.bookleasing.model.Categories;
import com.lawencon.bookleasing.model.Profiles;
import com.lawencon.bookleasing.model.Publishers;

/**
 * @author Imron Rosyadi
 */

@Service
@Transactional
public class BooksServiceImpl extends BaseService implements BooksService {

	private BooksDao booksDao;
	private ProfilesService profilesService;
	private PublishersService publishersService;
	private CategoriesService categoriesService;

	@Autowired
	public void setPublishersService(PublishersService publishersService) {
		this.publishersService = publishersService;
	}

	@Autowired
	public void setCategoriesService(CategoriesService categoriesService) {
		this.categoriesService = categoriesService;
	}

	@Autowired
	public void setProfilesService(ProfilesService profilesService) {
		this.profilesService = profilesService;
	}

	@Autowired
	@Qualifier(value = "bookJpa")
	public void setBooksDao(BooksDao booksDao) {
		this.booksDao = booksDao;
	}

	@Override
	public List<Books> getListBooks() throws Exception {
		return booksDao.getListBooks();
	}

	@Override
	public Books findByCode(String code) throws Exception {
		return booksDao.findByCode(code);
	}

	@Override
	public Books insertBook(Books book) throws Exception {
		Categories cat = categoriesService.findByCode(book.getBookCategory().getCategoryCode());
		Publishers pub = publishersService.findByCode(book.getBookPublisher().getPublisherCode());
		Profiles pro = profilesService.findByCode(book.getProfileId().getProfileCode());
		book.setBookCategory(cat);
		book.setBookPublisher(pub);
		book.setProfileId(pro);
		Books bk = booksDao.insertBook(book);
		return bk;
	}

	@Override
	public void deleteById(Long id) throws Exception {
		booksDao.deleteById(id);
	}

	@Override
	public void updateBook(Books book) throws Exception {
		booksDao.updateBook(book);
	}

}
