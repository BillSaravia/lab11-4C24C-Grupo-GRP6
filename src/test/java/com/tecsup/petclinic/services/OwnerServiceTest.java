package com.tecsup.petclinic.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.tecsup.petclinic.entities.Owner;
import com.tecsup.petclinic.exception.OwnerNotFoundException;

@SpringBootTest
public class OwnerServiceTest {

	private static final Logger logger = LoggerFactory.getLogger(OwnerServiceTest.class);

	//@Autowired
    private OwnerService ownerService;
    private PetService petService;

	/**
	 * 
	 */
	
	@Test
	public void testFindOwnerById() {

		long ID = 1;
		String NAME = "George";
		Owner owner = null;
		
		try {
			
			owner = ownerService.findById(ID);
			
		} catch (OwnerNotFoundException e) {
			fail(e.getMessage());
		}
		logger.info("" + owner);

		assertEquals(NAME, owner.getFirst_name());

	}
	
	
	
	
	public void testDeleteOwner() {

		String first_name = "Bill";


		Owner owner = new Owner(first_name);
		owner = ownerService.create(owner);
		logger.info("" + owner);

		try {
			ownerService.delete(owner.getId());
		} catch (OwnerNotFoundException e) {
			assertThat(e.getMessage(), false);
		}
			
		try {
			ownerService.findById(owner.getId());
			assertThat(true, is(false));
		} catch (OwnerNotFoundException e) {
			assertThat(true, is(true));
		} 				

	}
	
	@Test
	public void tesCreateOwner() {

		String OWNER_NAME = "Claudia";
		String LAST_NAME = "Rojas";
		String TELEPHONE="989554125";

		Owner owner = new Owner(OWNER_NAME, LAST_NAME,TELEPHONE );
		
		Owner ownerCreated = ownerService.create(owner);
		
		logger.info("Owner CREATED :" + ownerCreated);

		//          ACTUAL                 , EXPECTED 
		assertThat(ownerCreated.getId()      , notNullValue());
		assertThat(ownerCreated.getFirst_name()    , is(OWNER_NAME));
		assertThat(ownerCreated.getLast_name(), is(LAST_NAME));
		assertThat(ownerCreated.getTelephone()  , is(TELEPHONE));

	}
	
	@Test
	public void teFindOwnerLastName() {

		String TYPE_ID = "Rodriguez";
		int SIZE_EXPECTED = 2;

		List<Owner> pets = ownerService.FindOwnerLastName(TYPE_ID);

		assertThat(pets.size(), is(SIZE_EXPECTED));
	}

	
}
