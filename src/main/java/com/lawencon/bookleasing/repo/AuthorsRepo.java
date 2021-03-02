package com.lawencon.bookleasing.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lawencon.bookleasing.model.Authors;

/**
 * @author Imron Rosyadi
 */

@Repository
public interface AuthorsRepo extends JpaRepository<Authors, Long> {

	Authors findByAuthorCode(String authorCode) throws Exception;

}
