package com.lawencon.bookleasing.dao;

import java.util.List;

import com.lawencon.bookleasing.model.Roles;

/**
 * @author Imron Rosyadi
 */

public interface RolesDao {

	Roles insertRole(Roles role) throws Exception;

	List<Roles> getListRoles() throws Exception;

	Roles findByCode(String code) throws Exception;
}
