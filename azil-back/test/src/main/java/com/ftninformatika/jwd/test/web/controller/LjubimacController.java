package com.ftninformatika.jwd.test.web.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.ftninformatika.jwd.test.model.Ljubimac;

import com.ftninformatika.jwd.test.service.LjubimacService;
import com.ftninformatika.jwd.test.support.LjubimacDtoToLjubimac;
import com.ftninformatika.jwd.test.support.LjubimacToLjubimacDTO;

import com.ftninformatika.jwd.test.web.dto.LjubimacDTO;



@RestController
@RequestMapping(value= "/api/ljubimci")
public class LjubimacController {

	@Autowired
	private LjubimacService ljubimacService;
	@Autowired
	private LjubimacDtoToLjubimac toLjubimac;
	@Autowired
	private LjubimacToLjubimacDTO toLjubimacDTO;


//	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<LjubimacDTO> delete(@PathVariable Long id){
		ljubimacService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

//	@PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
	@RequestMapping(method=RequestMethod.PUT,value="/{id}")
	public ResponseEntity<LjubimacDTO> edit(@PathVariable Long id,@RequestBody LjubimacDTO izmenjen){
		if(!id.equals(izmenjen.getId())){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}else {
			Ljubimac ljubimac = toLjubimac.convert(izmenjen); 
			ljubimacService.save(ljubimac);
			return new ResponseEntity<>(toLjubimacDTO.convert(ljubimac),
					HttpStatus.OK);
		}

	}
//	@PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<LjubimacDTO> create (@Valid @RequestBody LjubimacDTO novi){
		Ljubimac ljubimac = toLjubimac.convert(novi);
		ljubimacService.save(ljubimac);
		return new ResponseEntity<>(toLjubimacDTO.convert(ljubimac), HttpStatus.CREATED);
	}


//	@PreAuthorize("hasAnyRole('ROLE_KORISNIK', 'ROLE_ADMIN')")
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<LjubimacDTO> get(@PathVariable Long id){
		Ljubimac ljubimac= ljubimacService.getOne(id);
		if (ljubimac== null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(toLjubimacDTO.convert(ljubimac), HttpStatus.OK);
	}

	@PreAuthorize("hasAnyRole('ROLE_KORISNIK', 'ROLE_ADMIN')")
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<LjubimacDTO>> get(
			@RequestParam(value="pol",required=false) String pol,
			@RequestParam(value="kategorijaId", required=false) Long kategorijaId,
			@RequestParam(value="opis",  required=false) String opis,
			@RequestParam(value = "pageNo", defaultValue = "0") int pageNo){


		Page<Ljubimac> page = ljubimacService.find(pol, kategorijaId, opis,  pageNo);


		HttpHeaders headers = new HttpHeaders();
		headers.add("Total-Pages", Integer.toString(page.getTotalPages()));

		return new ResponseEntity<>(toLjubimacDTO.convert(page.getContent()), headers,  HttpStatus.OK);
	}

    @PutMapping("/vakcinacija/{id}")
    public ResponseEntity<LjubimacDTO> updateVakcinisan(@PathVariable Long id, @RequestParam boolean vakcinisan) {
        Ljubimac ljubimac = ljubimacService.updateVakcinisan(id, vakcinisan);
       return new ResponseEntity<>(toLjubimacDTO.convert(ljubimac), HttpStatus.OK);
    }

	

	@ExceptionHandler(value = DataIntegrityViolationException.class)
	public ResponseEntity<Void> handle() {
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}


}

