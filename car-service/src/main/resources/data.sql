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

INSERT INTO xml.automobili (`id`, `cdw`, `decija_sedista`, `dozvoljena_kilometraza`, `kilometraza`, `klasa_auta_id`, `marka_auta_id`, `model_auta_id`, `tip_menjaca_id`, `vrsta_goriva_id`) VALUES
('1', 0, 2, 50000, 10000, '1', '3', '5', '1', '1'),
('2', 0, 2, 50000, 10000, '1', '2', '1', '1', '1');