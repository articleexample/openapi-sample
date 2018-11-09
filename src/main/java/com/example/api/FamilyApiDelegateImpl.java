package com.example.api;

import java.time.LocalDate;
import java.util.concurrent.CompletableFuture;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.api.models.FamilyObject;
import com.example.api.models.PersonObject;

public class FamilyApiDelegateImpl implements FamilyApiDelegate {

	@Override
	public ResponseEntity<FamilyObject> getFamily(String id) {

			  FamilyObject fo= new FamilyObject();
			  fo.setId(id);
			  PersonObject po= new PersonObject();
				 po.setId("id");
				 po.setDob(LocalDate.now());
				 po.setEmail("abc@abc.com");
				 po.setFirstName("First");
				 po.setLastName("Last");
				 fo.addMembersItem(po);
			  ResponseEntity<FamilyObject> re=new ResponseEntity<FamilyObject>(fo, HttpStatus.OK);  
			 
		return re;
	}

	@Override
	public ResponseEntity<FamilyObject> saveFamily(FamilyObject body) {
		
			  ResponseEntity<FamilyObject> re=new ResponseEntity<FamilyObject>(body, HttpStatus.OK);  
			  
		return re;
	}

}
