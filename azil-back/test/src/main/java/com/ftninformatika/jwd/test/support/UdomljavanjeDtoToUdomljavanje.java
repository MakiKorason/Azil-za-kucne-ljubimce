package com.ftninformatika.jwd.test.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.ftninformatika.jwd.test.model.Udomljavanje;
import com.ftninformatika.jwd.test.service.LjubimacService;
import com.ftninformatika.jwd.test.service.UdomljavanjeService;
import com.ftninformatika.jwd.test.web.dto.UdomljavanjeDTO;

@Component
public class UdomljavanjeDtoToUdomljavanje implements Converter<UdomljavanjeDTO,  Udomljavanje>{


	@Autowired
	private UdomljavanjeService udomljavanjeService;

	@Autowired
	private LjubimacService ljubimacService;

	@Override
	public Udomljavanje convert(UdomljavanjeDTO udomljavanjeDTO) {
		Udomljavanje udomljavanje;
		if(udomljavanjeDTO.getId()==null) {
			udomljavanje=new Udomljavanje();

		}
		else {
			udomljavanje=udomljavanjeService.getOne(udomljavanjeDTO.getId());
		}
		if(udomljavanje!=null) {
			udomljavanje.setDatumVreme(udomljavanjeDTO.getDatumVreme());
			udomljavanje.setLjubimac(ljubimacService.getOne(udomljavanjeDTO.getId()));
		}
		return udomljavanje;
	}

}
