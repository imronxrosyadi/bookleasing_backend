package com.lawencon.bookleasing.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lawencon.bookleasing.model.Profiles;

/**
 * @author Imron Rosyadi
 */

@Repository
public interface ProfilesRepo extends JpaRepository<Profiles, Long> {

	Profiles findByProfileCode(String profileCode) throws Exception;

	Profiles findByUserIdId(Long userId) throws Exception;

}
