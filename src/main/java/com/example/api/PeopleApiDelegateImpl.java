package com.example.api;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.api.models.PersonObject;

public class PeopleApiDelegateImpl implements PeopleApiDelegate {

	@Override
	public ResponseEntity<PersonObject> getPerson(String id) {
		
		
			  PersonObject po= new PersonObject();
			 po.setId(id);
			 po.setDob(LocalDate.now());
			 po.setEmail("abc@abc.com");
			 po.setFirstName("First");
			 po.setLastName("Last");
			  ResponseEntity<PersonObject> re=new ResponseEntity<PersonObject>(po, HttpStatus.OK);  
			 
		return re;
	}

	@Override
	public ResponseEntity<PersonObject> savePerson(PersonObject body) {
			  ResponseEntity<PersonObject> re=new ResponseEntity<PersonObject>(body, HttpStatus.OK);  
			 
		return re;
	}

}
