package com.tecsup.petclinic.services;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tecsup.petclinic.entities.Owner;
import com.tecsup.petclinic.exception.OwnerNotFoundException;
import com.tecsup.petclinic.repositories.OwnerRepository;

/**
 * 
 * @author jgomezm
 *
 */
@Service
public class OwnerServiceImpl implements OwnerService {

	private static final Logger logger = LoggerFactory.getLogger(OwnerServiceImpl.class);

	@Autowired
	OwnerRepository ownerRepository;

	/**
	 * 
	 * @param owner
	 * @return
	 */
	@Override
	public Owner create1(Owner owner) {
		return ownerRepository.save(owner);
	}

	/**
	 * 
	 * @param owner
	 * @return
	 */
	@Override
	public Owner update(Owner owner) {
		return ownerRepository.save(owner);
	}


	/**
	 * 
	 * @param id
	 * @throws OwnerNotFoundException
	 */
	@Override
	public void delete(Long id) throws OwnerNotFoundException{

		Owner owner = findById1(id);
		ownerRepository.delete(owner);

	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	@Override
	public Owner findById1(long id) throws OwnerNotFoundException {

		Optional<Owner> owner = ownerRepository.findById(id);

		if ( !owner.isPresent())
			throw new OwnerNotFoundException("Record not found...!");
			
		return owner.get();
	}

	/**
	 * 
	 * @param name
	 * @return
	 */
	@Override
	public List<Owner> findByName(String name) {

		List<Owner> owners = ownerRepository.findByName(name);

		owners.stream().forEach(owner -> logger.info("" + owner));

		return owners;
	}
	
	public List <Owner> FindOwnerLastName(String last_name){
	
	List<Owner> owners = ownerRepository.FindOwnerLastName(last_name);
	owners.stream().forEach(owner -> logger.info("" + owner));

	return owners;
}

	/**
	 * 
	 * @return
	 */
	@Override
	public Iterable<Owner> findAll() {
		
		// TODO Auto-generated 
		return ownerRepository.findAll();
	
	}

	@Override
	public Owner create(Owner owner) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Owner update1(Owner owner) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Owner findById(long id) throws OwnerNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}