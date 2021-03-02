package com.lawencon.bookleasing.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lawencon.bookleasing.model.Languages;
import com.lawencon.bookleasing.repo.LanguagesRepo;

/**
 * @author Imron Rosyadi
 */

@Repository(value = "langJpa")
public class LanguagesDaoJpaImpl extends BaseDao implements LanguagesDao {

	@Autowired
	private LanguagesRepo languagesRepo;

	@Override
	public Languages insertLanguage(Languages lang) throws Exception {
		return languagesRepo.save(lang);
	}

	@Override
	public List<Languages> getListLanguages() throws Exception {
		return languagesRepo.findAll();
	}

	@Override
	public Languages findByCode(String code) throws Exception {
		return languagesRepo.findByLangCode(code);
	}

	@Override
	public void deleteById(Long id) throws Exception {
		languagesRepo.deleteById(id);
	}

	@Override
	public void updateLanguage(Languages lang) throws Exception {
		languagesRepo.save(lang);
	}

}
