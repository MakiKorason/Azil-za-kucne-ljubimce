package com.ftninformatika.jwd.test.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftninformatika.jwd.test.model.Kategorija;
import com.ftninformatika.jwd.test.repository.KategorijaRepository;
import com.ftninformatika.jwd.test.service.KategorijaService;

@Service
public class JpaKategorijaService implements KategorijaService{

	@Autowired
	private KategorijaRepository kategorijaRepository;

	@Override
	public List<Kategorija> getAll() {

		return kategorijaRepository.findAll();
	}

	@Override
	public Kategorija getOne(Long id) {

		return kategorijaRepository.getOne(id);
	}

	@Override
	public Kategorija save(Kategorija kategorija) {
		// TODO Auto-generated method stub
		return kategorijaRepository.save(kategorija);
	}

}
