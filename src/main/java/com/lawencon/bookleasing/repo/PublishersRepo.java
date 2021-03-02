package com.lawencon.bookleasing.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lawencon.bookleasing.model.Publishers;

/**
 * @author Imron Rosyadi
 */

@Repository
public interface PublishersRepo extends JpaRepository<Publishers, Long> {
	Publishers findByPublisherCode(String publisherCode) throws Exception;
}
