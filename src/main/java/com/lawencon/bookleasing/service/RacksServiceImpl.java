package com.lawencon.bookleasing.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lawencon.bookleasing.dao.RacksDao;
import com.lawencon.bookleasing.model.Profiles;
import com.lawencon.bookleasing.model.Racks;

/**
 * @author Imron Rosyadi
 */

@Service
@Transactional
public class RacksServiceImpl extends BaseService implements RacksService {

	private RacksDao racksDao;
	private ProfilesService profilesService;

	@Autowired
	public void setProfilesService(ProfilesService profilesService) {
		this.profilesService = profilesService;
	}

	@Autowired
	@Qualifier(value = "rackJpa")
	public void setRacksDao(RacksDao racksDao) {
		this.racksDao = racksDao;
	}

	@Override
	public Racks insertRack(Racks rack) throws Exception {
		Profiles pro = profilesService.findByCode(rack.getProfileId().getProfileCode());
		rack.setProfileId(pro);
		Racks rck = racksDao.insertRack(rack);
		return rck;
	}

	@Override
	public List<Racks> getListRacks() throws Exception {
		return racksDao.getListRacks();

	}

	@Override
	public Racks findByCode(String code) throws Exception {
		return racksDao.findByCode(code);
	}

	@Override
	public void deleteById(Long id) throws Exception {
		racksDao.deleteById(id);
	}

	@Override
	public void updateRack(Racks rack) throws Exception {
		racksDao.updateRack(rack);
	}

}
