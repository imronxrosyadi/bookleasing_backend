package com.lawencon.bookleasing.dao;

import java.util.List;

import com.lawencon.bookleasing.model.Users;

/**
 * @author Imron Rosyadi
 */

public interface UsersDao {

	Users insertUsers(Users user) throws Exception;

	List<Users> getListUsers() throws Exception;

	Users findByCode(String code) throws Exception;

	void deleteById(Long id) throws Exception;

	void updateUser(Users user) throws Exception;

}
