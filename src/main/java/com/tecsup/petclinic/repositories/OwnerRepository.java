package com.tecsup.petclinic.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tecsup.petclinic.entities.Owner;

/**
 * 
 * @author BSARAVIA
 *
 */
@Repository
public interface OwnerRepository 
	extends CrudRepository<Owner, Long> {

	// Fetch pets by name
	List<Owner> findByName(String name);


}
