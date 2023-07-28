package com.ftninformatika.jwd.test.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.ftninformatika.jwd.test.model.Udomljavanje;

import com.ftninformatika.jwd.test.service.UdomljavanjeService;

import com.ftninformatika.jwd.test.support.UdomljavanjeToUdomljavanjeDTO;

import com.ftninformatika.jwd.test.web.dto.UdomljavanjeDTO;

@RestController
@RequestMapping(value="/api/udomljavanje")
public class UdomljavanjeController {

	@Autowired
	private UdomljavanjeService udomljavanjeService;



	@Autowired
	private UdomljavanjeToUdomljavanjeDTO toUdomljavanjeDTO;




	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<UdomljavanjeDTO> get(@PathVariable Long id){
		Udomljavanje udomljavanje= udomljavanjeService.getOne(id);
		if (udomljavanje== null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(toUdomljavanjeDTO.convert(udomljavanje), HttpStatus.OK);
	}

	@PreAuthorize("hasRole('ROLE_KORISNIK')")
	@PostMapping(value="/{ljubimacId}")
	public ResponseEntity<?> udomi(@PathVariable Long ljubimacId  ){
		Udomljavanje udomljavanje=null;
		try{
			udomljavanje=udomljavanjeService.udomi(ljubimacId);
		}catch(RuntimeException e){
			return new ResponseEntity<>("Ljubimac je vec udomljen",HttpStatus.BAD_REQUEST);
		}

		if(udomljavanje==null) {
			return new ResponseEntity<>("Nije moguce udomiti ljubimca koji nije vakcinisan!",HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<>(toUdomljavanjeDTO.convert(udomljavanje), HttpStatus.CREATED);

	}


}
