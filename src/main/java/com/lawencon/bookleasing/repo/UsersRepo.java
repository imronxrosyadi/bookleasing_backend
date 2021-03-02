package com.lawencon.bookleasing.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lawencon.bookleasing.model.Users;

/**
 * @author Imron Rosyadi
 */

@Repository
public interface UsersRepo extends JpaRepository<Users, Long> {

	Users findByUsername(String username) throws Exception;

}
