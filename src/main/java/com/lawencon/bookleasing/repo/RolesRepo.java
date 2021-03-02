package com.lawencon.bookleasing.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lawencon.bookleasing.model.Roles;

/**
 * @author Imron Rosyadi
 */

@Repository
public interface RolesRepo extends JpaRepository<Roles, Long> {

	Roles findByRoleCode(String roleCode) throws Exception;

}
