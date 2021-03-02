package com.lawencon.bookleasing.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lawencon.bookleasing.model.Users;
import com.lawencon.bookleasing.repo.UsersRepo;

/**
 * @author Imron Rosyadi
 */

@Repository(value = "userJpa")
public class UsersDaoJpaImpl extends BaseDao implements UsersDao {

	@Autowired
	private UsersRepo usersRepo;

	@Override
	public List<Users> getListUsers() throws Exception {
		return usersRepo.findAll();
	}

	@Override
	public Users findByCode(String code) throws Exception {
		return usersRepo.findByUsername(code);
	}

	@Override
	public Users insertUsers(Users user) throws Exception {
		return usersRepo.save(user);
	}

	@Override
	public void deleteById(Long id) throws Exception {
		usersRepo.deleteById(id);
	}

	@Override
	public void updateUser(Users user) throws Exception {
		usersRepo.save(user);
	}

}
