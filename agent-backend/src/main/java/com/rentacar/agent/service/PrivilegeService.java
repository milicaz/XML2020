package com.rentacar.agent.service;

import com.rentacar.agent.model.Privilege;

public interface PrivilegeService {

	public Privilege save(Privilege privilege);

	public void deleteAll();

	public void deleteRolePrivilege();

}
