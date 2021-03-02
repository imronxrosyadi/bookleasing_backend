package com.lawencon.bookleasing.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lawencon.bookleasing.model.Languages;

/**
 * @author Imron Rosyadi
 */

@Repository
public interface LanguagesRepo extends JpaRepository<Languages, Long> {

	Languages findByLangCode(String langCode) throws Exception;

}
