package com.ftninformatika.jwd.test.service;

import java.util.List;

import com.ftninformatika.jwd.test.model.Kategorija;

public interface KategorijaService {
	List<Kategorija> getAll();
    Kategorija getOne(Long id);
	Kategorija save(Kategorija kategorija);
}
