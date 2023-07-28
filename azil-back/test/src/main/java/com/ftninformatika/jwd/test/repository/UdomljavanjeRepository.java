package com.ftninformatika.jwd.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ftninformatika.jwd.test.model.Ljubimac;
import com.ftninformatika.jwd.test.model.Udomljavanje;

@Repository
public interface UdomljavanjeRepository extends JpaRepository<Udomljavanje, Long>{

	Udomljavanje findOneById(Long id);
	void deleteById(Long id);
	Udomljavanje findByLjubimacId(Long ljubimacId);
	Udomljavanje save(Ljubimac  ljubimac);
	boolean  existsByLjubimacId(Long id);
	
	
}
