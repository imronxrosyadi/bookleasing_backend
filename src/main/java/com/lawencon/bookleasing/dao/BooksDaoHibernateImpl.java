package com.lawencon.bookleasing.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lawencon.bookleasing.model.Books;

/**
 * @author Imron Rosyadi
 */

@Repository
public class BooksDaoHibernateImpl extends BaseDao implements BooksDao {

	@Override
	public List<Books> getListBooks() throws Exception {
		List<Books> listResult = em.createQuery("from Books", Books.class).getResultList();

		return listResult;
	}

	@Override
	public Books findByCode(String code) throws Exception {
		List<Books> listResult = em.createQuery("from Books where bookCode = ?1 ", Books.class).setParameter(1, code)
				.getResultList();

		return listResult.size() > 0 ? listResult.get(0) : null;
	}

	@Override
	public Books insertBook(Books book) throws Exception {
		em.persist(book);

		return book;
	}

	@Override
	public void deleteById(Long id) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateBook(Books book) throws Exception {
		// TODO Auto-generated method stub

	}

}
