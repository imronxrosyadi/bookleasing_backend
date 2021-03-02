package com.lawencon.bookleasing.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lawencon.bookleasing.model.Languages;

/**
 * @author Imron Rosyadi
 */

@Repository
public class LanguagesDaoHibernateImpl extends BaseDao implements LanguagesDao {

	@Override
	public Languages insertLanguage(Languages lang) throws Exception {

		em.persist(lang);

		return lang;
	}

	@Override
	public List<Languages> getListLanguages() throws Exception {
		List<Languages> listResult = em.createQuery("from Languages", Languages.class).getResultList();

		return listResult;
	}

	@Override
	public Languages findByCode(String code) throws Exception {
		List<Languages> listResult = em.createQuery("from Languages where langCode = ?1 ", Languages.class)
				.setParameter(1, code).getResultList();

		return listResult.size() > 0 ? listResult.get(0) : null;
	}

	@Override
	public void deleteById(Long id) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateLanguage(Languages lang) throws Exception {
		// TODO Auto-generated method stub

	}

}
