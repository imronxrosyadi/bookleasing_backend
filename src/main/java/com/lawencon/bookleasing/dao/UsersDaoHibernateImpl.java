package com.lawencon.bookleasing.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lawencon.bookleasing.model.Users;

/**
 * @author Imron Rosyadi
 */

@Repository
public class UsersDaoHibernateImpl extends BaseDao implements UsersDao {

	@Override
	public List<Users> getListUsers() throws Exception {

		List<Users> listResult = em.createQuery("from Users", Users.class).getResultList();

		return listResult;
	}

	@Override
	public Users findByCode(String code) throws Exception {
		List<Users> listResult = em.createQuery("from Users where username = ?1 ", Users.class).setParameter(1, code)
				.getResultList();

		return listResult.size() > 0 ? listResult.get(0) : null;
	}

	@Override
	public Users insertUsers(Users user) throws Exception {
		em.persist(user);
		return user;
	}

	@Override
	public void deleteById(Long id) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateUser(Users user) throws Exception {
		// TODO Auto-generated method stub

	}

}
