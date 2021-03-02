package com.lawencon.bookleasing.dao;

import java.util.List;

import com.lawencon.bookleasing.model.Authors;

/**
 * @author Imron Rosyadi
 */

public interface AuthorsDao {

	Authors insertAuthor(Authors aut) throws Exception;

	List<Authors> getListAuthors() throws Exception;

	Authors findByCode(String code) throws Exception;

	void deleteById(Long id) throws Exception;

	void updateAuthor(Authors aut) throws Exception;

}
