package com.lawencon.bookleasing.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lawencon.bookleasing.dao.AuthorsDao;
import com.lawencon.bookleasing.model.Authors;
import com.lawencon.bookleasing.model.Profiles;

/**
 * @author Imron Rosyadi
 */

@Service
@Transactional
public class AuthorsServiceImpl extends BaseService implements AuthorsService {

	private AuthorsDao authorsDao;
	private ProfilesService profilesService;

	@Autowired
	public void setProfilesService(ProfilesService profilesService) {
		this.profilesService = profilesService;
	}

	@Autowired
	@Qualifier(value = "authorJpa")
	public void setAuthorsDao(AuthorsDao authorsDao) {
		this.authorsDao = authorsDao;
	}

	@Override
	public Authors insertAuthor(Authors aut) throws Exception {
		Profiles pro = profilesService.findByCode(aut.getProfileId().getProfileCode());
		aut.setProfileId(pro);
		System.out.println(pro.getId());
		Authors author = authorsDao.insertAuthor(aut);
		return author;
	}

	@Override
	public List<Authors> getListAuthors() throws Exception {
		return authorsDao.getListAuthors();
	}

	@Override
	public Authors findByCode(String code) throws Exception {
		return authorsDao.findByCode(code);
	}

	@Override
	public void deleteById(Long id) throws Exception {
		authorsDao.deleteById(id);
	}

	@Override
	public void updateAuthor(Authors aut) throws Exception {
		authorsDao.updateAuthor(aut);
	}

}
