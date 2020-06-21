package com.rentacar.backend.service;

import java.util.List;

import com.rentacar.backend.model.Role;

public interface RoleService {

	public Role findOneByName(String role);

	public List<Role> getAllRoles();

}
