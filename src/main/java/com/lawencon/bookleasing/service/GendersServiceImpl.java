package com.lawencon.bookleasing.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lawencon.bookleasing.dao.GendersDao;
import com.lawencon.bookleasing.model.Genders;

/**
 * @author Imron Rosyadi
 */

@Service
@Transactional
public class GendersServiceImpl extends BaseService implements GendersService {

	GendersDao gendersDao;

	@Autowired
	public void setGendersDao(GendersDao gendersDao) {
		this.gendersDao = gendersDao;
	}

	@Override
	public Genders findByCode(String code) throws Exception {
		return gendersDao.findByCode(code);
	}

}
