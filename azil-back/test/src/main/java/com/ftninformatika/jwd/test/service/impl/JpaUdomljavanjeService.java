package com.ftninformatika.jwd.test.service.impl;

import java.time.LocalDateTime;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftninformatika.jwd.test.model.Ljubimac;
import com.ftninformatika.jwd.test.model.Udomljavanje;
import com.ftninformatika.jwd.test.repository.LjubimacRepository;
import com.ftninformatika.jwd.test.repository.UdomljavanjeRepository;

import com.ftninformatika.jwd.test.service.UdomljavanjeService;

@Service
public class JpaUdomljavanjeService implements UdomljavanjeService{
	@Autowired
	private UdomljavanjeRepository udomljavanjeRepository;


	@Autowired
	private LjubimacRepository ljubimacRepository;


	@Override
	public Udomljavanje getOne(Long id) {
		// TODO Auto-generated method stub
		return udomljavanjeRepository.findOneById(id);
	}


	@Override
	public Udomljavanje save(Ljubimac ljubimac) {
		Udomljavanje udomljavanje=	udomljavanjeRepository.findByLjubimacId(ljubimac.getId());
		udomljavanje.setDatumVreme(LocalDateTime.now());
		udomljavanje.setLjubimac(ljubimac);
		return udomljavanjeRepository.save(udomljavanje);
	}



	@Override
	public Udomljavanje udomi(Long ljubimacId) {
		Ljubimac ljubimac = ljubimacRepository.getOneById(ljubimacId);
		if(ljubimac.isVakcinisan()) {
			boolean udomljen= udomljavanjeRepository.existsByLjubimacId(ljubimacId);
			if(!udomljen) {
				Udomljavanje udomljavanje= new Udomljavanje();
				udomljavanje.setDatumVreme(LocalDateTime.now());
				udomljavanje.setLjubimac(ljubimac);
				return udomljavanjeRepository.save(udomljavanje);
			}
			else {
				throw new RuntimeException("greska");
			}
		}
		return null;


	}














}


