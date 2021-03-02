package com.lawencon.bookleasing.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lawencon.bookleasing.model.Payments;

/**
 * @author Imron Rosyadi
 */

@Repository
public interface PaymentsRepo extends JpaRepository<Payments, Long> {

	Payments findByPayCode(String payCode) throws Exception;

}
