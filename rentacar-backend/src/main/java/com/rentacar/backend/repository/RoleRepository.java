package com.rentacar.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rentacar.backend.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

	Role findOneByName(String name);

}
