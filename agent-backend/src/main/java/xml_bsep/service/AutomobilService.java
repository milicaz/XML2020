package xml_bsep.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xml_bsep.repository.AutomobilRepository;

@Service
public class AutomobilService {
	
	@Autowired
	AutomobilRepository ar;

}
