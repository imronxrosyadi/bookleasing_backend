package com.lawencon.bookleasing.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lawencon.bookleasing.model.Categories;
import com.lawencon.bookleasing.repo.CategoriesRepo;

/**
 * @author Imron Rosyadi
 */

@Repository(value = "categoryJpa")
public class CategoriesDaoJpaImpl extends BaseDao implements CategoriesDao {

	@Autowired
	private CategoriesRepo categoriesRepo;

	@Override
	public Categories insertCategorie(Categories cat) throws Exception {
		return categoriesRepo.save(cat);
	}

	@Override
	public List<Categories> getListCategories() throws Exception {
		return categoriesRepo.findAll();
	}

	@Override
	public Categories findByCode(String code) throws Exception {
		return categoriesRepo.findByCategoryCode(code);
	}

	@Override
	public void deleteById(Long id) throws Exception {
		categoriesRepo.deleteById(id);
	}

	@Override
	public void updateCategory(Categories cat) throws Exception {
		categoriesRepo.save(cat);
	}

}
