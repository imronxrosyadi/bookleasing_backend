package com.lawencon.bookleasing.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lawencon.bookleasing.dao.RolesDao;
import com.lawencon.bookleasing.model.Roles;

/**
 * @author Imron Rosyadi
 */

@Service
@Transactional
public class RolesServiceImpl extends BaseService implements RolesService {

	private RolesDao rolesDao;

	@Autowired
	@Qualifier(value = "roleJpa")
	public void setRolesDao(RolesDao rolesDao) {
		this.rolesDao = rolesDao;
	}

	@Override
	public List<Roles> getListRoles() throws Exception {
		return rolesDao.getListRoles();
	}

	@Override
	public Roles insertRole(Roles role) throws Exception {
		return rolesDao.insertRole(role);
	}

	@Override
	public Roles findByCode(String code) throws Exception {
		return rolesDao.findByCode(code);
	}
}
