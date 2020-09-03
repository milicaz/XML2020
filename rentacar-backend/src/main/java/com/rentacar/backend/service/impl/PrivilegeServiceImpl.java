package com.rentacar.backend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rentacar.backend.model.Privilege;
import com.rentacar.backend.repository.PrivilegeRepository;
import com.rentacar.backend.service.PrivilegeService;

@Service
public class PrivilegeServiceImpl implements PrivilegeService {

	@Autowired
	private PrivilegeRepository privilegeRepository;

	@Override
	public List<Privilege> getAllPrivilege() {
		return privilegeRepository.findAll();
	}

}
