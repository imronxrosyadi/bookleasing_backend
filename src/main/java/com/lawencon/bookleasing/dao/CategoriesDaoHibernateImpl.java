package com.lawencon.bookleasing.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lawencon.bookleasing.model.Categories;

/**
 * @author Imron Rosyadi
 */

@Repository
public class CategoriesDaoHibernateImpl extends BaseDao implements CategoriesDao {

	@Override
	public Categories insertCategorie(Categories cat) throws Exception {
		em.persist(cat);

		return cat;
	}

	@Override
	public List<Categories> getListCategories() throws Exception {
		List<Categories> listResult = em.createQuery("from Categories", Categories.class).getResultList();

		return listResult;
	}

	@Override
	public Categories findByCode(String code) throws Exception {
		List<Categories> listResult = em.createQuery("from Categories where categoryCode = ?1 ", Categories.class)
				.setParameter(1, code).getResultList();

		return listResult.size() > 0 ? listResult.get(0) : null;
	}

	@Override
	public void deleteById(Long id) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateCategory(Categories cat) throws Exception {
		// TODO Auto-generated method stub

	}

}
