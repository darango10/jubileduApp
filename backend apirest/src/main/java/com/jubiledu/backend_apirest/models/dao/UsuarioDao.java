package com.jubiledu.backend_apirest.models.dao;

import com.jubiledu.backend_apirest.models.entity.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioDao extends CrudRepository<Usuario, Long> {

    public Usuario findByUsername(String username);
}
