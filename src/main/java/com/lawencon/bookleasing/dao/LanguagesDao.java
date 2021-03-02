package com.lawencon.bookleasing.dao;

import java.util.List;

import com.lawencon.bookleasing.model.Languages;

/**
 * @author Imron Rosyadi
 */

public interface LanguagesDao {

	Languages insertLanguage(Languages lang) throws Exception;

	List<Languages> getListLanguages() throws Exception;

	Languages findByCode(String code) throws Exception;

	void deleteById(Long id) throws Exception;

	void updateLanguage(Languages lang) throws Exception;

}
