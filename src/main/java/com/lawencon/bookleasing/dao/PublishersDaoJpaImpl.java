package com.lawencon.bookleasing.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lawencon.bookleasing.model.Publishers;
import com.lawencon.bookleasing.repo.PublishersRepo;

/**
 * @author Imron Rosyadi
 */

@Repository(value = "publisherJpa")
public class PublishersDaoJpaImpl extends BaseDao implements PublishersDao {

	@Autowired
	private PublishersRepo publishersRepo;

	@Override
	public Publishers insertPublisher(Publishers pub) throws Exception {
		return publishersRepo.save(pub);
	}

	@Override
	public List<Publishers> getListPublishers() throws Exception {
		return publishersRepo.findAll();

	}

	@Override
	public Publishers findByCode(String code) throws Exception {
		return publishersRepo.findByPublisherCode(code);
	}

	@Override
	public void deleteById(Long id) throws Exception {
		publishersRepo.deleteById(id);
	}

	@Override
	public void updatePublisher(Publishers pub) throws Exception {
		publishersRepo.save(pub);
	}

}
