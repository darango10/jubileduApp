package com.jubiledu.backend_apirest.controllers;

import com.jubiledu.backend_apirest.models.entity.Cliente;
import com.jubiledu.backend_apirest.models.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class ClienteRestController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/clientes")
    public List<Cliente> index() {
        return clienteService.findAll();
    }

    @GetMapping("/clientes/registro/{id}")
    public Cliente show(@PathVariable Long id) {
        return clienteService.findById(id);
    }

    @PostMapping("/clientes")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente create(@RequestBody Cliente cliente) {
        return clienteService.save(cliente);
    }

    @PutMapping("/clientes/registro/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente update(@RequestBody Cliente cliente, @PathVariable Long id) {
        Cliente clienteActual = clienteService.findById(id);

        clienteActual.setCedula(cliente.getCedula());
        clienteActual.setNombre(cliente.getNombre());
        clienteActual.setApellido(cliente.getApellido());
        clienteActual.setEmail(cliente.getEmail());
        clienteActual.setPassword(cliente.getPassword());
        clienteActual.setFecha(cliente.getFecha());
        clienteActual.setTelefono(cliente.getTelefono());
        clienteActual.setGenero(cliente.getGenero());
        clienteActual.setSemanas(cliente.getSemanas());
        clienteActual.setSalario(cliente.getSalario());

        return clienteService.save(clienteActual);
    }

    @DeleteMapping("clientes/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        clienteService.delete(id);
    }
}
