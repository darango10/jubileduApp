package com.jubiledu.backend_apirest.models.services;

import com.jubiledu.backend_apirest.models.entity.Usuario;

public interface IUsuarioService {

    public Usuario findByUsername(String username);
}
