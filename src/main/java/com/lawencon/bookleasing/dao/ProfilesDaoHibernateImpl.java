package com.lawencon.bookleasing.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lawencon.bookleasing.model.Profiles;

/**
 * @author Imron Rosyadi
 */

@Repository
public class ProfilesDaoHibernateImpl extends BaseDao implements ProfilesDao {

	@Override
	public List<Profiles> getListProfiles() throws Exception {

		List<Profiles> listResult = em.createQuery("from Profiles", Profiles.class).getResultList();

		return listResult;
	}

	@Override
	public Profiles findByCode(String proCode) throws Exception {
		List<Profiles> listResult = em.createQuery("from Profiles where profileCode = ?1 ", Profiles.class)
				.setParameter(1, proCode).getResultList();

		return listResult.size() > 0 ? listResult.get(0) : null;
	}

	@Override
	public Profiles findByUserId(Long userId) throws Exception {
//		return profilesRepo.findByUserId(userId);
		return null;
	}

	@Override
	public Profiles insertProfile(Profiles profile) throws Exception {

		em.persist(profile);

		return profile;
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
		// TODO Auto-generated method stub

	}

	@Override
	public void updateProfile(Profiles pro) throws Exception {
		// TODO Auto-generated method stub

	}
}
