package com.lawencon.bookleasing.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lawencon.bookleasing.model.Roles;

/**
 * @author Imron Rosyadi
 */

@Repository
public class RolesDaoHibernateImpl extends BaseDao implements RolesDao {

	@Override
	public List<Roles> getListRoles() throws Exception {

		List<Roles> listResult = em.createQuery("from Roles", Roles.class).getResultList();

		return listResult;
	}

	@Override
	public Roles findByCode(String code) throws Exception {
		List<Roles> listResult = em.createQuery("from Roles where roleCode = ?1 ", Roles.class).setParameter(1, code)
				.getResultList();

		return listResult.size() > 0 ? listResult.get(0) : null;
	}

	@Override
	public Roles insertRole(Roles role) throws Exception {

		em.persist(role);

		return role;

	}

}
