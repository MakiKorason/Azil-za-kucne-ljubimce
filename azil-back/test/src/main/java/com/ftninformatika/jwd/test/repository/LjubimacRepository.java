package com.ftninformatika.jwd.test.repository;



import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.ftninformatika.jwd.test.model.Ljubimac;

@Repository
public interface LjubimacRepository extends JpaRepository<Ljubimac, Long> {

	Ljubimac getOneById(Long id);
	


	@Query("SELECT lj FROM Ljubimac lj WHERE" +
            "(:pol = NULL OR lj.pol LIKE :pol) AND" +
            "( :kategorijaId= NULL OR lj.kategorija.id=:kategorijaId) AND " +
            "(lower(:opis) =NULL OR lower(lj.opis) like lower(concat('%', :opis,'%')))")
    Page<Ljubimac> search(@RequestParam("pol") String pol, @RequestParam("kategorijaId") Long kategorijaId,
    		@RequestParam("opis") String opis, Pageable pageable);


	
}


