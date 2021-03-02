package com.lawencon.bookleasing.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lawencon.bookleasing.model.Racks;
import com.lawencon.bookleasing.repo.RacksRepo;

/**
 * @author Imron Rosyadi
 */

@Repository(value = "rackJpa")
public class RacksDaoJpaImpl extends BaseDao implements RacksDao {

	@Autowired
	private RacksRepo racksRepo;

	@Override
	public Racks insertRack(Racks rack) throws Exception {
		return racksRepo.save(rack);
	}

	@Override
	public List<Racks> getListRacks() throws Exception {
		return racksRepo.findAll();
	}

	@Override
	public Racks findByCode(String code) throws Exception {
		return racksRepo.findByRackCode(code);
	}

	@Override
	public void deleteById(Long id) throws Exception {
		racksRepo.deleteById(id);
	}

	@Override
	public void updateRack(Racks rack) throws Exception {
		racksRepo.save(rack);
	}

}
