package com.jubiledu.backend_apirest.models.services;

import com.jubiledu.backend_apirest.models.dao.ClienteDao;
import com.jubiledu.backend_apirest.models.dao.RoleDao;
import com.jubiledu.backend_apirest.models.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;


    @Override
    public Role findByNombre(String nombre) {
        return roleDao.findByNombre(nombre);
    }
}
