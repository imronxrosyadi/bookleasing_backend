package com.lawencon.bookleasing.dao;

import java.util.List;

import com.lawencon.bookleasing.model.Publishers;

/**
 * @author Imron Rosyadi
 */

public interface PublishersDao {

	Publishers insertPublisher(Publishers pub) throws Exception;

	List<Publishers> getListPublishers() throws Exception;

	Publishers findByCode(String code) throws Exception;

	void deleteById(Long id) throws Exception;

	void updatePublisher(Publishers pub) throws Exception;

}
