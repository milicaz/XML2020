package xml_bsep.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xml_bsep.repository.KorisnikRepository;
import xml_bsep.repository.PorukaRepository;

@Service
public class PorukaService {
	
	@Autowired
	PorukaRepository pr;
	
	@Autowired
	KorisnikRepository kr;

}
