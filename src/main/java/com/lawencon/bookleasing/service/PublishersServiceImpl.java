package com.lawencon.bookleasing.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lawencon.bookleasing.dao.PublishersDao;
import com.lawencon.bookleasing.model.Profiles;
import com.lawencon.bookleasing.model.Publishers;

/**
 * @author Imron Rosyadi
 */

@Service
@Transactional
public class PublishersServiceImpl extends BaseService implements PublishersService {

	private PublishersDao publishersDao;
	private ProfilesService profilesService;

	@Autowired
	public void setProfilesService(ProfilesService profilesService) {
		this.profilesService = profilesService;
	}

	@Autowired
	@Qualifier(value = "publisherJpa")
	public void setPublishersDao(PublishersDao publishersDao) {
		this.publishersDao = publishersDao;
	}

	@Override
	public Publishers insertPublisher(Publishers pub) throws Exception {
		Profiles pro = profilesService.findByCode(pub.getProfileId().getProfileCode());
		pub.setProfileId(pro);
		Publishers publisher = publishersDao.insertPublisher(pub);
		return publisher;
	}

	@Override
	public List<Publishers> getListPublishers() throws Exception {
		return publishersDao.getListPublishers();
	}

	@Override
	public Publishers findByCode(String code) throws Exception {
		return publishersDao.findByCode(code);
	}

	@Override
	public void deleteById(Long id) throws Exception {
		publishersDao.deleteById(id);
	}

	@Override
	public void updatePublisher(Publishers pub) throws Exception {
		publishersDao.updatePublisher(pub);
	}

}
