package com.lawencon.bookleasing.service;

import com.lawencon.bookleasing.model.Genders;

/**
 * @author Imron Rosyadi
 */

public interface GendersService {

	Genders findByCode(String code) throws Exception;

}
