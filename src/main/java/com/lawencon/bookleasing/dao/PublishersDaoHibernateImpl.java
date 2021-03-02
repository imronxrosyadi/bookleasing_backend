package com.lawencon.bookleasing.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lawencon.bookleasing.model.Publishers;

/**
 * @author Imron Rosyadi
 */

@Repository
public class PublishersDaoHibernateImpl extends BaseDao implements PublishersDao {

	@Override
	public Publishers insertPublisher(Publishers pub) throws Exception {
		em.persist(pub);

		return pub;
	}

	@Override
	public List<Publishers> getListPublishers() throws Exception {
		List<Publishers> listResult = em.createQuery("from Publishers", Publishers.class).getResultList();

		return listResult;

	}

	@Override
	public Publishers findByCode(String code) throws Exception {
		List<Publishers> listResult = em.createQuery("from Publishers where publisherCode = ?1 ", Publishers.class)
				.setParameter(1, code).getResultList();

		return listResult.size() > 0 ? listResult.get(0) : null;
	}

	@Override
	public void deleteById(Long id) throws Exception {

	}

	@Override
	public void updatePublisher(Publishers pub) throws Exception {

	}

}
