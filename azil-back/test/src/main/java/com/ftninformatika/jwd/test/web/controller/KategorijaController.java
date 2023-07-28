package com.ftninformatika.jwd.test.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ftninformatika.jwd.test.model.Kategorija;

import com.ftninformatika.jwd.test.service.KategorijaService;
import com.ftninformatika.jwd.test.support.KategorijaDtoToKategorija;
import com.ftninformatika.jwd.test.support.KategorijaToKategorijaDTO;
import com.ftninformatika.jwd.test.web.dto.KategorijaDTO;

@RestController
@RequestMapping(value="/api/kategorije")
public class KategorijaController {

	@Autowired
	private KategorijaService kategorijaService;

	@Autowired
	private KategorijaDtoToKategorija toKategorija;

	@Autowired 
	private KategorijaToKategorijaDTO toKategorijaDTO;



	@RequestMapping( method=RequestMethod.GET)
	public ResponseEntity<List<KategorijaDTO>> getAll(){
		List<Kategorija>kategorije= kategorijaService.getAll();
		return new ResponseEntity<>(toKategorijaDTO.convert(kategorije), HttpStatus.OK);
	}


	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<KategorijaDTO> create (@Valid @RequestBody KategorijaDTO novi){
		Kategorija kategorija = toKategorija.convert(novi);
		kategorijaService.save(kategorija);
		return new ResponseEntity<>(toKategorijaDTO.convert(kategorija), HttpStatus.CREATED);
	}



}
