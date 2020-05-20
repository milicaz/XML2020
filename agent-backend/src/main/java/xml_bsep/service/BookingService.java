package xml_bsep.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xml_bsep.repository.AutomobilRepository;
import xml_bsep.repository.BookingRepository;

@Service
public class BookingService {
	
	@Autowired
	BookingRepository br;
	
	@Autowired
	AutomobilRepository ar;

}
