package com.lawencon.bookleasing.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lawencon.bookleasing.dao.LanguagesDao;
import com.lawencon.bookleasing.model.Languages;
import com.lawencon.bookleasing.model.Profiles;

/**
 * @author Imron Rosyadi
 */

@Service
@Transactional
public class LanguagesServiceImpl extends BaseService implements LanguagesService {

	private LanguagesDao langDao;
	private ProfilesService profilesService;

	@Autowired
	public void setProfilesService(ProfilesService profilesService) {
		this.profilesService = profilesService;
	}

	@Autowired
	@Qualifier(value = "langJpa")
	public void setLangDao(LanguagesDao langDao) {
		this.langDao = langDao;
	}

	@Override
	public Languages insertLanguage(Languages lang) throws Exception {
		Profiles pro = profilesService.findByCode(lang.getProfileId().getProfileCode());
		lang.setProfileId(pro);
		Languages languages = langDao.insertLanguage(lang);
		return languages;
	}

	@Override
	public List<Languages> getListLanguages() throws Exception {
		return langDao.getListLanguages();
	}

	@Override
	public Languages findByCode(String code) throws Exception {
		return langDao.findByCode(code);
	}

	@Override
	public void deleteById(Long id) throws Exception {
		langDao.deleteById(id);
	}

	@Override
	public void updateLanguage(Languages lang) throws Exception {
		langDao.updateLanguage(lang);
	}

}
