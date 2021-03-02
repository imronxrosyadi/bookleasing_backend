package com.lawencon.bookleasing.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lawencon.bookleasing.model.Racks;

/**
 * @author Imron Rosyadi
 */

@Repository
public class RacksDaoHibernateImpl extends BaseDao implements RacksDao {

	@Override
	public Racks insertRack(Racks rack) throws Exception {
		em.persist(rack);

		return rack;
	}

	@Override
	public List<Racks> getListRacks() throws Exception {
		List<Racks> listResult = em.createQuery("from Racks", Racks.class).getResultList();

		return listResult;
	}

	@Override
	public Racks findByCode(String code) throws Exception {
		List<Racks> listResult = em.createQuery("from Racks where rackCode = ?1 ", Racks.class).setParameter(1, code)
				.getResultList();

		return listResult.size() > 0 ? listResult.get(0) : null;
	}

	@Override
	public void deleteById(Long id) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateRack(Racks rack) throws Exception {
		// TODO Auto-generated method stub

	}

}
