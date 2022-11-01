package com.tecsup.petclinic.services;

import java.util.List;

import com.tecsup.petclinic.entities.Owner;
import com.tecsup.petclinic.exception.OwnerNotFoundException;

/**
 * 
 * @author jgomezm
 *
 */
public interface OwnerService {

	/**
	 * 
	 * @param owner
	 * @return
	 */
	Owner create(Owner owner);

	/**
	 * 
	 * @param owner
	 * @return
	 */
	Owner update(Owner owner);

	/**
	 * 
	 * @param id
	 * @throws OwnerNotFoundException
	 */
	void delete(Long id) throws OwnerNotFoundException;

	/**
	 * 
	 * @param id
	 * @return
	 */
	Owner findById(long id) throws OwnerNotFoundException;

	/**
	 * 
	 * @param name
	 * @return
	 */
	List<Owner> findByName(String name);
	List <Owner> FindOwnerLastName(String last_name);

	Iterable<Owner> findAll();

	/**
	 * 
	 * @param id
	 * @return
	 */
	Owner findById1(long id) throws OwnerNotFoundException;

	Owner update1(Owner owner);

	/**
	 * 
	 * @param owner
	 * @return
	 */
	Owner create1(Owner owner);

}