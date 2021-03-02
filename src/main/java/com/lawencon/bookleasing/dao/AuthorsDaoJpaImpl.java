package com.lawencon.bookleasing.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lawencon.bookleasing.model.Authors;
import com.lawencon.bookleasing.repo.AuthorsRepo;

/**
 * @author Imron Rosyadi
 */

@Repository(value = "authorJpa")
public class AuthorsDaoJpaImpl extends BaseDao implements AuthorsDao {

	@Autowired
	private AuthorsRepo authorsRepo;

	@Override
	public Authors insertAuthor(Authors aut) throws Exception {
		return authorsRepo.save(aut);
	}

	@Override
	public List<Authors> getListAuthors() throws Exception {
		return authorsRepo.findAll();
	}

	@Override
	public Authors findByCode(String code) throws Exception {
		return authorsRepo.findByAuthorCode(code);
	}

	@Override
	public void deleteById(Long id) throws Exception {
		authorsRepo.deleteById(id);
	}

	@Override
	public void updateAuthor(Authors aut) throws Exception {
		authorsRepo.save(aut);
	}

}
