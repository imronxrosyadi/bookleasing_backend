package com.lawencon.bookleasing.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lawencon.bookleasing.dao.ProfilesDao;
import com.lawencon.bookleasing.model.Genders;
import com.lawencon.bookleasing.model.ProfileSession;
import com.lawencon.bookleasing.model.Profiles;
import com.lawencon.bookleasing.model.Users;

/**
 * @author Imron Rosyadi
 */

@Service
@Transactional
public class ProfilesServiceImpl extends BaseService implements ProfilesService {

	private ProfilesDao profilesDao;
	private ProfileSession profileSession;
	private UsersService usersService;
	private GendersService gendersService;

	@Autowired
	public void setGendersService(GendersService gendersService) {
		this.gendersService = gendersService;
	}

	@Autowired
	public void setUsersService(UsersService usersService) {
		this.usersService = usersService;
	}

	@Autowired
	@Qualifier(value = "profileJpa")
	public void setProfilesDao(ProfilesDao profilesDao) {
		this.profilesDao = profilesDao;
	}

	@Autowired
	public void setProfileSession(ProfileSession profileSession) {
		this.profileSession = profileSession;
	}

	@Override
	public List<Profiles> getListProfiles() throws Exception {
		return profilesDao.getListProfiles();
	}

	@Override
	public Profiles findByCode(String proCode) throws Exception {
		return profilesDao.findByCode(proCode);
	}

	@Override
	public Profiles insertProfile(Profiles profile) throws Exception {
		Users user = usersService.findByCode(profile.getUserId().getUsername());
		Genders gender = gendersService.findByCode(profile.getGenderId().getGenderCode());
		profile.setUserId(user);
		profile.setGenderId(gender);
		Profiles pf = profilesDao.insertProfile(profile);
		return pf;
	}

	@Override
	public Profiles loginProfile(Profiles profile) throws Exception {
		Profiles pro = profilesDao.loginProfile(profile);
		profileSession.setActiveProfile(pro);
		return profileSession.getActiveProfile();
	}

	@Override
	public void deleteById(Long id) throws Exception {
		profilesDao.deleteById(id);
	}

	@Override
	public void updateProfile(Profiles pro) throws Exception {
		profilesDao.updateProfile(pro);
	}

	@Override
	public Profiles findByUserId(Long userId) throws Exception {
		return profilesDao.findByUserId(userId);
	}

}
