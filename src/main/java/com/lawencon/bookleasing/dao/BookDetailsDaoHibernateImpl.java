package com.lawencon.bookleasing.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lawencon.bookleasing.model.BookDetails;

/**
 * @author Imron Rosyadi
 */

@Repository
public class BookDetailsDaoHibernateImpl extends BaseDao implements BookDetailsDao {

	@Override
	public List<BookDetails> getListBookDetails() throws Exception {

		List<BookDetails> listResult = em.createQuery("from BookDetails", BookDetails.class).getResultList();

		return listResult;
	}

	@Override
	public BookDetails findByCode(String code) throws Exception {
		List<BookDetails> listResult = em.createQuery("from BookDetails where bookDtlCode = ?1 ", BookDetails.class)
				.setParameter(1, code).getResultList();

		return listResult.size() > 0 ? listResult.get(0) : null;
	}

	@Override
	public BookDetails insertBookDetails(BookDetails bookDtl) throws Exception {
		em.persist(bookDtl);

		return bookDtl;
	}

	@Override
	public void deleteById(Long id) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateBookDetail(BookDetails bookDtl) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public List<BookDetails> findByBookCode(String bookCode) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
