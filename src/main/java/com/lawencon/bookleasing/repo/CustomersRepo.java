package com.lawencon.bookleasing.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lawencon.bookleasing.model.Customers;

/**
 * @author Imron Rosyadi
 */

@Repository
public interface CustomersRepo extends JpaRepository<Customers, Long> {

	Customers findByCustCode(String custCode) throws Exception;

}
