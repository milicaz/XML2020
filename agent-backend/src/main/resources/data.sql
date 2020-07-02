INSERT INTO xml_agent.uloge (id, name) VALUES ('2', 'ROLE_AGENT');

INSERT INTO xml_agent.privilegije (id, name) VALUES ('8', 'login_agent');

INSERT INTO xml_agent.privilegije_uloga (uloga_id, id_privilegije) VALUES ('2', '8');

INSERT INTO xml_agent.adresa (id, broj, drzava, mesto, ulica) VALUES ('3', '32b', 'Srbija', 'Novi Sad', 'Stevana Hristica');

INSERT INTO xml_agent.korisnici (tip_korisnika, id, blocked, deleted, email, enabled, ime, password, prezime, role, username, naziv_firme, poslovni_broj, broj_ograsa, adresa_id) VALUES ('AGENT', '3', false, false, 'agent@mail.com', true, 'agent', '$2a$10$maKN6G7SiYd/yJdWt0jp1.qrv546YbqhmiaBzhmqsCiPIlRrQSlWK', 'agent', 'ROLE_AGENT', 'agent', 'Firma BLA BLA', '11111111111', b'0', 3);

INSERT INTO xml_agent.uloga_korisnika(korisnik_id, uloga_id) VALUES (3,2);
