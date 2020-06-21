INSERT INTO xml.uloge (id, name) VALUES ('1', 'ROLE_ADMIN');
INSERT INTO xml.uloge (id, name) VALUES ('2', 'ROLE_AGENT');
INSERT INTO xml.uloge (id, name) VALUES ('3', 'ROLE_KORISNIK');

INSERT INTO xml.privilegije (id, name) VALUES ('1', 'block_korisnik');
INSERT INTO xml.privilegije (id, name) VALUES ('2', 'delete_korisnik');
INSERT INTO xml.privilegije (id, name) VALUES ('3', 'activate_korisnik');
INSERT INTO xml.privilegije (id, name) VALUES ('4', 'all_korisnici');
INSERT INTO xml.privilegije (id, name) VALUES ('5', 'all_agenti');
INSERT INTO xml.privilegije (id, name) VALUES ('6', 'add_agent');
INSERT INTO xml.privilegije (id, name) VALUES ('7', 'login_admin');
INSERT INTO xml.privilegije (id, name) VALUES ('8', 'login_agent');
INSERT INTO xml.privilegije (id, name) VALUES ('9', 'login_korisnik');

INSERT INTO xml.privilegije_uloga (uloga_id, id_privilegije) VALUES ('1', '1');
INSERT INTO xml.privilegije_uloga (uloga_id, id_privilegije) VALUES ('1', '2');
INSERT INTO xml.privilegije_uloga (uloga_id, id_privilegije) VALUES ('1', '3');
INSERT INTO xml.privilegije_uloga (uloga_id, id_privilegije) VALUES ('1', '4');
INSERT INTO xml.privilegije_uloga (uloga_id, id_privilegije) VALUES ('1', '7');

INSERT INTO xml.privilegije_uloga (uloga_id, id_privilegije) VALUES ('2', '8');

INSERT INTO xml.privilegije_uloga (uloga_id, id_privilegije) VALUES ('3', '9');

INSERT INTO xml.adresa (id, broj, drzava, mesto, ulica) VALUES ('1', '2a', 'Srbija', 'Novi Sad', 'Vase Stajica');
INSERT INTO xml.adresa (id, broj, drzava, mesto, ulica) VALUES ('2', '65', 'Srbija', 'Novi Sad', 'Sekspirova');
INSERT INTO xml.adresa (id, broj, drzava, mesto, ulica) VALUES ('3', '32b', 'Srbija', 'Novi Sad', 'Stevana Hristica');

INSERT INTO xml.korisnici (tip_korisnika, id, blocked, deleted, email, enabled, ime, password, prezime, role, username, naziv_firme, poslovni_broj, broj_ograsa, adresa_id) VALUES ('ADMIN', '1', false, false, 'admin@mail.com', true, 'admin', '$2a$10$NVUknlPnVsHKrjYZDNFhzOJ6h1XiyW.bIYTO2z7Ga.HFt.wesq0Nu', 'adminic', 'ROLE_ADMIN', 'admin', '', '', b'0', b'1');
INSERT INTO xml.korisnici (tip_korisnika, id, blocked, deleted, email, enabled, ime, password, prezime, role, username, naziv_firme, poslovni_broj, broj_ograsa, adresa_id) VALUES ('KRAJNJI_KORISNIK', '2', false, false, 'korisnik@mail.com', true, 'korisnik', '$2a$10$es3i7TzCBTcs4M5rKRyTd.oiJ61VbbAPDeMGogB7fiAqjcU264EWa', 'korisik', 'ROLE_KORISNIK', 'korisnik', '', '', b'0', 2);
INSERT INTO xml.korisnici (tip_korisnika, id, blocked, deleted, email, enabled, ime, password, prezime, role, username, naziv_firme, poslovni_broj, broj_ograsa, adresa_id) VALUES ('AGENT', '3', false, false, 'agent@mail.com', true, 'agent', '$2a$10$maKN6G7SiYd/yJdWt0jp1.qrv546YbqhmiaBzhmqsCiPIlRrQSlWK', 'agent', 'ROLE_AGENT', 'agent', 'Firma BLA BLA', '11111111111', b'0', 3);

INSERT INTO xml.uloga_korisnika(korisnik_id, uloga_id) VALUES (1,1);
INSERT INTO xml.uloga_korisnika(korisnik_id, uloga_id) VALUES (2,3);
INSERT INTO xml.uloga_korisnika(korisnik_id, uloga_id) VALUES (3,2);
