package com.project.restauranttablereservation.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.restauranttablereservation.models.Role;

@Transactional
public interface RoleRepository extends JpaRepository<Role, Integer>{

    public Role  findByRoleName(String roleName);
}
