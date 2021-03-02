package com.lawencon.bookleasing.service;

import java.util.List;

import com.lawencon.bookleasing.model.Users;

/**
 * @author Imron Rosyadi
 */

public interface UsersService {

	Users insertUsers(Users user) throws Exception;

	List<Users> getListUsers() throws Exception;

	Users findByCode(String code) throws Exception;

	void deleteById(Long id) throws Exception;

	void updateUser(Users user) throws Exception;

}
