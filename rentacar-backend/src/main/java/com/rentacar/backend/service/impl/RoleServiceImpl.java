package com.rentacar.backend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rentacar.backend.model.Role;
import com.rentacar.backend.repository.RoleRepository;
import com.rentacar.backend.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepository roleRepository;

	@Override
	public Role findOneByName(String role) {
		return roleRepository.findOneByName(role);
	}

	@Override
	public List<Role> getAllRoles() {
		return roleRepository.findAll();
	}

}
