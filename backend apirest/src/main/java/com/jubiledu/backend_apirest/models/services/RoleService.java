package com.jubiledu.backend_apirest.models.services;

import com.jubiledu.backend_apirest.models.entity.Role;
import com.jubiledu.backend_apirest.models.entity.Usuario;

public interface RoleService {

    public Role findByNombre(String nombre);

}
