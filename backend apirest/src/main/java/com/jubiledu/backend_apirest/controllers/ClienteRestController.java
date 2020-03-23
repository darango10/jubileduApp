package com.jubiledu.backend_apirest.controllers;

import com.jubiledu.backend_apirest.models.entity.Cliente;
import com.jubiledu.backend_apirest.models.entity.Role;
import com.jubiledu.backend_apirest.models.entity.Usuario;
import com.jubiledu.backend_apirest.models.services.ClienteService;
import com.jubiledu.backend_apirest.models.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class ClienteRestController {

    @Autowired
    private ClienteService clienteService;


    @Secured({"ROLE_ADMIN"})
    @GetMapping("/clientes")
    public List<Cliente> index() {
        return clienteService.findAll();
    }

    @Secured({"ROLE_ADMIN"})
    @GetMapping("/clientes/registro/{id}")
    public ResponseEntity<?> show(@PathVariable Long id) {
        Cliente cliente = null;
        Map<String, Object> response = new HashMap<>();
        try {
            cliente = clienteService.findById(id);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la consulta en la base de datos.");
            response.put("mensaje", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if (cliente == null) {
            response.put("mensaje", "El cliente con ID: " + id + " no existe.");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(cliente, HttpStatus.OK);

    }

    @PostMapping("/clientes")
    public ResponseEntity<?> create(@Valid @RequestBody Cliente cliente, BindingResult result) {
        Cliente clienteNew = null;
        Usuario usuarioNew = null;
        Map<String, Object> response = new HashMap<>();


        if (result.hasErrors()) {

//            List<String> errors = new ArrayList<>();
//            for (FieldError err :
//                    result.getFieldErrors()) {
//                errors.add("El campo " + err.getField() + " " + err.getDefaultMessage());
//            }

            List<String> errors = result.getFieldErrors()
                    .stream()
                    .map(err ->
                            "El campo " + err.getField() + " " + err.getDefaultMessage())
                    .collect(Collectors.toList());

            response.put("errors", errors);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

        try {
            clienteNew = clienteService.save(cliente);


        } catch (DataAccessException e) {
            response.put("mensaje", "Error al crear el cliente en la base de datos.");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El cliente ha sido creado con exito.");
        response.put("cliente", clienteNew);
        response.put("usuario", usuarioNew);
        return new ResponseEntity<Map>(response, HttpStatus.CREATED);
    }

    @Secured({"ROLE_ADMIN"})
    @PutMapping("/clientes/registro/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody Cliente cliente, BindingResult result, @PathVariable Long id) {

        Cliente clienteUpdated = null;
        Cliente clienteActual = clienteService.findById(id);
        Map<String, Object> response = new HashMap<>();

        if (result.hasErrors()) {

            List<String> errors = result.getFieldErrors()
                    .stream()
                    .map(err ->
                            "El campo " + err.getField() + " " + err.getDefaultMessage())
                    .collect(Collectors.toList());

            response.put("errors", errors);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

        if (clienteActual == null) {
            response.put("mensaje", "El cliente con ID: " + id + " no existe.");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }

        try {

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

            clienteUpdated = clienteService.save(clienteActual);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al editar el cliente en la base de datos.");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El cliente ha sido actualizado con exito.");
        response.put("cliente", clienteUpdated);
        return new ResponseEntity<Map>(response, HttpStatus.CREATED);

    }

    @Secured({"ROLE_ADMIN"})
    @DeleteMapping("clientes/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {

        Map<String, Object> response = new HashMap<>();
        try {
            clienteService.delete(id);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al eliminar el cliente en la base de datos.");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El cliente ha sido eliminado con exito.");
        return new ResponseEntity<Map>(response, HttpStatus.OK);


    }
}
