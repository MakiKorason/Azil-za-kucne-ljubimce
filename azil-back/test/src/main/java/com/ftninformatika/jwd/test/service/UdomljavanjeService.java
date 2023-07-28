package com.ftninformatika.jwd.test.service;



import com.ftninformatika.jwd.test.model.Ljubimac;
import com.ftninformatika.jwd.test.model.Udomljavanje;

public interface UdomljavanjeService {

	Udomljavanje getOne(Long id);
	Udomljavanje save(Ljubimac ljubimac);
	Udomljavanje udomi(Long ljubimacId);

	
	
	

}
