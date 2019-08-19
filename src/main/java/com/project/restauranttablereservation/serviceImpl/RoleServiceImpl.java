/**
 * 
 */
package com.project.restauranttablereservation.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.restauranttablereservation.exceptions.RecordNotFoundException;
import com.project.restauranttablereservation.models.Role;
import com.project.restauranttablereservation.repositories.RoleRepository;
import com.project.restauranttablereservation.service.RoleService;

/**
 * @author sivasaiv
 *
 */
@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	RoleRepository roleRepository;
	
	@Override
	public Role getRole(String roleName) {
		
	Role role = roleRepository.findByRoleName(roleName);
	if(null == role) {
		throw new RecordNotFoundException("Role not found :"+ roleName);
	}
	return role;
	}

}
