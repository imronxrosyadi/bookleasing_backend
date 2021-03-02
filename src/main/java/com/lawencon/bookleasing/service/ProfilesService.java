package com.lawencon.bookleasing.service;

import java.util.List;

import com.lawencon.bookleasing.model.Profiles;

/**
 * @author Imron Rosyadi
 */

public interface ProfilesService {

	Profiles loginProfile(Profiles profile) throws Exception;

	Profiles insertProfile(Profiles profile) throws Exception;

	List<Profiles> getListProfiles() throws Exception;

	Profiles findByCode(String proCode) throws Exception;

	void deleteById(Long id) throws Exception;

	void updateProfile(Profiles pro) throws Exception;

	Profiles findByUserId(Long userId) throws Exception;

}
