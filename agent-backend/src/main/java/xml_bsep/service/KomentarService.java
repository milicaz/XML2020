package xml_bsep.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xml_bsep.repository.KomentarRepository;
import xml_bsep.repository.KorisnikRepository;

@Service
public class KomentarService {
	
	@Autowired
	KomentarRepository kr;
	
	@Autowired
	KorisnikRepository korr;

}
