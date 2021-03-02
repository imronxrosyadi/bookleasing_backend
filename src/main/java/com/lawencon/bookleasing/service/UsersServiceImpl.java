package com.lawencon.bookleasing.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lawencon.bookleasing.dao.UsersDao;
import com.lawencon.bookleasing.model.Roles;
import com.lawencon.bookleasing.model.Users;

/**
 * @author Imron Rosyadi
 */

@Service
@Transactional
public class UsersServiceImpl extends BaseService implements UsersService {

	private UsersDao usersDao;
	private RolesService rolesService;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Autowired
	@Qualifier(value = "userJpa")
	public void setUsersDao(UsersDao usersDao) {
		this.usersDao = usersDao;
	}

	@Autowired
	public void setRolesService(RolesService rolesService) {
		this.rolesService = rolesService;
	}

	@Override
	public List<Users> getListUsers() throws Exception {
		return usersDao.getListUsers();
	}

	@Override
	public Users findByCode(String code) throws Exception {
		return usersDao.findByCode(code);
	}

	@Override
	public Users insertUsers(Users user) throws Exception {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		Roles role = rolesService.findByCode(user.getRoleId().getRoleCode());
		user.setRoleId(role);
		Users usr = usersDao.insertUsers(user);
		return usr;
	}

	@Override
	public void deleteById(Long id) throws Exception {
		usersDao.deleteById(id);
	}

	@Override
	public void updateUser(Users user) throws Exception {
		usersDao.updateUser(user);
	}

}
