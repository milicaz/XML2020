package com.rentacar.agent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.rentacar.agent.model.Privilege;

@Repository
public interface PrivilegeRepository extends JpaRepository<Privilege, Long> {

	@Query(value = "DELETE FROM privilegije_uloga", nativeQuery = true)
	void deleteRolePrivilege();
}
