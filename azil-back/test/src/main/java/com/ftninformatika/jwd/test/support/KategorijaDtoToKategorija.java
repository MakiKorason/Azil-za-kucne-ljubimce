package com.ftninformatika.jwd.test.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.ftninformatika.jwd.test.model.Kategorija;
import com.ftninformatika.jwd.test.service.KategorijaService;
import com.ftninformatika.jwd.test.web.dto.KategorijaDTO;


@Component
public class KategorijaDtoToKategorija implements Converter<KategorijaDTO, Kategorija> {

	@Autowired
	private KategorijaService kategorijaService;

	@Override
	public Kategorija convert(KategorijaDTO kategorijaDTO) {
		Kategorija kategorija;
		if(kategorijaDTO.getId()==null) {
			kategorija=new Kategorija();

		}else {
			kategorija=kategorijaService.getOne(kategorijaDTO.getId());
		}
		if(kategorija!=null) {
			kategorija.setNaziv(kategorijaDTO.getNaziv());
		}
		return kategorija;
	}

}
