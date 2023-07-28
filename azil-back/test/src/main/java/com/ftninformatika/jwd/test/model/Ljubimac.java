package com.ftninformatika.jwd.test.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Ljubimac {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
@Column(nullable = false)
private String Ime;
@Column(name= "broj_meseci")
private int brojMeseci;
@Column(nullable = false)
private boolean vakcinisan=false;
@Column(nullable = false)
private String pol;
@Column(nullable = false)
private double tezina;
@Column(nullable = false)
private String opis;
@ManyToOne
@JoinColumn(name="kategorija_id")
private Kategorija kategorija;


public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getIme() {
	return Ime;
}

public void setIme(String ime) {
	Ime = ime;
}

public int getBrojMeseci() {
	return brojMeseci;
}

public void setBrojMeseci(int brojMeseci) {
	this.brojMeseci = brojMeseci;
}

public boolean isVakcinisan() {
	return vakcinisan;
}

public void setVakcinisan(boolean vakcinisan) {
	this.vakcinisan = vakcinisan;
}

public String getPol() {
	return pol;
}

public void setPol(String pol) {
	this.pol = pol;
}

public double getTezina() {
	return tezina;
}

public void setTezina(double tezina) {
	this.tezina = tezina;
}

public String getOpis() {
	return opis;
}

public void setOpis(String opis) {
	this.opis = opis;
}

public Kategorija getKategorija() {
	return kategorija;
}

public void setKategorija(Kategorija kategorija) {
	this.kategorija = kategorija;
}

public Ljubimac() {
	super();
}


@Override
public String toString() {
	return "Ljubimac [id=" + id + ", Ime=" + Ime + ", brojMeseci=" + brojMeseci + ", vakcinisan=" + vakcinisan
			+ ", pol=" + pol + ", tezina=" + tezina + ", opis=" + opis + ", kategorija=" + kategorija + "]";
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
	Ljubimac other = (Ljubimac) obj;
	return Objects.equals(id, other.id);
}


	
}










