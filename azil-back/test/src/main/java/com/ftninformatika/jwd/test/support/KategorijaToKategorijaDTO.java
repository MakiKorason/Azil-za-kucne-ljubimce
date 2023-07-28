package com.ftninformatika.jwd.test.support;

import java.util.ArrayList;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.ftninformatika.jwd.test.model.Kategorija;
import com.ftninformatika.jwd.test.web.dto.KategorijaDTO;


@Component
public class KategorijaToKategorijaDTO implements Converter<Kategorija, KategorijaDTO> {

	@Override
	public KategorijaDTO convert(Kategorija kategorija) {
		KategorijaDTO kategorijaDTO= new KategorijaDTO();
		kategorijaDTO.setId(kategorija.getId());
		kategorijaDTO.setNaziv(kategorija.getNaziv());
		return kategorijaDTO;
	}

	public java.util.List<KategorijaDTO> convert(java.util.List<Kategorija>kategorije){
		java.util.List<KategorijaDTO>kategorijeDTO=new ArrayList<>();
		for(Kategorija k: kategorije) {
			kategorijeDTO.add(convert(k));
		}
		return kategorijeDTO;


	}
}
