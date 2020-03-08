package com.jubiledu.backend_apirest.models.services;

import com.jubiledu.backend_apirest.models.entity.Cliente;

import java.util.List;

public interface ClienteService {

    public List<Cliente> findAll();
}
