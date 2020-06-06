INSERT INTO xml.adresa (`id`, `broj`, `drzava`, `mesto`, `ulica`) VALUES 
('1', '23', 'Srbija', 'Novi Sad', 'Dunavska'),
('2', '55', 'Srbija', 'Novi Sad', 'Reljkoviceva'),
('3', '78', 'Srbija', 'Novi Sad', 'Bulevar oslobodjenja');

INSERT INTO xml.korisnici (`user_type`, `id`, `email`, `ime`, `password`, `prezime`, `username`, `adresa_id`) VALUES
('ADMIN', '1', 'admin@mail.com', 'Admin', 'admin', 'Adminic', 'admin', '1'),
('AGENT', '2', 'agent@mail.com', 'Agent', 'agent', 'Agentic', 'agent', '2'),
('KRAJNJI_KORISNIK', '3', 'korisnik@mail.com', 'Petar', 'petar', 'Petrovic', 'petar', '3');

INSERT INTO xml.marka_auta (`id`, `ime`) VALUES 
('1', 'Audi'),
('2', 'BMW'),
('3', 'Toyota');

INSERT INTO xml.model_auta (`id`, `ime`, `marka_auta_id`) VALUES
('1', 'X4', '1'),
('2', 'X7', '1'),
('3', 'A6', '2'),
('4', 'Q7', '2'),
('5', 'RAV4', '3');

INSERT INTO xml.klasa_auta (`id`, `ime`) VALUES 
('1', 'SUV'),
('2', 'Minivan'),
('3', 'Gradski automobil');

INSERT INTO xml.tip_menjaca (`id`, `ime`) VALUES 
('1', 'rucni menjac'),
('2', 'automatski menjac');

INSERT INTO xml.vrsta_goriva (`id`, `ime`) VALUES 
('1', 'benzin'),
('2', 'dizel');

INSERT INTO xml.automobili (`id`, `cdw`, `decija_sedista`, `dozvoljena_kilometraza`, `kilometraza`, `klasa_automobila_id`, `marka_automobila_id`, `model_automobila_id`, `tip_menjaca_id`, `vrsta_goriva_id`) VALUES
('1', 0, 2, 50000, 10000, '1', '3', '5', '1', '1'),
('2', 0, 2, 50000, 10000, '1', '2', '1', '1', '1');

INSERT INTO xml.cenovnici (`id`, `cena_po_danu`, `cena_po_kilometru`, `cena_za_cdw`, `datum_do`, `datum_od`, `auto_id`) VALUES
('1', 50, 50, 50, '20200607', '20200614', '1');

INSERT INTO xml.oglasi (`id`, `slobodan_do`, `slobodan_od`, `auto_id`, `cenovnik_id`, `korisnik_id`) VALUES
('1', '20200607', '20200614', '1', '1', '2'),
('2', '20200607', '20200614', '2', '1', '3');
