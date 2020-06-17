package com.rentacar.auth_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rentacar.auth_service.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

	Role findOneById(Long id);

}
