package com.ftninformatika.jwd.test.support;

import java.util.ArrayList;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.ftninformatika.jwd.test.model.Ljubimac;
import com.ftninformatika.jwd.test.web.dto.LjubimacDTO;



@Component
public class LjubimacToLjubimacDTO implements Converter<Ljubimac, LjubimacDTO>{



	@Override
	public LjubimacDTO convert(Ljubimac ljubimac) {
		LjubimacDTO ljubimacDTO= new LjubimacDTO();
		ljubimacDTO.setId(ljubimac.getId());
		ljubimacDTO.setIme(ljubimac.getIme());
		ljubimacDTO.setPol(ljubimac.getPol());
		ljubimacDTO.setOpis(ljubimac.getOpis());
		ljubimacDTO.setBrojMeseci(ljubimac.getBrojMeseci());
		ljubimacDTO.setTezina(ljubimac.getTezina());
		ljubimacDTO.setVakcinisan(ljubimac.isVakcinisan());
		ljubimacDTO.setKategorijaId(ljubimac.getKategorija().getId());
		ljubimacDTO.setKategorijaNaziv(ljubimac.getKategorija().getNaziv());


		return ljubimacDTO;
	}

	public java.util.List<LjubimacDTO>convert(java.util.List<Ljubimac>ljubimci){
		java.util.List<LjubimacDTO>ljubimciDTO= new ArrayList<>();
		for(Ljubimac lj: ljubimci) {
			ljubimciDTO.add(convert(lj));		}

		return ljubimciDTO;

	}
}
