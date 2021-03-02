package com.lawencon.bookleasing.dao;

import com.lawencon.bookleasing.model.Genders;

/**
 * @author Imron Rosyadi
 */

public interface GendersDao {

	Genders findByCode(String code) throws Exception;

}
