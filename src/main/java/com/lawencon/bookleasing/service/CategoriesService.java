package com.lawencon.bookleasing.service;

import java.util.List;

import com.lawencon.bookleasing.model.Categories;

/**
 * @author Imron Rosyadi
 */

public interface CategoriesService {

	Categories insertCategorie(Categories cat) throws Exception;

	List<Categories> getListCategories() throws Exception;

	Categories findByCode(String code) throws Exception;

	void deleteById(Long id) throws Exception;

	void updateCategory(Categories cat) throws Exception;
}
