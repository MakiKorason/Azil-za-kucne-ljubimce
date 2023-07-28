package com.ftninformatika.jwd.test.service;




import org.springframework.data.domain.Page;



import com.ftninformatika.jwd.test.model.Ljubimac;


public interface LjubimacService {
    Page<Ljubimac> all(int pageNo);
	Ljubimac getOne(Long id);
	Ljubimac save(Ljubimac ljubimac);
	Ljubimac update(Ljubimac ljubimac);
	void delete(Long id);
    Page<Ljubimac> find( String pol, Long kategorijaId,  String opis, int pageNum);
    void create(Ljubimac ljubimac);
    Ljubimac updateVakcinisan(Long id, boolean vakcinisan);

}
