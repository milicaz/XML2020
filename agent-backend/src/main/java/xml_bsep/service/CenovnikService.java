package xml_bsep.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xml_bsep.repository.CenovnikRepository;

@Service
public class CenovnikService {
	
	@Autowired
	CenovnikRepository cr;

}
