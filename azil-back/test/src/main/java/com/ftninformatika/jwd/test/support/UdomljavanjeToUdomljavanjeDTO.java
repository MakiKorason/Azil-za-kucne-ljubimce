package com.ftninformatika.jwd.test.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.ftninformatika.jwd.test.model.Udomljavanje;
import com.ftninformatika.jwd.test.web.dto.UdomljavanjeDTO;

@Component
public class UdomljavanjeToUdomljavanjeDTO implements Converter<Udomljavanje, UdomljavanjeDTO> {

	@Override
	public UdomljavanjeDTO convert(Udomljavanje udomljavanje) {
		UdomljavanjeDTO udomljavanjeDTO= new UdomljavanjeDTO();
		udomljavanjeDTO.setId(udomljavanje.getId());
		udomljavanjeDTO.setDatumVreme(udomljavanje.getDatumVreme());
		udomljavanjeDTO.setLjubimacId(udomljavanje.getLjubimac().getId());
		return udomljavanjeDTO;
	}

	public List<UdomljavanjeDTO> convert(List<Udomljavanje>udomljavanja){
		List<UdomljavanjeDTO>udomljavanjaDTO= new ArrayList<>();

		for(Udomljavanje u: udomljavanja) {
			udomljavanjaDTO.add(convert(u));
		}
		return udomljavanjaDTO;
	}
}
