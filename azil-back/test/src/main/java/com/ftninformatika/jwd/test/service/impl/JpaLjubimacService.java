package com.ftninformatika.jwd.test.service.impl;



import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import org.springframework.stereotype.Service;

import com.ftninformatika.jwd.test.model.Ljubimac;
import com.ftninformatika.jwd.test.model.Udomljavanje;
import com.ftninformatika.jwd.test.repository.LjubimacRepository;
import com.ftninformatika.jwd.test.repository.UdomljavanjeRepository;
import com.ftninformatika.jwd.test.service.LjubimacService;



@Service
public class JpaLjubimacService implements LjubimacService {

@Autowired
private LjubimacRepository ljubimacRepository;

@Autowired
private UdomljavanjeRepository udomljavanjeRepository;
	
	

	@Override
	public Ljubimac getOne(Long id) {
		return ljubimacRepository.getOneById(id);
	}

	@Override
	public Ljubimac save(Ljubimac ljubimac) {
//	ljubimac.setVakcinisan(false);
		return ljubimacRepository.save(ljubimac);
	}

	@Override
	public Ljubimac update(Ljubimac ljubimac) {
		
		return ljubimacRepository.save(ljubimac);
	}

	@Override
	public void delete(Long id) {
	Udomljavanje udomljavanje=	udomljavanjeRepository.findByLjubimacId(id);
	if(udomljavanje!=null) {
		udomljavanje.setLjubimac(null);	
		udomljavanjeRepository.save(udomljavanje);
		udomljavanjeRepository.deleteById(udomljavanje.getId());
	}
		ljubimacRepository.deleteById(id);
	}


	@Override
	public Page<Ljubimac> find(String pol, Long kategorijaId, String opis, int page ) {
//		 if (pol == null) {
//	            pol = "";
//	        }
//		
//		if (opis == null) {
//	            opis = "";
//	        }

//		if(kategorijaId!=null) {
//			return ljubimacRepository.findByOpisIgnoreCaseContainsAndPolAndKategorijaId(opis, pol, kategorijaId);
//		}
		return ljubimacRepository.search(pol, kategorijaId, opis, PageRequest.of(page, 3));
	//return ljubimacRepository.findByOpisIgnoreCaseContainsAndPol(opis, pol);
	}

	@Override
	public Page<Ljubimac> all(int pageNo) {
		// TODO Auto-generated method stub
		return ljubimacRepository.findAll(PageRequest.of(pageNo, 3));
	}

	@Override
	public void create(Ljubimac ljubimac) {
		ljubimacRepository.save(ljubimac);
	}

	
    @Transactional
	 @Override
	    public Ljubimac updateVakcinisan(Long id, boolean vakcinisan) {
	        Ljubimac ljubimac = ljubimacRepository.getOne(id);
	        if (ljubimac == null) {
	            return null;
	        }

	        ljubimac.setVakcinisan(vakcinisan);
	        return ljubimacRepository.save(ljubimac);
	    }




}
