package com.lawencon.bookleasing.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lawencon.bookleasing.model.Roles;
import com.lawencon.bookleasing.repo.RolesRepo;

/**
 * @author Imron Rosyadi
 */

@Repository(value = "roleJpa")
public class RolesDaoJpaImpl extends BaseDao implements RolesDao {

	@Autowired
	private RolesRepo rolesRepo;

	@Override
	public List<Roles> getListRoles() throws Exception {
		return rolesRepo.findAll();
	}

	@Override
	public Roles findByCode(String code) throws Exception {
		return rolesRepo.findByRoleCode(code);
	}

	@Override
	public Roles insertRole(Roles role) throws Exception {
		return rolesRepo.save(role);
	}

}
