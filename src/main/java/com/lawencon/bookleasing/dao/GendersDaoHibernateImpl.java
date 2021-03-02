package com.lawencon.bookleasing.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lawencon.bookleasing.model.Genders;

/**
 * @author Imron Rosyadi
 */

@Repository
public class GendersDaoHibernateImpl extends BaseDao implements GendersDao {

	@Override
	public Genders findByCode(String code) throws Exception {
		List<Genders> listResult = em.createQuery("from Genders where genderCode = ?1 ", Genders.class)
				.setParameter(1, code).getResultList();

		return listResult.size() > 0 ? listResult.get(0) : null;
	}

}
