package com.ftninformatika.jwd.test.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.ftninformatika.jwd.test.model.Ljubimac;
import com.ftninformatika.jwd.test.service.KategorijaService;
import com.ftninformatika.jwd.test.service.LjubimacService;

import com.ftninformatika.jwd.test.web.dto.LjubimacDTO;


@Component
public class LjubimacDtoToLjubimac implements Converter<LjubimacDTO, Ljubimac> {

	@Autowired
	private LjubimacService ljubimacService;

	@Autowired
	private KategorijaService kategorijaService;


	@Override
	public Ljubimac convert(LjubimacDTO ljubimacDTO) {
		Ljubimac ljubimac;
		if(ljubimacDTO.getId()==null) {
			ljubimac=new Ljubimac();

		}else {
			ljubimac=ljubimacService.getOne(ljubimacDTO.getId());
		}
		if(ljubimac!=null) {
			ljubimac.setIme(ljubimacDTO.getIme());
			ljubimac.setBrojMeseci(ljubimacDTO.getBrojMeseci());
			ljubimac.setOpis(ljubimacDTO.getOpis());
			ljubimac.setPol(ljubimacDTO.getPol());
			ljubimac.setTezina(ljubimacDTO.getTezina());
			ljubimac.setVakcinisan(ljubimacDTO.isVakcinisan());
			ljubimac.setKategorija(kategorijaService.getOne(ljubimacDTO.getKategorijaId()));
		}
		return ljubimac;
	}

}