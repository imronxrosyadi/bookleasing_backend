package com.lawencon.bookleasing.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lawencon.bookleasing.model.Profiles;
import com.lawencon.bookleasing.repo.ProfilesRepo;

/**
 * @author Imron Rosyadi
 */

@Repository(value = "profileJpa")
public class ProfilesDaoJpaImpl extends BaseDao implements ProfilesDao {

	@Autowired
	private ProfilesRepo profilesRepo;

	@Override
	public List<Profiles> getListProfiles() throws Exception {
		return profilesRepo.findAll();
	}

	@Override
	public Profiles findByCode(String proCode) throws Exception {
		return profilesRepo.findByProfileCode(proCode);
	}

	@Override
	public Profiles findByUserId(Long userId) throws Exception {
		return profilesRepo.findByUserIdId(userId);
	}

	@Override
	public Profiles insertProfile(Profiles profile) throws Exception {
		return profilesRepo.save(profile);
	}

	@Override
	public Profiles loginProfile(Profiles profile) throws Exception {
		String sql = "FROM Profiles as p WHERE p.userId.username = ?1 and p.userId.password = ?2 ";
		List<Profiles> listResult = em.createQuery(sql, Profiles.class)
				.setParameter(1, profile.getUserId().getUsername()).setParameter(2, profile.getUserId().getPassword())
				.getResultList();

		return listResult.size() > 0 ? listResult.get(0) : null;
	}

	@Override
	public void deleteById(Long id) throws Exception {
		profilesRepo.deleteById(id);
	}

	@Override
	public void updateProfile(Profiles pro) throws Exception {
		profilesRepo.save(pro);
	}
}
