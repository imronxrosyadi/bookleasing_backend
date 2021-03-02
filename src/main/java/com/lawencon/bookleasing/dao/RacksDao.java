package com.lawencon.bookleasing.dao;

import java.util.List;

import com.lawencon.bookleasing.model.Racks;

/**
 * @author Imron Rosyadi
 */

public interface RacksDao {

	Racks insertRack(Racks rack) throws Exception;

	List<Racks> getListRacks() throws Exception;

	Racks findByCode(String code) throws Exception;

	void deleteById(Long id) throws Exception;

	void updateRack(Racks rack) throws Exception;

}
