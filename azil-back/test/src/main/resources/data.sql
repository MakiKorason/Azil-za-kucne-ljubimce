INSERT INTO korisnik (id, e_mail, korisnicko_ime, lozinka, ime, prezime, uloga)
              VALUES (1,'miroslav@maildrop.cc','miroslav','$2y$12$NH2KM2BJaBl.ik90Z1YqAOjoPgSd0ns/bF.7WedMxZ54OhWQNNnh6','Miroslav','Simic','ADMIN');
INSERT INTO korisnik (id, e_mail, korisnicko_ime, lozinka, ime, prezime, uloga)
              VALUES (2,'tamara@maildrop.cc','tamara','$2y$12$DRhCpltZygkA7EZ2WeWIbewWBjLE0KYiUO.tHDUaJNMpsHxXEw9Ky','Tamara','Milosavljevic','KORISNIK');
INSERT INTO korisnik (id, e_mail, korisnicko_ime, lozinka, ime, prezime, uloga)
              VALUES (3,'petar@maildrop.cc','petar','$2y$12$i6/mU4w0HhG8RQRXHjNCa.tG2OwGSVXb0GYUnf8MZUdeadE4voHbC','Petar','Jovic','KORISNIK');
 
   INSERT INTO kategorija (id, naziv) VALUES (1,'Pas'); 
   INSERT INTO kategorija (id, naziv) VALUES (2,'Mačka');
   INSERT INTO kategorija (id, naziv) VALUES (3,'Ptica');

    
   INSERT INTO ljubimac (id, ime, broj_meseci, vakcinisan, pol, tezina, opis, kategorija_id)
   VALUES (1,"Čarli",10, true, "muški", 20.2, "Nemački ovčar, prijatno nastrojen prema ljudima, dresiran", 1); 
   INSERT INTO ljubimac (id, ime, broj_meseci,  vakcinisan, pol, tezina, opis, kategorija_id)
   VALUES (2,"Sebastijan",3, true, "muški", 9.5, "Plavo žuta ara koju ste sigurno vidjali u reklamama za kafu. Sebastijan je raspevani drug",3);
   INSERT INTO ljubimac (id, ime, broj_meseci, vakcinisan, pol, tezina, opis, kategorija_id)
   VALUES (3,"Bagira",16, false, "ženski", 12.9, "Crna mačka, umiljata, voli sunce i toploti, zbog toga često leži pored osunčanog prozora", 2);
   INSERT INTO ljubimac (id, ime, broj_meseci, vakcinisan, pol, tezina, opis, kategorija_id)
   VALUES (4,"Hana",3, false, "ženski", 10.4, "Zeleno žuti slavuj raspevanog glasa. Kućni ljubimac koji će u vaš dom uneti svojim glasom toplinu i sreću", 3);
   INSERT INTO ljubimac (id, ime, broj_meseci, vakcinisan, pol, tezina, opis, kategorija_id)
   VALUES (5,"Čičak",2, true, "muški", 16.2, "Plavi rus, sive dlake i prodornih plavih očiju. Voli da se izležava po suncu i da lovi miševe", 2);
   INSERT INTO ljubimac (id, ime, broj_meseci, vakcinisan, pol, tezina, opis, kategorija_id)
   VALUES (6,"Luna",14, true, "ženski", 4.5, "Vernan čovekov prijatelj i glasnik noći. Luna je ženski haski, donesena pravo iz Sibira", 1 );
   
   
   
   


                         