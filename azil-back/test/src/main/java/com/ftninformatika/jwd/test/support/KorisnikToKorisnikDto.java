package com.ftninformatika.jwd.test.support;
import com.ftninformatika.jwd.test.model.Korisnik;
import com.ftninformatika.jwd.test.web.dto.KorisnikDTO;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class KorisnikToKorisnikDto implements Converter<Korisnik, KorisnikDTO>{

	@Override
	public KorisnikDTO convert(Korisnik korisnik) {
		KorisnikDTO korisnikDTO = new KorisnikDTO();

		korisnikDTO.setId(korisnik.getId());
		korisnikDTO.seteMail(korisnik.geteMail());
		korisnikDTO.setIme(korisnik.getIme());
		korisnikDTO.setPrezime(korisnik.getPrezime());
		korisnikDTO.setKorisnickoIme(korisnik.getKorisnickoIme());

		return korisnikDTO;
	}

	public List<KorisnikDTO> convert(List<Korisnik> korisnici){
		List<KorisnikDTO> korisnikDTOS = new ArrayList<>();

		for(Korisnik k : korisnici) {
			KorisnikDTO dto = convert(k);
			korisnikDTOS.add(dto);
		}

		return korisnikDTOS;
	}
}
