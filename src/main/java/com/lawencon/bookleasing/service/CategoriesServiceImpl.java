package com.lawencon.bookleasing.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lawencon.bookleasing.dao.CategoriesDao;
import com.lawencon.bookleasing.model.Categories;
import com.lawencon.bookleasing.model.Profiles;

/**
 * @author Imron Rosyadi
 */

@Service
@Transactional
public class CategoriesServiceImpl extends BaseService implements CategoriesService {

	private CategoriesDao catDao;
	private ProfilesService profilesService;

	@Autowired
	public void setProfilesService(ProfilesService profilesService) {
		this.profilesService = profilesService;
	}

	@Autowired
	@Qualifier(value = "categoryJpa")
	public void setCatDao(CategoriesDao catDao) {
		this.catDao = catDao;
	}

	@Override
	public Categories insertCategorie(Categories cat) throws Exception {
		Profiles pro = profilesService.findByCode(cat.getProfileId().getProfileCode());
		cat.setProfileId(pro);
		Categories category = catDao.insertCategorie(cat);
		return category;
	}

	@Override
	public List<Categories> getListCategories() throws Exception {
		return catDao.getListCategories();
	}

	@Override
	public Categories findByCode(String code) throws Exception {
		return catDao.findByCode(code);
	}

	@Override
	public void deleteById(Long id) throws Exception {
		catDao.deleteById(id);
	}

	@Override
	public void updateCategory(Categories cat) throws Exception {
		catDao.updateCategory(cat);
	}

}
