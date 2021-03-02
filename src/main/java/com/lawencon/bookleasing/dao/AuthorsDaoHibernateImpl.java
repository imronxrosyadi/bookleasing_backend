package com.lawencon.bookleasing.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lawencon.bookleasing.model.Authors;

/**
 * @author Imron Rosyadi
 */

@Repository
public class AuthorsDaoHibernateImpl extends BaseDao implements AuthorsDao {

	@Override
	public Authors insertAuthor(Authors aut) throws Exception {
		em.persist(aut);

		return aut;
	}

	@Override
	public List<Authors> getListAuthors() throws Exception {

		List<Authors> listResult = em.createQuery("from Authors", Authors.class).getResultList();

		return listResult;
	}

	@Override
	public Authors findByCode(String code) throws Exception {
		List<Authors> listResult = em.createQuery("from Authors where authorCode = ?1 ", Authors.class)
				.setParameter(1, code).getResultList();

		return listResult.size() > 0 ? listResult.get(0) : null;
	}

	@Override
	public void deleteById(Long id) throws Exception {

	}

	@Override
	public void updateAuthor(Authors aut) throws Exception {

	}

}
