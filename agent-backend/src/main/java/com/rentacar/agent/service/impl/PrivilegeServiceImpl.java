package com.rentacar.agent.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rentacar.agent.model.Privilege;
import com.rentacar.agent.repository.PrivilegeRepository;
import com.rentacar.agent.service.PrivilegeService;

@Service
public class PrivilegeServiceImpl implements PrivilegeService {

	@Autowired
	private PrivilegeRepository privilegeRepository;

	@Override
	public Privilege save(Privilege privilege) {
		return privilegeRepository.save(privilege);
	}

	@Override
	public void deleteAll() {
		privilegeRepository.deleteAll();

	}

	@Override
	public void deleteRolePrivilege() {
		privilegeRepository.deleteRolePrivilege();

	}

}
