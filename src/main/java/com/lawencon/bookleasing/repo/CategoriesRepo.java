package com.lawencon.bookleasing.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lawencon.bookleasing.model.Categories;

/**
 * @author Imron Rosyadi
 */

@Repository
public interface CategoriesRepo extends JpaRepository<Categories, Long> {

	Categories findByCategoryCode(String categoryCode) throws Exception;

}
