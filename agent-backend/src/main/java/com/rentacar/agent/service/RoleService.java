package com.rentacar.agent.service;

import com.rentacar.agent.model.Role;

public interface RoleService {

	public Role findOneByName(String name);

	public Role saveRole(Role role);

	public void deleteAll();

}
