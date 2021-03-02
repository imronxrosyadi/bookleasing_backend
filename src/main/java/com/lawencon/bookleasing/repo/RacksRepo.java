package com.lawencon.bookleasing.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lawencon.bookleasing.model.Racks;

/**
 * @author Imron Rosyadi
 */

@Repository
public interface RacksRepo extends JpaRepository<Racks, Long> {

	Racks findByRackCode(String rackCode) throws Exception;

}
