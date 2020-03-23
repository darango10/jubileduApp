package com.jubiledu.backend_apirest.models.dao;

import com.jubiledu.backend_apirest.models.entity.Role;
import com.jubiledu.backend_apirest.models.entity.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface RoleDao extends CrudRepository<Role, Long> {

    public Role findByNombre(String nombre);
}
