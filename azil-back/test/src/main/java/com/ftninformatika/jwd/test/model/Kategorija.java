package com.ftninformatika.jwd.test.model;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Kategorija {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
@Column(nullable = false, unique = true)
private String naziv;

@OneToMany(mappedBy = "kategorija", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
private List<Ljubimac> ljubimci= new ArrayList<>();

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getNaziv() {
	return naziv;
}

public void setNaziv(String naziv) {
	this.naziv = naziv;
}

public ArrayList<Ljubimac> getLjubimci() {
	return (ArrayList<Ljubimac>) ljubimci;
}

public void setLjubimci(ArrayList<Ljubimac> ljubimci) {
	this.ljubimci = ljubimci;
}

public Kategorija() {
	super();
}

@Override
public String toString() {
	return "Kategorija [id=" + id + ", naziv=" + naziv + ", ljubimci=" + ljubimci + "]";
}

@Override
public int hashCode() {
	return Objects.hash(id);
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Kategorija other = (Kategorija) obj;
	return Objects.equals(id, other.id);
}




}
