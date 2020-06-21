package com.rentacar.agent.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rentacar.agent.model.Role;
import com.rentacar.agent.repository.RoleRepository;
import com.rentacar.agent.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepository roleRepository;

	@Override
	public Role findOneByName(String name) {
		return roleRepository.findOneByName(name);
	}

	@Override
	public Role saveRole(Role role) {
		return roleRepository.save(role);
	}

	@Override
	public void deleteAll() {
		roleRepository.deleteAll();
	}

}
