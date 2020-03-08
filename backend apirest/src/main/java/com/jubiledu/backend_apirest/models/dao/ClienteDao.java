package com.jubiledu.backend_apirest.models.dao;

import com.jubiledu.backend_apirest.models.entity.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteDao extends CrudRepository<Cliente, Long> {
}
